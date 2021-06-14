package com.test.question.q14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q003 {

	 public static void main(String[] args) throws IOException {
	
		 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		 System.out.print("숫자: ");
		
		 String num = reader.readLine(); 
		 int num1;
		 int sum = 0;
		 
		 System.out.print("결과: ");
		 
		 for(int i = 0; i < num.length(); i++) {
			 
			 num1 = (int)num.charAt(i) - 48; // '0'-48 = 0
			 sum +=num1;
			 System.out.printf("%d + ", num1);
			 
		 }
		 //System.out.print("\b");
		 System.out.printf(" = %d",sum);
		 
	}
	
} //Q003
