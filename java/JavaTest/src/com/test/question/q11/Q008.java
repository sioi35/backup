package com.test.question.q11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q008 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("[들어온 시간]");
		System.out.print("시: ");
		int inhour = Integer.parseInt(reader.readLine());
		
		System.out.print("분: ");
		int inminute = Integer.parseInt(reader.readLine());
			
		System.out.println("[나가는 시간]");
		System.out.print("시: ");
		int gohour = Integer.parseInt(reader.readLine());
		
		System.out.print("분: ");
		int gominute = Integer.parseInt(reader.readLine());
		
		// 시를 분으로 환산하여 나간 시간 - 들어온 시간 = 주차한 시간
		int parkingTime = (gohour - inhour) * 60 + (gominute - inminute); 

		int fee = 2000;
		
		if(parkingTime > 30) 
		{ //주차한 시간이 무료시간보다 크면 실행
	
			if(parkingTime - 30 < 10) {
				System.out.printf("주차 요금은 %d원입니다.", fee);				
			}else {
				fee = fee + 2000 * ((parkingTime - 30)/ 10);
				System.out.printf("주차 요금은 %d원입니다.", fee);				
			}
		}else
		{
			System.out.println("주차 요금은 무료입니다.");
		}
	
		
	}
	
}
