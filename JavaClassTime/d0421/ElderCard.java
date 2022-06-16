package kr.hs.dgsw.java.dept23.d0421;

public class ElderCard extends Card {
	
	public ElderCard(int totalMoney) {
		super(totalMoney, 0);
	}
	
	@Override
	public String getType() {
		return "¾î¸£½Å";
	}
}
