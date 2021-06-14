package com.test.question.q10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q006 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("음식을 받기 원하는 시각");
		System.out.print("시: ");
		int hour = Integer.parseInt(reader.readLine());
		
		System.out.print("분: ");
		int minute = Integer.parseInt(reader.readLine());
	
		int zazangminute = minute - 10;
		int zazanghour = (zazangminute <0)? hour-1: hour;
		zazangminute = (zazangminute <0) ? (60+zazangminute): zazangminute;
		
		int chickenminute = minute - 18;
		int chickenhour = (chickenminute <0)? hour-1: hour;
		chickenminute = (chickenminute <0) ? (60+chickenminute): chickenminute;
		
		int pizzaminute = minute - 25;
		int pizzahour = (pizzaminute <0)? hour-1: hour;
		pizzaminute = (pizzaminute <0) ? (60+pizzaminute): pizzaminute;
		
		System.out.printf("짜장면 : %d시 %d분\n", zazanghour, zazangminute);		
		System.out.printf("치킨 : %d시 %d분\n", chickenhour, chickenminute);
		System.out.printf("피자 : %d시 %d분\n", pizzahour, pizzaminute );		
		System.out.println("");
		System.out.println("");
		
		System.out.println("Calendar 사용\n");
		System.out.print("음식을 받기 원하는 시각 \n시: ");
		int WantHour = Integer.parseInt(reader.readLine());
		
		System.out.print("분: ");
		int WantMinute = Integer.parseInt(reader.readLine());
		
		Calendar WantTime = Calendar.getInstance();
		WantTime.set(Calendar.HOUR_OF_DAY,WantHour); 
		WantTime.set(Calendar.MINUTE,WantMinute);
		
		Calendar ZzajangTime = Calendar.getInstance();
		ZzajangTime.set(Calendar.HOUR_OF_DAY,WantHour);
		ZzajangTime.set(Calendar.MINUTE,WantMinute-10);

	 
		Calendar ChickenTime = Calendar.getInstance();
		ChickenTime.set(Calendar.HOUR_OF_DAY,WantHour);
		ChickenTime.set(Calendar.MINUTE,WantMinute-18);
	 
		Calendar PizzaTime = Calendar.getInstance();
		PizzaTime.set(Calendar.HOUR_OF_DAY,WantHour);
		PizzaTime.set(Calendar.MINUTE,WantMinute-25);
		
		System.out.printf("짜장면 %d시 %d분 \n", ZzajangTime.get(Calendar.HOUR_OF_DAY),ZzajangTime.get(Calendar.MINUTE));
		System.out.printf("치킨 %d시 %d분 \n", ChickenTime.get(Calendar.HOUR_OF_DAY),ChickenTime.get(Calendar.MINUTE));
		System.out.printf("피자 %d시 %d분 \n", PizzaTime.get(Calendar.HOUR_OF_DAY),PizzaTime.get(Calendar.MINUTE));
		
	}//main

}
