package com.test.question.q10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q005 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("아빠 생일(년): ");
		int fyear = Integer.parseInt(reader.readLine());
		System.out.print("아빠 생일(월): ");
		int fmonth = Integer.parseInt(reader.readLine());
		System.out.print("아빠 생일(일): ");
		int fday = Integer.parseInt(reader.readLine());
		
		
		System.out.print("딸 생일(년): ");
		int dyear = Integer.parseInt(reader.readLine());
		System.out.print("딸 생일(월): ");
		int dmonth = Integer.parseInt(reader.readLine());
		System.out.print("딸 생일(일): ");
		int dday = Integer.parseInt(reader.readLine());
		
		Calendar father = Calendar.getInstance();
		father.set(fyear, fmonth, fday);
		
		Calendar daughter = Calendar.getInstance();
		daughter.set(dyear, dmonth, dday);
		
		long fatherTick = father.getTimeInMillis();
		long daughterTick = daughter.getTimeInMillis();
		System.out.printf("아빠는 딸보다 총 %d일을 더 살았습니다.",(daughterTick - fatherTick) / 1000 / 60 / 60 / 24);
		
	}
	
}
