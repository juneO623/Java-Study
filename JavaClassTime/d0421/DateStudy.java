package kr.hs.dgsw.java.dept23.d0421;

import java.util.Date;

public class DateStudy {
	
	public static void main(String[] args) {
		
		Date date = new Date();
		System.out.println(date);
		
		Mydate date1 = new Mydate();
		System.out.println(date1);
		System.out.println(date1.getYear1());
	}

}
