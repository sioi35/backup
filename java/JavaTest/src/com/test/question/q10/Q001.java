package com.test.question.q10;

import java.util.Calendar;

public class Q001 {

	public static void main(String[] args) {
			
		nowTime();
		nowTime_AMPM();
			
	}//main
		
	private static void nowTime_AMPM() {
		Calendar now = Calendar.getInstance();
		
		String ampm =  (Calendar.AM_PM == 0) ? "오전" : "오후";
				
		System.out.printf("%d시 %02d분 %02d초 -> %s %02d시 %02d분 %02d초\n"
						,now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), now.get(Calendar.SECOND)
						,ampm
						,now.get(Calendar.HOUR), now.get(Calendar.MINUTE), now.get(Calendar.SECOND) );
	}//nowTime_AMPM

	public static void nowTime() {
			
		Calendar now = Calendar.getInstance();
		
		System.out.printf("현재 시간 : %d시 %02d분 %02d초\n"
						,now.get(Calendar.HOUR_OF_DAY)
						,now.get(Calendar.MINUTE)
						,now.get(Calendar.SECOND) );
		
	}//nowTime
	
	
	
}//Q001
