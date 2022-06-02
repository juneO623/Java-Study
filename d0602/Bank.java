package kr.hs.dgsw.java.dept23.d0602;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {

	private final Map<String, Account> accountMap = new HashMap<String, Account>();
	
	public void makeAccount(String name) {
		Account account = new Account(name);
		accountMap.put(name, account);
	}
	
	public void deposit(String name, int amount) {
		// 오랜 시간이 걸림

		Account account = accountMap.get(name);
		synchronized (account) {
			if (account != null) {
				int balance = account.getBalance();
				System.out.printf("%s : 잔액 읽어옴 - %d\n", Thread.currentThread().getName(), balance);
				
				try {
					
					Thread.sleep(new Random().nextInt(1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}			
				
				System.out.printf("%s : 적립 시작 - %d\n", Thread.currentThread().getName(), balance);
				
				int newBalance = balance + amount;
				
				account.setBalance(newBalance);
				
				System.out.printf("%s : 적립 완료 - %d\n", Thread.currentThread().getName(), account.getBalance());
			}
		}
		
		// 오랜 시간이 걸림
	}
	
	public Account getAccount(String name) {
		return accountMap.get(name);
	}
	
	
	public static void main(String[] args) {
		
		Bank bank = new Bank();
		
		bank.makeAccount("홍길동");
		
		Thread thread1 = new Thread(new DepositThread(bank, 50000));
		thread1.start();
		
		try {
			thread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Account account = bank.getAccount("홍길동");
		System.out.printf("%s 계좌의 잔액은 %d 원 남았습니다.", account.getName(), account.getBalance());
		
	}
	
}
