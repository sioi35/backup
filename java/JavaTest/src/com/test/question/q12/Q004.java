package com.test.question.q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q004 {

	public static void main(String[] args) throws NumberFormatException, IOException 
 {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int evenSum = 0;
		int oddSum = 0;
		int i = 0;
		
		System.out.print("입력받을 숫자의 갯수: ");
		int inputNum = Integer.parseInt(reader.readLine());
		
		for(i = 1; i <= inputNum; i++)
		{
			System.out.print("숫자: ");
			int num = Integer.parseInt(reader.readLine());
			
			if(num % 2==0) {
				evenSum += num;
			}else {
				oddSum += num;
			}
		}//for문
		System.out.printf("짝수의 합은: %,d\n", evenSum);
		System.out.printf("홀수의 합은: %,d\n", oddSum);
		
	}//main
	
}//Q004
