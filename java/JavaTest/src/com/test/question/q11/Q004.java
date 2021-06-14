package com.test.question.q11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q004 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("근무 년수: ");
		int year = Integer.parseInt(reader.readLine());
		
		if(year < 5 ) {
			System.out.printf("%d년차 %s 초급 개발자입니다\n", year);
			System.out.printf("앞으로 %d년 더 근무를 하면 중급 개발자가 됩니다.\n", 5 - year);			
		}else if(year < 10) {
			System.out.printf("%d년차 %s 중급 개발자입니다n", year);
			System.out.printf("당신은 %d년 전까지 중급 개발자가 였습니다.\n", year - 4);							
			System.out.printf("앞으로 %d년 더 근무를 하면 고급 개발자가 됩니다.\n", 9 - year);			
		}else {
			System.out.printf("%d년차 %s 고급 개발자입니다n", year);
			System.out.printf("당신은 %d년 전까지 중급 개발자가 였습니다.\n", year - 9);				
		}
		
	
		
	}
	
}
