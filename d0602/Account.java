package kr.hs.dgsw.java.dept23.d0602;

// °èÁÂ
public class Account {
	
	// °èÁÂ ÁÖÀÎ ÀÌ¸§
	private final String name;
	
	// ÀÜ¾×
	private int balance;
	
	public Account(String name) {
		this.name = name;
		this.balance = 0;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}
	
	
	
}
