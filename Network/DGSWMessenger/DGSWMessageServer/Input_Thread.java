package kr.hs.dgsw.network.class23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Input_Thread extends Thread {
	Socket sc = null;
	
	public Input_Thread(Socket sc) {
		this.sc = sc;
	}
	public void run() {
		while(true) {
			InputStream is = null;
			try {
				is = sc.getInputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		// 클라이언트 메시지 입력 받음
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			try {
				System.out.println(br.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
