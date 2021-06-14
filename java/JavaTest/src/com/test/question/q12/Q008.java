package com.test.question.q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Q008 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int yearSum=0; //평년 윤년 계산하여 총 년수 -> 일로 변환
		int sum = 0;
		int daySum =0 ;
		String day_of_week="";
		
		System.out.print("년도 입력: ");
		int year = Integer.parseInt(reader.readLine());
		
		System.out.print("월 입력: ");
		int month = Integer.parseInt(reader.readLine());
		
		System.out.print("일 입력: ");
		int day = Integer.parseInt(reader.readLine());
		
		for(int i = 1; i< year; i++){
			if(LeapYear(i) == 0) {
				yearSum+= 365;
			}else {
				yearSum+= 366;				
			}	
		}
		
		for( int i = 1; i < month; i++ ) { //해당 월 전달까지 -> 일수 더하기
			
			switch(i) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				daySum += 31;
				break; 
			case 4:
			case 6:
			case 9:
			case 11:
				daySum += 30;
				break;
			case 2: 
				if(LeapYear(year)==0) {
					daySum += 28;  
				}else {
					daySum += 29;
				}
				break;
			}//switch문
			
		}//for문
		
		System.out.println(yearSum);
		System.out.println(daySum);
		
		sum = yearSum + daySum + day; //년월일 -> 일로 맞추기
		
		
		switch((sum) % 7) {
			case 1: 
				day_of_week = "월";
				break;
			case 2: 
				day_of_week = "화";
				break;
			case 3: 
				day_of_week = "수";
				break;
			case 4: 
				day_of_week = "목";
				break;
			case 5: 
				day_of_week = "금";
				break;
			case 6: 
				day_of_week = "토";
				break;
			case 0: 
				day_of_week = "일";
				break;
		}//switch
		
		
		System.out.printf("%d년 %d월 %d일은 1년 1월 1일로부터 %d일째 되는 날이고 %s요일입니다.\n",year, month, day, sum, day_of_week);
	}

	public static int LeapYear(int year) {
		int leapYear = 0;
		
			if(year % 4 == 0) 
			{		
				if(year % 100 ==0)
				{
					if(year % 400 == 0) 
					{
						leapYear = 1;//윤년
					}
					else 
					{
						leapYear = 0;//평년
					}	
				}else
				{
					
					leapYear = 1;
				}
			}
			else
			{
				leapYear = 0;
			}
		return leapYear;
	}//LeapYear //윤년 평년 계산
	
	
}//Q008
