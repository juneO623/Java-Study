package kr.hs.dgsw.network.test01.n2304.server;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.file.Files;

public class ServerThread extends Thread {

    File file;
    InetAddress ip;
    DataInputStream dis;
    DataOutputStream dos;
    ServerMain serverMain = new ServerMain();
    Socket sc = null;
    String fileDirectory = "D:\\FTP_Storage";

    public ServerThread(Socket sc) {
        this.sc = sc;
        file = new File(fileDirectory);
        ip = sc.getInetAddress();

        try {
            dis = new DataInputStream(sc.getInputStream());
            dos = new DataOutputStream(sc.getOutputStream());
        } catch (IOException e) {
        }
    }

    @Override
    public void run() {
        try {
            serverMain.clients.put(sc.getInetAddress(), dos);
            while (dis != null) {
                executeCommand();
            }
        } catch (IOException e) {
        } finally {
            System.out.println(sc.getInetAddress() + " 나감");
            serverMain.clients.remove(sc.getInetAddress());
        }
    }

    /**
     * 프로토콜 명령어 구분 함수
     *
     * @throws IOException
     */
    private void executeCommand() throws IOException {
        String[] commands = dis.readUTF().split("!!");

        switch (commands[0]) {
            case "[LOGIN]": {
                serverMain.sendLoginResult(ip, commands[1], commands[2]);
                break;
            }
            case "[FILE_LIST]": {
                System.out.println(ip + " 님이 [FILE_LIST] 명령어를 실행하였습니다.");
                File[] files = file.listFiles();

                if (files == null) {
                    serverMain.sendFileList(ip, "", "", false);
                    break;
                }
                for (File file : files) {
                    Long fileSize = Files.size(file.toPath()) / 1024;
                    String fileSizeKB = fileSize + "KB";
                    serverMain.sendFileList(ip, file.getName(), fileSizeKB, true);
                }
                break;
            }
            case "[UPLOAD]": {
                FileOutputStream fos = new FileOutputStream(fileDirectory + "\\" + commands[1]);

                byte[] bytes = new byte[1024];
                int readBit = 0;
                while (true) {
                    readBit = dis.read(bytes);
                    fos.write(bytes, 0, readBit);
                    if (readBit != 1024)
                        break;
                }
                fos.close();

                System.out.println(ip + " 님이 [UPLOAD] 명령어를 실행하였습니다.");
                serverMain.uploadResult(ip, "업로드에 성공했습니다.");

                break;
            }
            case "[DOWNLOAD]": {
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(fileDirectory + "\\" + commands[1]);
                } catch (FileNotFoundException fe) {
                    dos.writeUTF("[DOWNLOAD]!!UNEXIST");
                    break;
                }

                dos.writeUTF("[DOWNLOAD]!!EXIST!!" + commands[1]);
                byte[] bytes = new byte[1024];
                int readBit = 0;
                while ((readBit = fis.read(bytes)) != -1) {
                    dos.write(bytes, 0, readBit);
                }
                fis.close();
                break;
            }
            default: {
                serverMain.sendDefault(sc.getInetAddress(), "알 수 없는 명령어입니다.");
            }
        }
    }
}
