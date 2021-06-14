package com.test.question.q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q013 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int money;
		int choice;
		int cola = 700;
		int soda = 600;
		int grape = 500;
		
		for(;;) {
			
			System.out.println("==========================");
			System.out.println("	   자판기");
			System.out.println("==========================");
			System.out.printf("1. 콜라		:%d원\n", cola);
			System.out.printf("2. 사이다		:%d원\n", soda);
			System.out.printf("3. 포도주스	:%d원\n", grape);
			System.out.println("--------------------------");
			System.out.print("금액 투입(원) : ");
			money= Integer.parseInt(reader.readLine());
			System.out.println("--------------------------");
			System.out.print("음료 선택(번호) : ");
			choice= Integer.parseInt(reader.readLine());
			switch(choice) {
				case 1: 
					if(money - cola > 0) {
						System.out.println("+콜라를 제공합니다.");
						System.out.printf("+잔돈 %d원을 제공합니다.\n", money - cola );
					}else {
						System.out.println("돈이 부족합니다.");						
					}
					break;
				case 2: 
					if(money - soda > 0) {
						System.out.println("+사이다를 제공합니다.");
						System.out.printf("+잔돈 %d원을 제공합니다.\n", money - soda );
					}else {
						System.out.println("돈이 부족합니다.");						
					}
					break;	
				case 3: 
					if(money - grape > 0) {
						System.out.println("+포도주스를 제공합니다.");
						System.out.printf("+잔돈 %d원을 제공합니다.\n", money - grape );
					}else {
						System.out.println("돈이 부족합니다.");						
					}
					break;
			}
			System.out.println();
			System.out.println("계속하시려면 엔터를 입력하세요.");
			String enter = reader.readLine();
			
		}//for문
		
		
	}//main
}//Q013
