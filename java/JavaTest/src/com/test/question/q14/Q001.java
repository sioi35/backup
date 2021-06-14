package com.test.question.q14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q001 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문장입력: ");
		String txt = reader.readLine();
		
		// i = 마지막 글자 ~ 0까지
		for(int i = txt.length()-1; i >= 0; i--) {
			System.out.println(txt.substring(i, i+1)); 
		}
		
	}//main
	
}//Q001
