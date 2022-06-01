package kr.hs.dgsw.network.test01.n2304.Client;

import kr.hs.dgsw.network.test01.n2304.Server.ServerMain;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) {

        String id = null;
        String pw = null;
        String msg = null;

        Scanner scanner = new Scanner(System.in);

        try {
            Socket sc = new Socket("127.0.0.1", 5000);

            OutputStream os = sc.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            InputStream is = sc.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);

            while(true) {
                System.out.print("ID: ");
                dos.writeUTF(scanner.next());
                dos.flush();
                System.out.print("PASS: ");
                dos.writeUTF(scanner.next());
                dos.flush();
                msg = dis.readUTF();
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
