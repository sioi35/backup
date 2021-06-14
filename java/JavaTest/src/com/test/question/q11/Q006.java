package com.test.question.q11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q006 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문자: ");
		char word = (char) reader.read();
		
		if(word >= 65 && word <=90) {
			System.out.printf("결과: %c", word + 32 );
		}else if(word >= 97 && word <=122) {
			System.out.printf("결과: %c", word - 32 );			
		}
		
	}
	
}
