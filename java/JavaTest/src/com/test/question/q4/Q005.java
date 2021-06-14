package com.test.question.q4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q005 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자: ");
		
		int num = Integer.parseInt(reader.readLine());
		String result = getNumber(num);
		
		System.out.printf("입력하신 숫자는 '%d'는(은) %s입니다.", num, result);
		
	}//main
	
	public static String getNumber(int a) {
		
		return a%2 != 0 ? "홀수" : "짝수"	;	
	}//getNumber
	
}//Q005