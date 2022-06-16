package kr.hs.dgsw.java.dept23.d0414;

public class Dog extends Animal {
	public Dog(String name) {
		super(name);
	}
	
	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("¸Û¸Û");
	}
	
	public static void main(String[] args) {
		
		Animal dog = new Dog("ÇØÇÇ");
		
		dog.move();
		dog.eat("»ç·á");
		dog.makeSound();
		
	}
	
}
