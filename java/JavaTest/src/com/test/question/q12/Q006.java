package com.test.question.q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q006 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		
		System.out.print("시작 숫자: ");
		int start = Integer.parseInt(reader.readLine());
		
		System.out.print("종료 숫자: ");
		int end = Integer.parseInt(reader.readLine());
		
		
		for(int i = start; i <= end; i++) {
			
			if(i == end) {
				if(end %2 ==0) {
					sum -= i;
				}else {
					sum+= i;
				}
				System.out.printf("%d = %d",i, sum);
				break;
			}
			if(i % 2 == 0) {
				sum -= i;
				System.out.printf("%d + ", i);
			}else {
				sum += i;
				System.out.printf("%d - ", i);
			}
			
		}
		
	}//main
	
}//Q006
