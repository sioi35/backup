package com.test.question.q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q009 {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int computer = ((int)(Math.random()* 10) + 1); // 1~10사이의 난수 생성
	
		int count = 0; //시도 횟수
		
		for(;;) {
			System.out.print("숫자: ");
			int num = Integer.parseInt(reader.readLine());
			
			count++; // 시도한 횟수 증가
			
			if(num == computer) {
				System.out.println("정답입니다~!\n");
				System.out.printf("컴퓨터가 생각한 숫자는 %d입니다.\n", computer);
				System.out.printf("정답을 맞추는데 시도한 횟수는 %d회입니다.\n", count);
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			else {
				System.out.println("틀렸습니다!");
				System.out.println();
			}//if-else문
			
		}//for문
		
		
	}//main
	
}//Q009
