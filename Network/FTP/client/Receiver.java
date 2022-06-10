package kr.hs.dgsw.network.test01.n2304.client;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Objects;

public class Receiver extends Thread {
    Socket sc;
    DataInputStream dis;

    Receiver(Socket sc) {
        this.sc = sc;
        try {
            dis = new DataInputStream(sc.getInputStream());
        } catch (IOException e) {}
    }

    @Override
    public void run() {
        while (dis != null) {
            try {
                String[] commands = dis.readUTF().split("!!");
                switch (commands[0]) {
                    case "[LOGIN]": {
                        if (Objects.equals(commands[1], "SUCCESS")) {
                            ClientMain.IS_LOGIN_SUCCESS = true;
                        } else if (Objects.equals(commands[1], "FAIL")){
                            System.out.println("로그인에 실패했습니다\n다시 입력해주세요");
                            ClientMain.IS_LOGIN_SUCCESS = false;
                        }
                        ClientMain.IS_LOADING = false;
                        break;
                    }
                    case "[FILE_LIST]": {
                        if (commands[1].equals("[EXIST]")) {
                            System.out.println(commands[2] + "     " + commands[3]);
                        } else {
                            System.out.println("폴더가 비었습니다.");
                        }
                        break;
                    }
                    case "[UPLOAD]":{
                        System.out.println("업로드에 성공하였습니다.");
                        break;
                    }
                    case "[DOWNLOAD]":{
                        if (commands[1].equals("UNEXIST")) {
                            System.out.println("그런 이름의 파일이 존재하지 않습니다.");
                        } else {
                            System.out.println("파일을 다운로드 합니다.");
                            File file = new File("D:\\FTP_Download_Location" + "\\" + commands[2]);
                            receiveFile(file);
                        }
                        break;
                    }
                    default: {
                        System.out.println(commands[0]);
                        break;
                    }
                }
            } catch (IOException e) { }
        }
    }

    private void receiveFile(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);

        byte[] bytes = new byte[1024];
        int readBit = 0;
        while(true){
            readBit = dis.read(bytes);
            fos.write(bytes, 0, readBit);
            if (readBit != 1024)
                break;
        }
        System.out.println("파일 다운로드가 완료되었습니다.");
        fos.close();
    }
}
