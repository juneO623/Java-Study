package kr.hs.dgsw.java.dept23.d0331;
import java.util.Scanner;

public class Aliquot {
	
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
	
	public String findAliquots(int value) {
		String str="";
		
		for(int i=1;i<=value;i++) {
			if(value%i==0) {
				str+=i+", ";
			}
		}
		return str.substring(0, str.length()-2);
	}
	
	
	public static void main(String[] args) {
		
		Aliquot aliquot = new Aliquot();
		aliquot.prepareScanner();
		
		long check1 = System.currentTimeMillis();
		int Num = aliquot.getScanner().nextInt();
		
		System.out.println(aliquot.findAliquots(Num));
		
		long check2 = System.currentTimeMillis();
		System.out.println(check2-check1);
		
		aliquot.closeScanner();
		
	}
}
