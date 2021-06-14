package com.test.question.q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q005 {
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시작 숫자: ");
		int start = Integer.parseInt(reader.readLine());
		
		System.out.print("종료 숫자: ");
		int end = Integer.parseInt(reader.readLine());

		int sum = 0;
		for(int i = start; i<= end; i++) {
			if(i == end) {
				System.out.printf("%d = %d ", i, sum + end);
				break;
			}
			sum += i;
			System.out.printf("%d + ", i);
		}//for문
		
	}//main
	
}//Q005
