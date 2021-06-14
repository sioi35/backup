package com.test.question.q13;

public class Q009 {

	public static void main(String[] args) {
		
		int sum=0;
		int add = 0;
		int i;
		
		for(i=0; ; i++) {
			
			if(i==0) {
				add++;
				System.out.printf("%d ", add + i);				
			}else {
				if(add + i >100) {
					System.out.printf("= %d", sum);
					break;					
				}
				System.out.printf("+ %d ", add + i);
			}
			add =add+i;
			sum += add;
		}
	}//main
	
}//Q009
