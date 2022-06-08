package TTTest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Objects;

public class ServerMain {

    static String ID = null;
    static String PW = null;
    static Socket sc = null;
    static String sendFileData = "";
    static String commandLine;
    static String command;
    static String command_O;

    public void sendMsg(String str, Socket sc){
        byte[] data = str.getBytes(StandardCharsets.UTF_8);
        OutputStream os = null;
        try {
            os = sc.getOutputStream();
            os.write(data);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String receiveMsg(Socket sc) throws IOException{
        InputStream is = sc.getInputStream();
        byte[] bytes = new byte[1024];
        int byteSiz = is.read(bytes);
        return new String(bytes, 0, byteSiz);
    }


    public String fileLengthConverter(long size){
        String sizeStr;
        if (size >= 1024 * 1024 * 1024){
            size /= (1024 * 1024 * 1024);
            sizeStr = String.valueOf(size) + "G";
        } else if (size >= 1024 * 1024){
            size /= (1024 * 1024);
            sizeStr = String.valueOf(size) + "M";
        } else if ( size >= 1024){
            size /= 1024;
            sizeStr = String.valueOf(size) + "K";
        } else {
            sizeStr = String.valueOf(size);
        }
        return  sizeStr;
    }

    public String combineSendFileList(File file){
        String fileData = "";

        fileData += String.format("%s", file.getName() + "%");
        fileData += String.format("%s\n,", fileLengthConverter(file.length()));


//        System.out.print("- " + file.getName() + "  ");
//        System.out.print(fileLengthConverter(file.length()));
//        System.out.println();

        return fileData;
    }


    public static void main(String[] args) throws IOException {

        ServerSocket ssc = null;

        ServerMain sm = new ServerMain();

        String fileDirectory = "D:\\FTP_Storage";
        File dir = new File(fileDirectory);

        try {
            ssc = new ServerSocket(5000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("접속 대기중 ~ (1: 파일목록, 2: 업로드, 3: 다운로드, 4: 접속종료");
        try {
            sc = ssc.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {


                ID = sm.receiveMsg(sc);
                PW = sm.receiveMsg(sc);

//                System.out.println(ID);
//                System.out.println(PW);

                if (sm.login(ID, PW)){
                    sm.sendMsg("Login Success", sc);
                    System.out.println("누군가 접속하였습니다.");
                    break;
                }
                else{
                    sm.sendMsg("Login Fail", sc);
                    System.out.println("로그인 실패");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("로그인에 성공했습니다.");

        try {
            commandLine = sm.receiveMsg(sc);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(commandLine);

        if (!commandLine.contains(" ")){     // (commandLine.indexOf(" ") != -1)
                command = commandLine;
        }
        else {
            command = commandLine.split(" ", 2)[0];
            command_O = commandLine.split(" ", 2)[1];
        }

//        System.out.println("1- " + command);
//        System.out.println("2- " + command_O);

        switch (command){
            case "/파일목록":
                for (File fileList : Objects.requireNonNull(dir.listFiles())){
//                    sm.sendMsg(fileList.getName() + "  " +  Files.size(fileList.toPath()), sc);
                    sendFileData += sm.combineSendFileList(fileList);
                }
                sm.sendMsg(sendFileData, sc);

                System.out.printf("%s - 1\n", sc.getInetAddress());
                break;
        }




//        System.out.println(sendFileData);
//        sm.sendMsg(sendFileData, sc);





        while(true){


//            try {
//                Thread.sleep(5000);
//                System.out.println("hello");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    public boolean login(String ID, String PW){
        return ID.equals("admin") && PW.equals("1234");
    }



}
