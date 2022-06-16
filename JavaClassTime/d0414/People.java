package kr.hs.dgsw.java.dept23.d0414;

public class People {
	
	protected int age;
	
	private int height;
	private int weight;

	public People(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	protected String name;
	
	private String gender;
	
	public String skinColor;
	
	private int NINum; // 주민등록번호
	
	public String hello() {
		System.out.println("Hello " + name);
		return gender;
	}
	
	public void showInformation() {
		System.out.printf("name : %s, age : %d\n",
				name, age);
	}
	
}
