package kr.hs.dgsw.java.dept23.d0317;

import java.util.Scanner;

public class ScannerStudy {

	private Scanner scanner;
	
	public void prepareScanner() {
		this.scanner = new Scanner(System.in);
	}
	
	public void closeScanner() {
		this.scanner.close();
	}
	
	public Scanner getScanner() {
		return this.scanner;
	}
	
	public static void main(String[] args) {
		
		ScannerStudy study = new ScannerStudy();
		study.prepareScanner();
		
		Scanner scanner = study.getScanner();
		
		while(true) {
			System.out.println("Write some characters");
			int intValue = scanner.nextInt();
			
			if (intValue == -1)	
				break;
			
			System.out.println(intValue);
			
		}
		
		study.closeScanner();
		
	}
}
