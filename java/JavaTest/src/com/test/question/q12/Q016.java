package com.test.question.q12;

public class Q016 {
	
	public static void main(String[] args) {
		
		int sum = 0;

		int a= 1;
		int b= 1;
		int c = 0;
		
		System.out.printf("%d + %d ", a , b);
		
		c= a + b;
		sum += a + b;
		
		for(;;) {
			if(c>100) {
				System.out.printf("= %d", sum);
				break;
			}else {
				System.out.printf("+ %d ", c);
				sum+=c;
				a=b;
				b=c;				
				c = a + b;
			}
		}
		
	}//main
	
}//Q016
