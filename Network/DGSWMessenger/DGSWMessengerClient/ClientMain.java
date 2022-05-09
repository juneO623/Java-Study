package kr.hs.dgsw.network.class23.teacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			Socket sc = new Socket("127.0.0.1",5000);
			
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
			
			
				
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
