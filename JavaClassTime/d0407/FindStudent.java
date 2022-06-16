package kr.hs.dgsw.java.dept23.d0407;
import java.util.Scanner;

public class FindStudent {
	
	public String[] friendTable = {"정은서","강성훈","고용빈","기준","김민성",
								"류지훈","박병관","박성한","박지건","박현우",
								"손원","안찬","우상범","윤병훈","윤서준",
								"이승민", "이지호","최민재","한상빈"};
	
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
	
	public void yourName() {
		prepareScanner();
		getScanner();
		String[] friends = friendTable;
		
		System.out.print("번호를 입력하세요 : ");
		int friendNum = scanner.nextInt();
		if(friendNum > friendTable.length-1) {
			System.out.println("없는 번호입니다");
		}
		else {
			System.out.println(friends[friendNum-1]);
		}
	}
	
	public void yourNum() {
		
		int friendNum = 0;
		System.out.printf("이름을 입력하세요 : ");
		String friendName = scanner.next();
		
		
		
		for (int i=0; i<friendTable.length; i++) {
			if (friendTable[i].equals(friendName)) {
				friendNum = i+1;
			}
		}
		System.out.println(friendNum + "번 입니다");
	}
	
	public static void main(String[] args) {
		
		FindStudent findStudent = new FindStudent();
		
		findStudent.yourName();
		findStudent.yourNum();
		
		findStudent.closeScanner();
	}
	
	
}
