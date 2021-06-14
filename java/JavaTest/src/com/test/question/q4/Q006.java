package com.test.question.q4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q006 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("국어: ");
		int kor = Integer.parseInt(reader.readLine());
	
		System.out.print("영어: ");
		int eng = Integer.parseInt(reader.readLine());
		
		System.out.print("수학: ");
		int math = Integer.parseInt(reader.readLine());
				
		System.out.println(test(kor, eng, math) + "입니다.");
	}

	public static String test(int kor, int eng, int math) {
		int avg = (kor + eng + math) / 3;
		
		String result1 = (kor < 40) || (eng < 40) || (math < 40)? "과락 ": ""; 
		
		String result2 = (avg >= 60) && ( result1 != "과락 " ) ? "합격" : "불합격";
		
		return result1 + result2;
	}
	
}
