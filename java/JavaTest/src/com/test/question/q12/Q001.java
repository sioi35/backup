package com.test.question.q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q001 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이름: ");
		String name = reader.readLine();
		System.out.print("횟수: ");
		int num = Integer.parseInt(reader.readLine());
		
		for(int i = 1; i <= num; i++) {
			System.out.printf("%s님 안녕하세요~\n", name);
		}//for문
		
		
	}//main
	
}//Q001
