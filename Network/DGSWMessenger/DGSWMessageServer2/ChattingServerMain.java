package kr.hs.dgsw.network.teacherCode.d0523.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class ChattingServerMain {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(5000);  	// ?„œë²? ?‹œ?‘(?´?¼?´?–¸?Š¸ ? ‘?† ??ê¸?)

			System.out.println("?„œë²„ê? ?‹œ?‘?˜?—ˆ?Šµ?‹ˆ?‹¤.");
			
			while(true) {
				Socket sc = ss.accept();
				System.out.println(sc.getInetAddress() +": ? ‘?†?•˜???Šµ?‹ˆ?‹¤.");
				
				try {
					// ?°?´?„° ì£¼ê³  ë°›ëŠ” ê°ì²´ ?ƒ?„±
					ClientAccept ca = new ClientAccept(sc);
					
					Thread ct = new ClientThread(sc.getInetAddress().toString(), ca);
					ct.start();
				} catch(Exception e) {
					System.out.println("?—°ê²? ì¢…ë£Œ");
				}
			}
		} catch(Exception e) {
		} finally {
			try {
				ss.close();
			} catch(IOException e) {}
		}
	}
}