package com.test.question.q11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q001 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자 : ");
		int firstNum = Integer.parseInt(reader.readLine());
		
		System.out.print("두번째 숫자 : ");
		int secondNum = Integer.parseInt(reader.readLine());
		
		if(firstNum > secondNum) {
			System.out.printf("큰 수는 %d이고, 작은수는 %d입니다.\n", firstNum, secondNum);
			System.out.printf("두 숫자의 차이는 %d입니다.\n", firstNum - secondNum);
		}else {
			System.out.printf("큰 수는 %d이고, 작은수는 %d입니다.\n", secondNum, firstNum);			
			System.out.printf("두 숫자의 차이는 %d입니다.\n ", secondNum - firstNum);
		}
		
		
		
	}

}
