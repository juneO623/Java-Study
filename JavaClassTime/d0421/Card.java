package kr.hs.dgsw.java.dept23.d0421;

public class Card {
	
	int totalMoney;
	int fee;
	
	public Card(int totalMoney, int fee) {
		this.totalMoney = totalMoney;
		this.fee = fee;
	}
	
	public String getType() {
		return "";
	}
	
	public int payment(int fee) {
		return this.totalMoney - this.fee;
	}
	
	public boolean canPaiable(int fee) {
		return this.totalMoney >= fee;
	}	
}
