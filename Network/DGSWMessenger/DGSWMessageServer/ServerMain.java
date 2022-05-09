package kr.hs.dgsw.network.class23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import kr.hs.dgsw.network.class23.teacher.Input_Thread;
import kr.hs.dgsw.network.class23.teacher.Output_Thread;

public class ServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss = new ServerSocket(5000);

			Socket sc = ss.accept();
			System.out.println("누군가가 접속하였어요~");
			
			InputStream is = sc.getInputStream();		// Ŭ���̾�Ʈ �޽��� �Է� ����

			Thread ot = new Output_Thread(sc);
			ot.start();
			
			Thread it = new Input_Thread(sc);
			it.start();
			
			try {
				ot.join();
				it.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
