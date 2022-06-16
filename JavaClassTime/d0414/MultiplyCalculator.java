package kr.hs.dgsw.java.dept23.d0414;

import java.util.Scanner;

public class MultiplyCalculator extends PlusCalculator {
	
	public int calculate() {
		return this.value1 * this.value2;
	}
	
	@Override
	public String getOperator() {
		return "*";
	}
	
	/*
	public void showResult(int result) {
		System.out.printf("%d - %d = %d", this.value1, this.value2, result);
	}
	*/
	
	public static void main(String[] args) {
		MultiplyCalculator calculator = new MultiplyCalculator();
		calculator.execute();
		
	}
	
}
