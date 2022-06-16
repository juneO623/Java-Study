package kr.hs.dgsw.java.dept23.d0428;

public abstract class Animal {
	
	public abstract String getName();
	
	public abstract String makeSound();
	// 선언만 하고 자식에서 재정의 해줌. 재정의 안 하면 컴파일 에러 발생
	
	public void move() {
		System.out.printf("%s 이(가) %s 소리를 내며 달려갑니다.", getName(), makeSound());
	}
	
	public static void main(String[] args) {
		// 추상 클래스로는 객체를 만들 수 없다.
		Animal animal = new Horse();
		animal.move();
	}
	
}
