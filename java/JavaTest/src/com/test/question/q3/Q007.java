package com.test.question.q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q007 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("섭씨(C): ");
		double ctem = Double.parseDouble(reader.readLine());
		
		double ftem = ctem * 1.8 + 32;
		System.out.printf("섭씨 %.1f(C)는 화씨 %.1f(F)입니다.: ", ctem, ftem);
		
	}
		
}
