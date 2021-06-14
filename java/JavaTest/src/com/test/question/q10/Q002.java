package com.test.question.q10;

import java.util.Calendar;

public class Q002 {
	
	public static void main(String[] args) {
		
		Calendar birthday = Calendar.getInstance();
		
		// 오늘(시각) + 100일(시간) -> add()
		birthday.add(Calendar.DATE, 100 - 1); // 오늘부터시작
		System.out.printf("백일 :%tF\n", birthday);
		
		
		birthday = Calendar.getInstance();
		//birthday.add(Calendar.DATE, -99);
		
		//**월, 년 -> 산술연산은 반드시 add()
		birthday.add(Calendar.YEAR, 1);		
		System.out.printf("첫돌 :%tF\n", birthday);
		
	}
	
	
}
