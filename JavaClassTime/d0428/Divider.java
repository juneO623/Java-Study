package kr.hs.dgsw.java.dept23.d0428;

public class Divider extends Calculator{

	@Override
	public int calculate() {
		return this.value1 / this.value2;
	}

	@Override
	public String getOperator() {
		return "/";
	}
	
	public static void main(String[] args) {
		Calculator divider = new Divider();
		divider.execute();
	}
	
	@Override
	public boolean isExitCondition() {
		return getOperator().equals("/") && value2 == 0;
	}
	
}
