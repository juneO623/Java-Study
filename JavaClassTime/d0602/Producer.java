package kr.hs.dgsw.java.dept23.d0602;

import java.util.Random;

public class Producer implements Runnable {

	private final Buffer buffer;
	
	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		Random random = new Random();
		
		while (true) {
			
			try {
				Thread.sleep(1000 + random.nextInt(2000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			int value = random.nextInt();
			System.out.println("»ý¼ºÀÚ : " + value);
			buffer.add(value);
			
		}
		
	}

	
	
}
