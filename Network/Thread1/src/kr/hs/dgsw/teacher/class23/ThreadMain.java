package kr.hs.dgsw.teacher.class23;

public class ThreadMain {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Thread1 mil1 = new Thread1();
//		Thread t1 = new Thread(mil1);
//		
//		Thread2 mil2 = new Thread2();
//		Thread t2 = new Thread(mil2);
		
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		
		t1.start();
		t2.start();
		
		for(int i=0; i<500; i++) {
			System.out.printf("main Thread: %d \n", i);
		}
		
	}
	
}
