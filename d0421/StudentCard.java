package kr.hs.dgsw.java.dept23.d0421;

public class StudentCard extends Card {
	
	public StudentCard(int totalMoney) {
		super(totalMoney, 800);
	}
	
	@Override
	public String getType() {
		return "ÇÐ»ý";
	}
	
}
