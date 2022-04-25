package kr.hs.dgsw.teacher.class23;

public class ThreadMain {
	
	public static void main(String[] args) {
		
		Thread1 m1 = new Thread1();
		
		Thread[] t1 = new Thread[5];
		
		for (int i=1; i<=5; i++) {
			t1[i] = new Thread(m1, "T"+i);
			
			t1[i].start();
		}
		
		for (int i=0; i<500; i++) {
			
		}
		System.out.println("Main Thread End");
	
		
//		Thread1 m1 = new Thread1();
//		Thread2 m2 = new Thread2();
//		Thread3 m3 = new Thread3();
//		Thread4 m4 = new Thread4();
//		Thread5 m5 = new Thread5();
//		
////		Thread [] m1 = new Thread();
//
//		Thread t1 = new Thread(m1, "T1");
//		Thread t2 = new Thread(m2, "T2");
//		Thread t3 = new Thread(m3, "T3");
//		Thread t4 = new Thread(m4, "T4");
//		Thread t5 = new Thread(m5, "T5");
//		
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
//		t5.start();
		
//		Thread1 t1 = new Thread1();
//		Thread2 t2 = new Thread2();
//		Thread3 t3 = new Thread3();
//		Thread4 t4 = new Thread4();
//		Thread5 t5 = new Thread5();
		
//		t1.setPriority(0);	우선 순위가 제일 낮음
//		t1.setPriority(Thread.MAX_PRIORITY);	우선 순위가 제일 높음 (10)
//		t1.setPriority(Thread.MIN_PRIORITY);	우선 순위가 제일 낮음
//		t1.setPriority(Thread.NORM_PRIORITY);	기본 (5)
		
//		t1.setPriority(10);		
//		
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
//		t5.start();
		
	}
	
}
