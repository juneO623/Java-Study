package kr.hs.dgsw.java.dept23.d0331;

public class OperatorStudy {
	
	public void studyArithmeticOperators() {
		
		int value;
		
		value = 3 + 4;
		value = 3 - 4;
		value = 3 * 4;
		value = 3 / 4;
		value = 3 % 4;
		
		value += 3;
		value -= 3;
		value *= 3;
		value /= 3;
		value %= 3;
		
		int value1 = ++value;
		value1 = value--;		
		
		
	}
	
	public void studyComparisionOperators() {
		boolean flag;
		
		flag = 3 > 4;
		flag = 3 < 4;
		flag = 3 >= 4;
		flag = 3 <= 4;
		
		flag = 3 == 4;
		flag = 3 != 4;		
		
	}
	
	public void studyLogicalOperators() {
		
		int value;
		
		value = 3 & 2;	//2
		value = 3 | 2;	//3
		value = 3 ^ 2;
		
		value = 12424 << 1;
		
		byte value1 = -128;
		byte result = (byte)(value1 >> 1);
		
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		OperatorStudy study = new OperatorStudy();
		study.studyLogicalOperators();
		
		
		
		
		int a = 40;
		int b = 23;
		
		int max;
		if (a > b) {
			max = a;
		}else {
			max = b;
		}
		
		max = (a > b) ? a:b;
		
		
		
	}
	
	
	
	
}
