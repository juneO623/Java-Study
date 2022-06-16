package kr.hs.dgsw.java.dept23.d0602;

public class DepositThread implements Runnable {
	
	private final Bank bank;
	private final int amount;

	public DepositThread(Bank bank, int amount) {
		this.bank = bank;
		this.amount = amount;
	}
	
	@Override
	public void run() {
		System.out.printf("%s 의 계좌에 %d 원을 적립합니다.\n", "홍길동", amount);
		bank.deposit("홍길동", amount);
	}
	
	
	
}
