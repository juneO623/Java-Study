package kr.hs.dgsw.java.dept23.d0616;

public class Num<T extends Number> {
	
	private T value;
	
	public void print() {
		System.out.println(value);
	}
	
	public static void main(String[] args) {
		Num<Integer> num1 = new Num<Integer>();
		Num<Double> num2 = new Num<Double>();
		Num<Short> num3 = new Num<Short>();
		Num<Long> num4 = new Num<Long>();
//		Num<String> num5 = new Num<String>();	// T는 extends Number이기 때문에 위에는 가능하지만 String은 안됌.
	}
	
}
