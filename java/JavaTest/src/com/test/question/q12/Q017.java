package com.test.question.q12;

public class Q017 {

	public static void main(String[] args) {
		int i=0; 
		int j=0;
		
		
		for( i = 2; i<100; i++) {
			
			for(j = 2; j <= i; j++) {
				if(i % j == 0) {
					break;
				}
			}
			
			if(i == j){
				System.out.printf("%d ",i);
			}
			
		}
		

		
	}//main
	
}//Q017
