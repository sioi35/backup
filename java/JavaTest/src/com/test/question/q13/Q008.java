package com.test.question.q13;

public class Q008 {

	public static void main(String[] args) {
		
		int i = 0, j = 0;
		
		for(i = 1; i<=100; i+=10) {
			int sum = 0;
			System.out.printf("%2d~",i);
			for(j=i; j<=i+9; j++) {
				sum += j;
			}
			System.out.printf("%3d : %3d\n", --j,sum);
		}System.out.println();
	
	}//main
	
}// Q008


