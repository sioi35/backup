package com.test.java;

import java.io.IOException;

public class Ex23_Calendar {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//Ex23_Calendar
		
		// 달력 만들기
		// 1. 년, 월
		// 2. 해당 월의 1일 무슨 요일?
		// - 특정 날짜의 누적일수
		// - 윤년계산
		// 3. 월의 마지막일?
		// - 윤년 계산
		
		// 변수 선언
		// - 보통 변수의 초깃값은 해당 변수가 가질 수 없는 값 > 실수하더라도 피해가 적거나 발견하기 쉬워서
//		int year = 0, month = -1; // 년, 월
//		
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		
//		System.out.println("달력 만들기");
//		
//		System.out.print("년: ");
//		year = Integer.parseInt(reader.readLine());
//		
//		System.out.print("월: ");
//		month = Integer.parseInt(reader.readLine());
//		
//		output(year, month);
		
		// 2021년 1월~12월 달력 출력
		
		for(int i = 1; i<=12; i++) {
			output(2021, i);
		}
		
	}//main

	public static void output(int year, int month) {
		
		int lastDay = 0; // 마지막 일
		int day_of_week = 0; // 요일
		
		// 마지막 일?
		lastDay = getLastDay(year, month);
		
		// 해당 월의 1일의 요일?
		day_of_week = getDayOfWeek(year, month);
		
		//System.out.println(day_of_week);
		
		// 달력 출력하기
		System.out.println();
		System.out.println("====================================================");
		System.out.printf("                      %d년 %d월\n", year, month);
		System.out.println("====================================================");
		System.out.println("[일]\t[월]\t[화]\t[수]\t[목]\t[금]\t[토]");
		
		// 1일의 요일을 맞추기 위해서..
		for(int i = 0; i < day_of_week; i++) {
			System.out.print("\t");			
		}
		
		//날짜 출력
		for(int i = 1; i <= lastDay; i++) {
			System.out.printf("%3d\t",i);
			
			// 토요일마다 개행.
			// 3월(1)월 -> 6일이 토
			// 4월(4)목 -> 3
			// 5월(6)토 -> 1
			// 8월(0)일 -> 7
			if(day_of_week == 0) {
				if(i % 7 == 0) { // 해당 월의 1일이 일요일일땐 나머지가 0인게 토요일.
					System.out.println();
				}	
			}else if(i % 7 == (7 - day_of_week)) {
				System.out.println();
			}
			
		}
		
	}//output

	
	public static int getDayOfWeek(int year, int month) {
		
		// 서기 1년 1월 1일 ~ year년 month월 1일까지 총 며칠?
		
		// 누적 변수
		int totalDays = 0;
		
		// 1.1.1 ~ 2021.4.1
		
		// 1.1.1 ~ 2020.12.31 -> 1 ~ 2020 X 365
		
		for(int i = 1; i< year; i++) { //전년도까지
			
			if(isLeafYear(i) == true) {
				totalDays += 366;
			}else {
				totalDays += 365;				
			}
			
		}
		
		// 2021.1.1 ~ 2021.3.31
		for(int i = 1; i< month; i++) {//전월까지
			
			totalDays += getLastDay(year, i);
		
		}
		
		// 2021.4.1 ~ 2021.4.1
		totalDays++;
		
		return totalDays % 7;
		
	}

	// This method must return a result of type int
	// 잘못된 값이 들어왔을 때 반환 값 설정 안해주면 에러
	public static int getLastDay(int year, int month) {		
		switch(month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31; // return문: 메소드를 종료하는 역할(break유사) + 값 변환
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			case 2:
				return isLeafYear(year) ? 29 : 28;
//			default: 
//				return 0;
		}
		return 0;
	}//getLastDay
	
	public static boolean isLeafYear(int year) {
		
		if(year % 4 == 0) {
			
			if(year % 100 == 0) {
				
				if(year % 400 == 0) {
					return true; // 윤년
				}else {
					return false; //평년
				}
				
			}else {
				return true; // 윤년
			}
			
		}else {
			return false; // 평년
		}
	
	}//isLeatYear
	
}//Ex23_Calendar
