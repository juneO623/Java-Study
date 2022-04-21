package kr.hs.dgsw.java.dept23.d0421;

public class AdultCard extends Card {
	
	public AdultCard(int totalMoney) {
		super(totalMoney, 2000);
	}
	
	@Override
	public String getType() {
		return "º∫¿Œ";
	}
	
}
