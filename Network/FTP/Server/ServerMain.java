package kr.hs.dgsw.network.test01.n2304.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    static String ID = null;
    static String PW = null;

    public static void main(String[] args) {

        ServerSocket ssc = null;

        ServerMain sm = new ServerMain();

        try {
            ssc = new ServerSocket(5000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("접속 대기중 ~ ");

        while (true) {
            try {
                Socket sc = ssc.accept();
//                System.out.println("사용자 접속 했습니다");
//                System.out.println("Client ip : " + sc.getInetAddress());

                InputStream is = sc.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(is);
                DataInputStream dis = new DataInputStream(bis);

                OutputStream os = sc.getOutputStream();
                BufferedOutputStream bos = new BufferedOutputStream(os);
                DataOutputStream dos = new DataOutputStream(bos);


                ID = dis.readUTF();
                PW = dis.readUTF();

                if (sm.login(ID, PW)){
                    dos.writeUTF("Login Success");
                    dos.flush();
                    System.out.println("누군가 접속하였습니다.");
                    break;
                }
                else{
                    dos.writeUTF("Login Fail");
                    dos.flush();
                    System.out.println("병신 한명 추가");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("로그인에 성공했습니다.");
    }

    public boolean login(String ID, String PW){
        return ID.equals("admin") && PW.equals("1234");
    }



}
