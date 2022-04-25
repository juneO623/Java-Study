package kr.hs.dgsw.teacher.class23;

public class Thread1 implements Runnable {
	
	// extends Thread
//	public String name;
//	
//	public Thread1(String name) {
//		this.name = name;
//	}
	 
	// implements Runnable
	
	
	
	
	
	public void run() {
		
//		try {
//			for (int i=0; i<500; i++) {
//				System.out.println("T1 thread: " + i);
//				Thread.sleep(1);
//			}
//		} catch(InterruptedException e) {
//			System.out.println("Thread 강제 종료");
//			return;
//		}
		
		for (int i=0; i<500; i++) {
			/*  */
		}
		
		System.out.println(Thread.currentThread().getName() + "T1 Thread End");
	}
}
