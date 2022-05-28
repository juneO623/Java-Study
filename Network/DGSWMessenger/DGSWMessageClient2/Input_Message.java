package kr.hs.dgsw.network.teacherCode.d0523.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Input_Message extends Thread {
	private Socket sc = null;

	
	public Input_Message(Socket sc) {
		this.sc = sc;
	}
	
	public void run() {
		try {
			InputStream is = sc.getInputStream();		// ?´?¼?´?–¸?Š¸ ë©”ì‹œì§? ?…? ¥ ë°›ìŒ
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			boolean loginboolean=true;
			while(loginboolean) {
				String brmsg = br.readLine();
				
				String msgType = "";	
				String msgFromNick = "";
				String msgBeforeNick = "";
				String msgAfterNick = "";
				String msgJoinCount = "";
				String msgMessage = "";
				if(brmsg.equals("[Start]")) {
					brmsg = br.readLine();
					String[] brmsgarr = brmsg.split("::");
					if(brmsgarr[0].equals("Type")) {
						msgType = brmsgarr[1];
					} else {
						System.out.println("?ˆ˜?‹  ë©”ì‹œì§?ê°? ?´?ƒ?•©?‹ˆ?‹¤.");
						continue;
					}
					
					while(!(brmsg = br.readLine()).equals("[End]")) {
						brmsgarr = brmsg.split("::");
						switch(brmsgarr[0]) {
						case "FromNick":
							msgFromNick = brmsgarr[1]; break;
						case "BeforeNick":
							msgBeforeNick = brmsgarr[1]; break;
						case "AfterNick":
							msgAfterNick = brmsgarr[1]; break;
						case "JoinCount":
							msgJoinCount = brmsgarr[1]; break;
						
						case "Message":
							msgMessage = "";
							while(!(brmsg = br.readLine()).equals("::Message")) {
								msgMessage += brmsg + "\r\n";
							}
							msgMessage = msgMessage.substring(0,msgMessage.length()-2);
							break;
						default:
							break;
						}
					}
					
					switch(msgType) {
						case "LogIn":
							System.out.println("[" + msgFromNick + "] ? ‘?†?•˜???Šµ?‹ˆ?‹¤.");
							break;
						case "LogOutOK":
							System.out.println("ë¡œê·¸?•„?›ƒ?•˜???Šµ?‹ˆ?‹¤.");
							loginboolean = false;
							break;
						case "LogOut":
							System.out.println("[" + msgFromNick + "] ?‚¬?š©?ê°? ë¡œê·¸?•„?›ƒ?•˜???Šµ?‹ˆ?‹¤.");
							break;
						case "NickNameOK":
							System.out.println("?‹‰?„¤?„?„ [" + msgAfterNick + "]ë¡? ë³?ê²½í•˜???Šµ?‹ˆ?‹¤.");
							break;
						case "NickNameOverlap":
							System.out.println("?‹‰?„¤?„?„ [" + msgAfterNick + "]?Š” ?´ë¯? ?‚¬?š©ì¤‘ì…?‹ˆ?‹¤.");
							break;
						case "NickNameInform":
							System.out.println("[" + msgBeforeNick + "] ?‚¬?š©?ê°? ?‹‰?„¤?„?„ [" + msgAfterNick + "]ë¡? ë³?ê²½í•˜???Šµ?‹ˆ?‹¤.");
							break;
						case "Whisper":
							System.out.println("[ê·“ì†ë§?] " + msgFromNick + ": " + msgMessage);
							break;
						case "WhisperOK":
							System.out.println("[ê·“ì†ë§?] ? „?†¡ ?„±ê³?");
							break;
						case "WhisperWhithout":
							System.out.println("[ê·“ì†ë§?] ? „?†¡ ?‹¤?Œ¨ / ?‹‰?„¤?„?´ ?—†?Šµ?‹ˆ?‹¤.");
							break;
						case "AllMessage":
							System.out.println(msgFromNick + ": " + msgMessage);
							break;
						case "NickList":
							System.out.println("? ‘?†??ˆ˜: "+ msgJoinCount);
							System.out.println("[? ‘?†?ë¦¬ìŠ¤?Š¸]");
							System.out.println(msgMessage);
							System.out.println("[? ‘?†?ë¦¬ìŠ¤?Š¸?]");
							break;
						default:
							break;
					}
				}
			}
		} catch(Exception e) {
			System.out.println("?—°ê²? ì¢…ë£Œ");
			e.printStackTrace();
		}
	}
}