package kr.hs.dgsw.java.dept23.d0421;

public class Triangle extends Rectangle {
	
	public Triangle(int bottom, int height) {
		super(bottom, height);
	}
	
	@Override
	public String getType() {
		return "»ï°¢Çü";
	}
	
	@Override
	public double getArea() {
		return super.getArea() / 2;
	}
	
	public static void main(String[] args) {
		Triangle triangle = new Triangle(5, 10);
		triangle.print();
	}
	
}
