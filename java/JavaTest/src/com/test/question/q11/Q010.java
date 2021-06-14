package com.test.question.q11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q010 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int saturday = 7;
		
		System.out.print("년: ");
		int year = Integer.parseInt(reader.readLine());
		
		System.out.print("월: ");
		int month = Integer.parseInt(reader.readLine());
		
		System.out.print("일: ");
		int day = Integer.parseInt(reader.readLine());
		
		Calendar date = Calendar.getInstance();
		date.set(year, month-1, day); 
		
		int day_of_week = date.get(Calendar.DAY_OF_WEEK); //요일 일(1) ~ 토(7)
		
		if(day_of_week > 1 && day_of_week < 7 ) {
			day_of_week = 7-day_of_week;
			
			date.add(Calendar.DAY_OF_WEEK, day_of_week);// 토요일로 이동
			
			System.out.println("입력하신 날짜는 '평일'입니다.");
			System.out.println("해당 주의 토요일 이동합니다.");
			System.out.printf("이동한 날짜는 '%tF'", date);
		} else {
			System.out.println("입력하신 날짜는 '휴일'입니다.");
			System.out.println("결과가 없습니다.");
		}
		
		
		
		
		
		
	}
	
}
