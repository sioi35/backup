package com.test.question.q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q006 {
	
	public static void main(String[] args) throws IOException {
		
		System.out.print("문자 입력: ");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int small = reader.read();
		 
		int big= small -32;
		
		System.out.printf("소문자 '%c'의 대문자는 '%c'입니다\n", small, big);
	
		
	}
	
}
