package com.test.question.q14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q011 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("문장 입력: ");
		String txt = reader.readLine();
		
		int sum = 0;
		int i=0;
		
		while(i<txt.length()) {
			char a = txt.charAt(i);
			if(a >= '0' && a<='9') {
				sum += (int)a -48;
			}
			i++;
		}
		
		System.out.printf("문장에 존재하는 모든 숫자의 합은 %d입니다\n",sum);
		
	}//main
	
}//Q011
