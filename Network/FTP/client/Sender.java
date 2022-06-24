package kr.hs.dgsw.network.test01.n2304.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Locale;
import java.util.Scanner;

public class Sender extends Thread {

    Socket sc;
    InetAddress ip;
    DataOutputStream dos;
    DataInputStream dis;
    Scanner scan;

    Sender(Socket sc) {
        this.sc = sc;
        try {
            dos = new DataOutputStream(sc.getOutputStream());
            this.ip = sc.getInetAddress();
        } catch (Exception e) {}
    }

    @Override
    public void run() {
        scan = new Scanner(System.in);
        try {
            while (true) {
                if (ClientMain.IS_LOGIN_SUCCESS)
                    break;
                System.out.print("ID : ");
                String id = scan.nextLine();
                System.out.print("PW : ");
                String pw = scan.nextLine();

                dos.writeUTF("[LOGIN]!!" + id + "!!" + pw);

                ClientMain.IS_LOADING = true;
                while (ClientMain.IS_LOADING){}
            }

            System.out.println("FTP 서버에 접속하였습니다.");
            System.out.println("명령어를 입력해주세요.");

            while (dos != null) {
                String command = scan.nextLine();
                commandArrangement(command);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void commandArrangement(String command) throws IOException {
        String[] commands = command.split(" ");

        switch (commands[0].toLowerCase(Locale.ROOT)) {
            case "/filelist": {
                dos.writeUTF("[FILE_LIST]");
                break;
            }
            case "/upload": {
                if (commands.length <= 1) {
                    System.out.println("잘못된 명령어 형식입니다.");
                    System.out.println("/upload \"파일경로\" (저장할 이름)    <-- 이 형식으로 작성해주세요");
                } else {
                    File file = new File(commands[1]);
                    if (file.exists()) {
                        if (commands.length == 2) {
                            dos.writeUTF("[UPLOAD]!!" + file.getName());;
                        } else {
                            dos.writeUTF("[UPLOAD]!!" + commands[2]);
                        }
                        sendFile(file);
                    } else {
                        System.out.println("파일이 존재하지 않습니다.");
                    }
                }
                break;
            }
            case "/download": {
                if (commands.length != 2){
                    System.out.println("잘못된 명령어 형식입니다.");
                }
                else {
                    dos.writeUTF("[DOWNLOAD]!!" + commands[1]);
                }
                break;
            }
            case "/exit": {
                System.exit(0);
            }
            default: {
                dos.writeUTF("이상한거");
            }
        }
    }

    private void sendFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);

        dos.writeLong(file.length());

        byte[] bytes = new byte[1024];
        int readBit = 0;
        while ((readBit = fis.read(bytes)) != -1) {
            dos.write(bytes, 0, readBit);
        }
        fis.close();
    }
}
