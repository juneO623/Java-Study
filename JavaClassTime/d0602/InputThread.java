package kr.hs.dgsw.java.dept23.d0602;

import java.util.Scanner;

public class InputThread implements Runnable {

	private Calculator calculator;
	
	private final Scanner scanner;
	
	public InputThread(Calculator calculator) {
		this.calculator = calculator;
		this.scanner = new Scanner(System.in);
	}
	
	@Override
	public void run() {

		while (true) {
			System.out.println("두 숫자를 입력하세요.");
			int value1 = scanner.nextInt();
			int value2 = scanner.nextInt();
			
			if (value1 == 0 && value2 == 0) {
				break;
			}
			
			InputValues values = new InputValues(value1, value2);
			calculator.addValues(values);
		}
		
		scanner.close();
		
		calculator.notifyInputTerminated();
	}
}