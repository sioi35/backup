package com.test.question.q4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q003 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자 입력: ");
		int num = Integer.parseInt(reader.readLine());
		
		digit(num);
		
	}//main
	
	public static void digit(int num) {
	
		System.out.printf("%04d", num);
	
	} //digit
		
	
}//Q003
