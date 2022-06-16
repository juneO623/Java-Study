package kr.hs.dgsw.java.dept23.d0526;

public class AdderThread implements Runnable {
	
	private final int value1;
	
	private final int value2;
	
	public AdderThread(int value1, int value2) {
		this.value1 = value1;
		this.value2 = value2;
	}
	
	@Override
	public void run() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		int result = value1 + value2;
		
	}
	
	
}
