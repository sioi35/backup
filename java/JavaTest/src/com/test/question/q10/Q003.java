package com.test.question.q10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q003 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("태어난 년도: ");
		int birthyear = Integer.parseInt(reader.readLine());
		
		
		Calendar now = Calendar.getInstance();
		
		int age = now.get(Calendar.YEAR) - birthyear;
		
		System.out.printf("나이(만) : %d\n", age);
		System.out.printf("나이 : %d\n", age + 1);
	
	}	
}

