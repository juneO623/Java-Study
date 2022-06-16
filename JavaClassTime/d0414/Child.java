package kr.hs.dgsw.java.dept23.d0414;

public class Child extends Parent {
	
	private int age;
	
	public void showAge() {
		System.out.println(age);
	}
	
	public static void main(String[] args) {
		Child child = new Child();
		System.out.println(child.age);
		System.out.println("name " + child.name);
		child.sayHello();
		
//		int weight = child.weight;
		
		// 
		Parent parent = new Child();
		Parent realParent = new Parent();
		Child realchild = new Child();
//		Child child1 = new Parent();
		
		
		parent.sayHello();
//		parent.showAge();
		
		System.out.println(parent + " " + parent.getClass());
		System.out.println(realParent + " " + realParent.getClass());
		System.out.println(realchild + " " + realchild.getClass());
		
		
		Child child1 = (Child)parent;
//		Child child2 = (Child)realParent;
		/* Exception in thread "main" java.lang.ClassCastException: class kr.hs.dgsw.java.dept23.d0414.Parent cannot be cast to class kr.hs.dgsw.java.dept23.d0414.Child (kr.hs.dgsw.java.dept23.d0414.Parent and kr.hs.dgsw.java.dept23.d0414.Child are in unnamed module of loader 'app')
		at kr.hs.dgsw.java.dept23.d0414.Child.main(Child.java:35) */
		
		
		
	}
	
}
