package com.test.java;

public class Ex24_while {

	public static void main(String[] args) {
		
		// 반복문
		// 1. for(***)
		// 2. while(***)
		// 3. do while
		// 4. for //X(***)
		
		//m1(); //while
		//m2(); //do-while
		
	}//main

	private static void m2() {
		
		/* 
		
		do while문
		
		// 선조건 후실행
		while (조건식){
			실행코드;
		}
		
		
		//선실행 후조건 -> 무조건 1회 실행 보장
		do{
			실행코드;
		}
		while(조건식);
		
		*/
		
		int n = 1;
		
		do {
			System.out.println(n);
			n++;
		}while(n <=10);
		
	}

	private static void m1() {
		
		//while문
		// - for문 유사
		// - 조건에 따라 반복 제어
		
		/*	 
		 
		while (조건식) {
			실행문;
		}
		
		if (조건식) {
			실행문;
		}
		
		*/
		
		// 숫자 1~10까지 출력
		
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		System.out.println();
		System.out.println();
		
		int n = 1; //초기식
		
		while(n<=10) {  // 조건식
			System.out.println(n);
			n++; //증감식
		}
		System.out.println();
		System.out.println();
		
		// while 문제(X) -> for문 문제를 while로 다시 풀기..
		
		
		// 누적값이 1000이 넘어가면 중단.
		
		int sum = 0;
		
		for(int i = 1; ; i++) {
			sum += i;
			if(sum > 1000) {
				break;
			}
		}
		System.out.println(sum);
		System.out.println();
		
		sum = 0;
		n = 1; //루프변수 역할
		while(true) {
			sum+=n;
			if(sum >= 1000) {
				break;
			}
			n++;
		}
		System.out.println(sum);
		System.out.println();
		
		sum = 0;
		n = 1;
		while(sum < 1000) {
			sum+=n;
			n++;
		}
		System.out.println(sum);
		
		sum = 0;
		for(int i = 1; sum<=1000; i++) {
			sum += i;
		}
		System.out.println(sum);
				
	}
	
}//Ex24_while
