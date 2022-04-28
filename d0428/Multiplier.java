package kr.hs.dgsw.java.dept23.d0428;

public class Multiplier extends Calculator{

	@Override
	public int calculate() {
		return this.value1 * this.value2;
	}

	@Override
	public String getOperator() {
		return "x";
	}
	
	public static void main(String[] args) {
		Calculator multiplier = new Multiplier();
		multiplier.execute();
	}
	
}
