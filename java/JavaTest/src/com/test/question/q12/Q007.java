package com.test.question.q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q007 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("루프를 종료할 누적값: ");
		int maxSum = Integer.parseInt(reader.readLine());
		
		int sum = 0;
		int i;
		
		for(i= 1; ; i++) {
			sum += i;
			
			if(sum > maxSum) {
				System.out.printf("%,2d = %,2d",i, sum);
				break;
			}else {
				System.out.printf("%,2d + ",i );				
			}
	
		}//for문
		
	}//main
	
}//Q007

//for문을 활용한 여러가지 방법이 있다.

/*
		for(int i=1;; i++) {         
	         System.out.printf("%d",i);
	         sum += i;
	         
	         if(sum >= num) {
	            break;
	         }else {
	            System.out.printf(" + ");
	         }
         
         }
      
      System.out.printf(" = " + sum)
*/


/*
	int sum = 0;
      
      for (int i = 1; true; i++) {
         
         if (i > 1000) {
            break;
         }
         
         sum += i;
         
         System.out.print(i);
         
         if (i <= end - 1) {
            System.out.print(" + ");
         } else if (i == end) {
            System.out.print(" = ");
            System.out.println(sum);
         }
         
         
      }
*/


