package com.test.question.q13;

public class Q006 {

	public static void main(String[] args) {
		
		for(int i = 1; i <= 9; i++) {
			for(int j = 2; j <= 5; j++) {	
				System.out.printf("%d x %d = %2d  ", j, i, j*i);
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i = 1; i <= 9; i++) {
			for(int j = 6; j <= 9; j++) {
				System.out.printf("%d x %d = %2d  ", j, i, j*i);		
			}
			System.out.println();
		}
		
	}//main
	
	
}//Q006
