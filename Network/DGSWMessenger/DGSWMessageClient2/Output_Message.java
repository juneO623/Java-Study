package kr.hs.dgsw.network.teacherCode.d0523.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Output_Message extends Thread {
	private Socket sc = null;
	
	public Output_Message(Socket sc) {
		this.sc = sc;
	}
	
	public void run() {
		Scanner scan = new Scanner(System.in);

		OutputStream os = null;
		
		try {
			os = sc.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter pw = new PrintWriter(os, true);
		
		try {
			String msg = "";
			String sandmsg ="";
			boolean loginboolean = true;
			while((loginboolean == true) && ((msg=scan.nextLine())!=null) ){
				if(msg.substring(0,1).equals("/")){
					String type = "";
					if(msg.indexOf(' ') != -1) {
						type = msg.substring(1, msg.indexOf(' ')).trim();
						msg = msg.substring(msg.indexOf(' ')).trim();
					} else {
						type = msg.substring(1);
					 }
					switch(type) {
						case "Î°úÍ∑∏?ïÑ?õÉ":
							sandmsg = "[Start]\r\n"
									+"Type::LogOut\r\n"
									+"[End]";
							loginboolean = false;
							break;
						case "?ãâ?Ñ§?ûÑ":
							sandmsg = "[Start]\r\n"
									+ "Type::NickName\r\n"
									+ "NickName::" + msg +"\r\n"
									+ "[End]";
							break;
						case "Í∑ìÏÜçÎß?":
							sandmsg ="[Start]\r\n"
									+ "Type::Whisper\r\n"
									+ "ToNick::"+ msg.substring(0,msg.indexOf(' ')).trim() +"\r\n"
									+ "Message::\r\n"
									+ msg.substring(msg.indexOf(' ')).trim() +"\r\n"
									+ "::Message\r\n"
									+ "[End]";
							break;
						case "?†ë?Üç?òÑ?ô©":
							sandmsg ="[Start]\r\n"
									+ "Type::NickList\r\n"
									+ "[End]";
							break;
					}
				} else {
					sandmsg = "[Start]\r\n"
							+ "Type::AllMessage\r\n"
							+ "Message::\r\n"
							+ msg + "\r\n"
							+ "::Message\r\n"
							+ "[End]";
				}
				pw.println(sandmsg);
			}
		} catch(Exception e) {
			System.out.println("?†ë?Üç Ï¢ÖÎ£å");
			e.printStackTrace();
		}
	}
}