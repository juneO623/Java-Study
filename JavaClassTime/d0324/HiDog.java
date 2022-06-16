package kr.hs.dgsw.java.dept23.d0324;
import java.util.Scanner;


// 문자열 비교할 때
// str == "quit" 말고
// str.equals("quit") 하기

public class HiDog {
	
	String name;
	private Scanner sc;
	
	public Scanner getScanner() {
		sc = new Scanner(System.in);
		return sc;
	}
	
	public void closeScanner() {
		sc.close();
	}
	
	public HiDog() {
		this.name="몰루";
	}
	
	public void sayHello() {
		System.out.println("Hi, " + name);
	}
	
	
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("강아지 이름을 입력하세요 : ");
			HiDog KT = new HiDog();
			Scanner sc = KT.getScanner();
			KT.name = sc.nextLine();
			if(KT.name.equals("quit")) {
				KT.closeScanner();
				break;
			}
			KT.sayHello();
		}
	}
}




