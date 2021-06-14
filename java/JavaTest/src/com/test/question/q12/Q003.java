package com.test.question.q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q003 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int i = 0;
		System.out.print("숫자: ");
		int num = Integer.parseInt(reader.readLine());
		
		for(i = 1; i <= num; i++) {
			sum += i;
		}//for문
		System.out.printf("1 ~ %,d = %,d", num, sum);
	}//main
	
}//Q003
