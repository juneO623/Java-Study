package kr.hs.dgsw.network.test01.n2304.client;

import java.net.ConnectException;
import java.net.Socket;

public class ClientMain {
    static Boolean IS_LOGIN_SUCCESS = false;
    static Boolean IS_LOADING = false;

    public static void main(String[] args) {
        try {
            String serverIp = "127.0.0.1";
            Socket sc = new Socket(serverIp, 5000);
            System.out.println("서버 접속");

            Thread sender = new Thread(new Sender(sc));
            Thread receiver = new Thread(new Receiver(sc));

            sender.start();
            receiver.start();
        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (Exception e) {}
    }
}