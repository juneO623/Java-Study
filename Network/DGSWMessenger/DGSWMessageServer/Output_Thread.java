package kr.hs.dgsw.network.class23;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Output_Thread extends Thread {

	Socket sc = null;
	
	public Output_Thread(Socket sc) {
		this.sc = sc;
	}
	public void run() {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			OutputStream os = null;
			try {
				os = sc.getOutputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PrintWriter pw = new PrintWriter(os, true);

			pw.println(scan.next());
		}
	}
}
