package kr.hs.dgsw.teacher.class23;

// public class Thread1 implements Runnable {
public class Thread1 extends Thread {
	// 작업 구현
	public void run() {
		for(int i=0; i<500; i++) {
			System.out.printf("t1 Thread: %d \n", i);
		}
	}
}
