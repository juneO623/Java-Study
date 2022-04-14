package kr.hs.dgsw.java.dept23.d0414;

import kr.hs.dgsw.java.first.Hello;

public class Student extends People {
	
	private String school;
	
	public Student(String name, int age, int grade) {
		super(name, age);
		this.grade = grade;
	}
	

	private int grade;
	
	@Override
	public void showInformation() {
		System.out.printf("name : %s, age : %d, grade : %d\n",
				name, age, grade);
	}
	
	private String classNumber; // 학년 반 번호
	
	public static void main(String[] args) {
		
		Student s1 = new Student("홍길동",9,2);
		s1.school = "elementarySchool";
		
		s1.showInformation();
		
		People people1 = new Student("기준",18,2);
		
		People people2 = new People("최민재", 18);
		
		people1.showInformation();
		people2.showInformation();
		
		
		
//		Student student = new Student("hello");
//		People AndrewT = new People("Andrew",22);
//		
//		String name = student.name;
//		
//		System.out.println(AndrewT.skinColor);
//		System.out.println(AndrewT.hello());
		
		
	}
	
	
	
}
