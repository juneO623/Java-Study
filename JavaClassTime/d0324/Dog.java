package kr.hs.dgsw.java.dept23.d0324;

import java.util.Scanner;

import kr.hs.dgsw.java.dept23.d0317.ScannerStudy;

public class Dog {
	
	private final String name;
	// final 로 선언하면 값을 바꾸지 못함
	// final 로 선언하면 처음에 초기화 해줘야 함
	
	
	private int age;
	
	/*
	// Method 이름을 클래스 이름으로 해도 에러가 발생함
	public Dog(String name) {// 생성자 이름은 클래스 이름과 같아야 함
		System.out.println("생성자 호출");
		this.name = name;
	}
	*/
	
	
	public Dog() {	// 자기 자신을 호출하려면 가장 먼저 호출해야함
		this("몰라");
//		System.out.println("aaa");
	}
	
	public Dog(String name) {
		System.out.println("생성자 호출됨");
		this.name = name;
	}
	
	public void sayHello() {
		System.out.println("Hello " + this.name);
	}
	
	
	
	public static void main(String[] args) {
		
		ScannerStudy scannerStudy = new ScannerStudy();
		scannerStudy.prepareScanner();
		Scanner scanner = scannerStudy.getScanner();
		
		String input = null;
		while(true) {
			System.out.println("강아지 이름을 입력하세요 : ");
			input = scanner.next();
			
//			if(input.equals("quit")) {	// 이때는 input이 null 이라면 오류 발생
			if("quit".equals(input)) {	// input에 null 이 들어와도 오류가 나지 않음
				break;
			}
			
			
			Dog dog = new Dog(input);
			dog.sayHello();
		}
		
		
//		for(int i=0; i<args.length; i++) {
//			Dog dog = new Dog(args[i]);
//			dog.sayHello();
//		}
		
		
//		Dog puppy = new Dog();
//		Dog happy = new Dog("해피");
//		Dog poppy = new Dog("뽀삐");
		
	}
}
