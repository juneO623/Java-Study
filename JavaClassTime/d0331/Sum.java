package kr.hs.dgsw.java.dept23.d0331;
import java.util.Scanner;

public class Sum {
	
	public int calc(int n1) {
//		int result1=0;
//		for(int i=1;i<=n1;i++) {
//			result1 += i;
//		}
//		return result1;
		return calc(1,n1);
	}
	
	public int calc(int n1, int n2) {
		int result2=0;
		
		for(int i=n1; i<=n2;i++) {
			result2 += i;
		}
		
		return result2;
	}
	
	
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
		Sum sum = new Sum();
		sum.prepareScanner();
		
		Scanner sc = sum.getScanner();
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		System.out.println(sum.calc(num2));
		System.out.println(sum.calc(num1, num2));
		
		sum.closeScanner();
	}
	
}
