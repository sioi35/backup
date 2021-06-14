package com.test.question.q12;

public class Q018 {

public static void main(String[] args) {
		
		int i, j;
		//int sum=0;
		
		for(i = 1; i< 100; i++) { //1부터 100사이의 완전수 구하기
			int sum=0;
			for(j = 1; j< i; j++) { // 자기자신을 제외한 약수 구하기
				if(i % j == 0 ) { 
					sum += j;
				}
			}
			
			if(sum == i) {
				System.out.printf("%d = [ ", i);
				for(j=1; j<i; j++) {
					if(i%j==0) {
						System.out.printf("%d, ",j);						
					}
				}
				System.out.print("\b\b ]\n");
			}
		}
		
	}//main
	
	
}//Q018
