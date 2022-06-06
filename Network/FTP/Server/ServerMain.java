package TTTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerMain {

    static String ID = null;
    static String PW = null;
    static Socket sc = null;

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

        ServerSocket ssc = null;

        ServerMain sm = new ServerMain();

        try {
            ssc = new ServerSocket(5000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("접속 대기중 ~ ");
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
        while(true){
            try {
                Thread.sleep(5000);
                System.out.println("hello");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean login(String ID, String PW){
        return ID.equals("admin") && PW.equals("1234");
    }



}
