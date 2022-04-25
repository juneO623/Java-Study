package kr.hs.dgsw.teacher.class23;

public class ThreadMain {
	
	public static void main(String[] args) {
		
//		System.out.println("main 시작");
		
		// Override 방식으로 쓰레드 생성
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<500; i++) {
					System.out.printf("t1 Thread: %d \n", i);
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<500; i++) {
					System.out.printf("t2 Thread: %d \n", i);
				}
			}
		});
		
//		System.out.println("t1 start");
		t1.start();
//		System.out.println("t2 start");
		t2.start();
		
//		System.out.println("main for문 start");
		for(int i=0; i<500; i++) {
			System.out.printf("main Thread: %d \n", i);
		}
		
//		try {
//			t1.join();
//			t2.join();
//		} catch(InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("전체 종료");
	}
	
}
