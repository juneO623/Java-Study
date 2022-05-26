package kr.hs.dgsw.java.dept23.d0526;

import java.util.Random;

public class FirstThread extends Thread {

	private final String name;
	
	public FirstThread(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		
		for (int i=0; i<10; i++) {
			
			System.out.printf("%s : %d\n", name, i);
			
			try {
				Thread.sleep(new Random().nextInt(500) + 1000);	
			}catch(InterruptedException e) {}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		FirstThread najin = new FirstThread("³ªÁø");
		FirstThread son = new FirstThread("¼ÕÈï¹Î");
		
		najin.start();
		son.start();
		
	}
	
}
