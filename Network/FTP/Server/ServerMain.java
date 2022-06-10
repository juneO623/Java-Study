package kr.hs.dgsw.network.test01.n2304.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;

public class ServerMain {

    HashMap clients;
    DataOutputStream dos;

    ServerMain() {
        clients = new HashMap();
        Collections.synchronizedMap(clients);
    }


    public void serverStart() {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(5000);
            System.out.println("서버 시작");

            while (true) {
                socket = serverSocket.accept();
                System.out.println(socket.getInetAddress() + "에서 접속하였습니다.");
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void sendDefault(InetAddress ip, String message) {
        dos = (DataOutputStream) clients.get(ip);
        try {
            dos.writeUTF(message);
        } catch (IOException e) { }
    }

    void sendLoginResult(InetAddress ip, String id, String pw) {
        dos = (DataOutputStream) clients.get(ip);

        try {
            if (id.equals("admin") && pw.equals("1234")) {
                dos.writeUTF("[LOGIN]!!" + "SUCCESS");
                System.out.println(ip + " 님이 로그인에 성공하였습니다.");
            } else {
                dos.writeUTF("[LOGIN]!!" + "FAIL");
            }
        } catch (IOException e) { }
    }

    void sendFileList(InetAddress ip, String fileName, String fileSize, Boolean isFileExist) {
        dos = (DataOutputStream) clients.get(ip);
        try {
            if (isFileExist)
                dos.writeUTF("[FILE_LIST]!!" +
                        "[EXIST]!!" +
                        fileName +
                        "!!" +
                        fileSize
                );
            else {
                dos.writeUTF("[FILE_LIST]!!" + "[UNEXIST]");
            }
        } catch (IOException e) { }
    }

    void uploadResult(InetAddress ip, String msg){
        dos = (DataOutputStream) clients.get(ip);
        try {
            dos.writeUTF("[UPLOAD]!!+" + msg);
        } catch (IOException e) { }
    }

    void downLoadResult(InetAddress ip, String msg){
        dos = (DataOutputStream) clients.get(ip);
        try{
            dos.writeUTF("[DOWNLOAD]!!" + msg);
        } catch (IOException e){ }
    }

    public static void main(String[] args) throws IOException {
        new ServerMain().serverStart();
    }
}
