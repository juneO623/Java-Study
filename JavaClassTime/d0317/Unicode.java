package kr.hs.dgsw.java.dept23.d0317;

import java.util.Scanner;

public class Unicode {
	private Scanner sc;
	
	public void helloScanner() {
		this.sc = new Scanner(System.in);
	}
	
	public void byeScanner() {
		this.sc.close();
	}
	
	public Scanner getSc() {
		return this.sc;
	}
	
	public static void main(String[] args) {
		Unicode input = new Unicode();
		input.helloScanner();
		Scanner sc = input.getSc();
		while(true) {
			System.out.println("숫자입력해라");
			int num = sc.nextInt();
			if(num < 0 || num > 65534)
				break;
			System.out.printf("%d - %c\n", num, (char)num);
		}
		input.byeScanner();
	}
}
