package kr.hs.dgsw.java.dept23.d0414;

public class Stingray extends Animal {
	
	public Stingray() {
		super("가오리");
	}
	
	@Override
	public void makeSound() {
		System.out.println("가오리가오리가오리가오리가오리가오리");
	}
	
	public static void main(String[] args) {
		Animal stingray = new Stingray();
		
		stingray.move();
		stingray.eat("문어");
		stingray.makeSound();
		
	}
	
}
