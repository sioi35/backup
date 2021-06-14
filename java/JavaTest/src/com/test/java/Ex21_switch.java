package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Ex21_switch {
	
	public static void main(String[] args) throws IOException {
		
		/*
		
		switch문, switch case문
		- 조건문
		- 조건으로 사용 가능한 자료형 > 정수, 문자열, 열거형(enum)
		
		switch (조건){
			case 값:
				실행문;
				break;
			[ case 값:
				실행문;
				break;] X N
			[ default:
				실행문;
				break;]		
		
		}
	
		*/
		
		//m1();
		//m2();
		m3();
	}//main

	private static void m3() {
		
		//사용자 입력 > 년, 월 -> 해당월의 마지막 일?
		
		int year = 2021;
		int month = 4;
		int lastDay = 0;
		
		switch(month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				lastDay = 31;
				break;
			
			case 4:
			case 6:
			case 9:
			case 11:
				lastDay = 30;
				break;
			case 2: 
				lastDay = 28;   // 윤년 계산? 28,29
				break;
		}
		System.out.println(lastDay);
		
		//2020년 2월 -> 마지막 날짜?
		Calendar c1 = Calendar.getInstance();
		
		c1.set(2020, 1, 1); // 2020-02-01
		
		System.out.println(c1.getActualMaximum(Calendar.DATE)); // 해당 2020년 2월에 속한 가장 큰 숫자-> 가장 마지막 날
				
		
	}

	private static void m2() throws IOException {
		
		// 자판기
		// - 메뉴 출력 -> 음료 선택 -> 가격 출력
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("==========================");
		System.out.println("	자판기 메뉴");
		System.out.println("==========================");
		System.out.println("1. 콜라");
		System.out.println("2. 사이다");
		System.out.println("3. 포도주스");
		System.out.println("==========================");
		System.out.println("선택(번호입력): ");
		
		String input = reader.readLine();
		
		if(input.equals("1")) {
			System.out.println("700원입니다.");
		}else if(input.equals("2")) {
			System.out.println("600원입니다."); 
		}else if(input.equals("3")) {
			System.out.println("500원입니다.");
		}else {
			System.out.println("선택하신 번호는 없는 번호입니다.");
		}
		
		// 1, 2번 가격 동일하게 인상
		if(input.equals("1") || input.equals("2")) {
			System.out.println("800원입니다.");
		}else if(input.equals("3")) {
			System.out.println("500원입니다.");
		}		
		
		switch(input) {
		case "1": 
			System.out.println("700원입니다.");
			break;
		case "2": 
			System.out.println("600원입니다.");
			break;
		case "3": 
			System.out.println("500원입니다.");
			break;
		}
		
		// 1, 2 동일할 때 
		switch(input) {
		case "1": 
			//System.out.println("800원입니다.");
			//break;
		case "2": 
			System.out.println("800원입니다.");
			break;
		case "3": 
			System.out.println("500원입니다.");
			break;
		default:// if문의 else절과 같은 역할
			System.out.println("없는 번호를 선택했습니다.");
			break; // 디폴트에서 브레이크문 없어도 빠져나옴. -> 그래도 break 쓰는거 권장
		}
		
	}

	private static void m1() {
		//Ctrl + D -> 라인 지우기 XXX
		
		// 숫자 -> 한글
		// 1 -> "하나"

		int num = 1;
		
		// 다중 if문
		if(num == 1) {
			System.out.println("하나");
		}else if(num == 2) {
			System.out.println("둘");
		}else if(num == 3) {
			System.out.println("셋");
		}
		
		switch(num) {
			case 1: // Label
				System.out.println("하나");
				break;
			case 2:
				System.out.println("둘");
				break;
			case 3:
				System.out.println("셋");
				break;
		}
		System.out.println("종료");
			
		
	}// m1
	
	
}// Ex21_switch
