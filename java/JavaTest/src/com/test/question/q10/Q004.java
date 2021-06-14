package com.test.question.q10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q004 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.print("남자 이름: "); 
		String man = reader.readLine();
		  
		System.out.print("여자 이름: ");
		String girl = reader.readLine();
		 
		System.out.print("만난날(년): ");
		int year = Integer.parseInt(reader.readLine());
		
		System.out.print("만난날(월): ");
		int month = Integer.parseInt(reader.readLine());

		System.out.print("만난날(일): ");
		int day= Integer.parseInt(reader.readLine());
		System.out.println();
		
		Calendar anniversary = Calendar.getInstance();
		anniversary.set(year, month-1, day);
		
		System.out.printf("'%s'과(와) '%s'의 기념일\n", man, girl);
		
		System.out.printf("기념일: %tF\n", anniversary);
		
		anniversary.add(Calendar.DATE, 100);	// + 100	
		System.out.printf("100일 : %tF\n", anniversary);

		anniversary.add(Calendar.DATE, 100);	// + 200	
		System.out.printf("200일 : %tF\n", anniversary);
		
		anniversary.add(Calendar.DATE, 100);	// + 300	
		System.out.printf("300일 : %tF\n", anniversary);
		
		anniversary.add(Calendar.DATE, 200);	// + 500	
		System.out.printf("500일 : %tF\n", anniversary);
		
		anniversary.add(Calendar.DATE, 500);	// + 1000	
		System.out.printf("1000일 : %tF\n", anniversary);
		
		
	}//main
		
}//Q004
