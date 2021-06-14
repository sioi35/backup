package com.test.question.q13;

public class Q007 {

	public static void main(String[] args) {
		
		int i, j;
		
		for(j = 10 ; j <= 100; j+=10) {
			int sum = 0;
			for(i = 1; i <= j; i++) {
				sum += i;
			}//for문
			System.out.printf("1 ~ %,d = %,d", --i, sum);
			System.out.println();
		}
		
	}//main
	
}//Q007
