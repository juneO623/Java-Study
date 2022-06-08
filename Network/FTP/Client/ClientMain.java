package TTTest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ClientMain {

    Socket sc = null;
//    private final InputStream is = null;

//    public void sendMsg(String str, Socket sc){
//        byte[] data = str.getBytes(StandardCharsets.UTF_8);
//        OutputStream os = null;
//        try {
//            os = sc.getOutputStream();
//            os.write(data);
//            os.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public String receiveMsg(Socket sc) throws IOException{
//        InputStream is = sc.getInputStream();
//        byte[] bytes = new byte[1024];
//        is.read(bytes);
//        String str = new String(bytes, StandardCharsets.UTF_8);
//        return str;
//    }

    // ----------------------

//    public void sendMsg(String str, Socket sc) throws IOException {
//        OutputStream os = sc.getOutputStream();
////        BufferedOutputStream bos = new BufferedOutputStream(os);
////        DataOutputStream dos = new DataOutputStream(bos);
//        DataOutputStream dos = new DataOutputStream(os);
//        dos.writeUTF(str);
//        dos.flush();
//    }
//
//    public String receiveMsg(Socket sc) throws IOException{
//        InputStream is = sc.getInputStream();
////        BufferedInputStream bis = new BufferedInputStream(is);
//        DataInputStream dis = new DataInputStream(is);
//
//        return dis.readUTF();
//    }

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

    public void showFileList(File file){
        System.out.print("- " + file.getName() + "  ");
        System.out.print(fileLengthConverter(file.length()));
        System.out.println();
    }


    public static void main(String[] args) {

        String id = null;
        String pw = null;
        String msg;
        String fileData;

        Scanner scanner = new Scanner(System.in);
        ClientMain cm = new ClientMain();

        try {
            Socket sc = new Socket("127.0.0.1", 5000);

            while(true) {

                System.out.print("ID: ");
                cm.sendMsg(scanner.next(), sc);

                System.out.print("PASS: ");
                cm.sendMsg(scanner.next(), sc);

                msg = cm.receiveMsg(sc);
//                System.out.println(msg);
                if (msg.equals("Login Fail")){
                    System.out.println("** ID 또는 PASS가 틀렸습니다.! **");
                }
                else{
                    break;
                }
            }
            System.out.println("** FTP 서버에 접속하였습니다. **");


            String fileDirectory = "D:\\FTP_Storage";
            File dir = new File(fileDirectory);


            while(true){

                String commandLine = scanner.nextLine();
                cm.sendMsg(commandLine, sc);
                String command = commandLine.split(" ", 2)[0];
//                String command_O = commandLine.split(" ", 2)[1];


                switch(command){
                    case "/파일목록":
//                        for (File fileList : dir.listFiles()){
//                            cm.showFileList(fileList);
//                        }
                        fileData = cm.receiveMsg(sc);
//                        System.out.println(fileData);
//                        System.out.println("---------------");
                        String[] DataList = fileData.split("\n,");
                        for (String datalist : DataList){
                            System.out.print("- " + datalist.split("%")[0] + " ");
                            System.out.println(datalist.split("%")[1]);
                        }
                        break;
                    case "/접속종료":
                        return;
//                    case "\n":
//                        System.out.println("엔터입니다");
//                        break;
//                    case "\0":
//                        System.out.println("널입니다");
//                        break;
                    default:
                        System.out.println("없는 명령어 입니다.");
                        break;
                }

//                if (commandLine.equals("/접속종료")){
//                    break;
//                }
            }


//            LoginClient login = new LoginClient(sc);
//            login.login();

//            System.out.println("서버에 접속되었습니다.");



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
