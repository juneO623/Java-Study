package kr.hs.dgsw.java.dept23.d0526;

public class Run100mThread implements Runnable {

	private final String name;
	
	private final double second;
	
	private double distance = 0;
	
	public Run100mThread(String name, double second) {
		this.name = name;
		this.second = second;
	}
	
	@Override
	public void run() {
		
		while (distance < 100){
			System.out.printf("%s가 %.2fm만큼 달렸습니다.\n", name, distance);
			distance += 100 / second;
			
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {}
			
		}
//		if (distance > 100) {
//			System.out.printf("%s가 100m 완주에 성공했습니다.\n", name);
//		}
		System.out.printf("%s가 100m 완주에 성공했습니다.\n", name);
		// 조건이 충족되면 어짜피 while문을 나온 뒤이기 때문에 바로 출력
	}
	
	public static void main(String[] args) {
		
		Run100mThread UB = new Run100mThread("Bolt", 9.58);				// 우사인 볼트
		Run100mThread KimGukYeong = new Run100mThread("KGY", 10.07);	// 김국영
		Run100mThread ParkJiGeon = new Run100mThread("PJG", 12.56);		// 박지건
		Run100mThread CommonPeople = new Run100mThread("CP", 14.02);	// 킹반인
		
		new Thread(UB).start();
		new Thread(KimGukYeong).start();
		new Thread(ParkJiGeon).start();
		new Thread(CommonPeople).start();
		
		
	}
	
}
