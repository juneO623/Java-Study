package kr.hs.dgsw.network.test01.n2304.Client;

import java.io.*;
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

    public static void main(String[] args) {

        String id = null;
        String pw = null;
        String msg;

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
                System.out.println("시발");
                System.out.println(msg);
                if (msg.equals("Login Fail")){
                    System.out.println("** ID 또는 PASS가 틀렸습니다.! **");
                }
                else{
                    break;
                }
            }
            System.out.println("** FTP 서버에 접속하였습니다. **");


//            LoginClient login = new LoginClient(sc);
//            login.login();

//            System.out.println("서버에 접속되었습니다.");



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
