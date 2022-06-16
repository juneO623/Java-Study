package kr.hs.dgsw.java.dept23.d0331;

public class AccessModifierStudy {
	
	private int privateValue;
	// 현재 객체 내에서만 허용

	protected int protectedValue;
	// 같은 패키지에 있는 객체와 상속관계의 객체들만 허용
	
	public int publicValue;
	// 모든 접근 허용
	
	int defaultValue;
	// 같은 패키지에 있는 객체들만 허용
}
