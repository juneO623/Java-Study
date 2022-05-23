package kr.hs.dgsw.network.filecopy.server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileCopyServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss= new ServerSocket(5000);
		Socket sc = ss.accept();
		
		InputStream is = sc.getInputStream();
		BufferedInputStream bir = new BufferedInputStream(is);
		DataInputStream dis = new DataInputStream(bir);
		
		String filename = dis.readUTF();
		
		FileOutputStream fos = new FileOutputStream("D:\\temp\\" + filename);
		
		byte[] bytes = new byte[1024];
		int readbit = 0;
		while((readbit = dis.read(bytes)) != -1)
			fos.write(bytes,0,readbit);
		
		System.out.println("파일전송 성공");
		
	}

}