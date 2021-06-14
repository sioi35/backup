package com.test.question.q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q003 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("너비(cm): ");
		int weight = Integer.parseInt(reader.readLine());
		
		System.out.print("높이(cm): ");
		int height = Integer.parseInt(reader.readLine());
		
		System.out.printf("사각형의 넓이는 %d(cm)^2입니다\n", weight * height);
		System.out.printf("사각형의 넓이는 %d(cm)입니다.\n", weight * 2 + height *2);
		
	}
	
}
