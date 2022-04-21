package kr.hs.dgsw.java.dept23.d0421;

public class Animal {
	
	public String getSound() {
		return "";
	}
	
	public String getName() {
		return "";
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName();
	}
	
	public static void main(String[] args) {
		Animal animal = new Animal();
		System.out.println(animal.toString());
		
		Animal pig = new Pig();
		Animal duck = new Duck();
		
		System.out.println(pig.toString());
		System.out.println(duck.toString());
	}
	
}
