package com.test.question.q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q010 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("누적값: ");
		int max = Integer.parseInt(reader.readLine());
		
		int sum = 0;
		
		while(sum <= max) {
		
			System.out.print("숫자:");
			int num = Integer.parseInt(reader.readLine());
			if(num % 2==0) {
				sum += num;	
				System.out.printf("+%d",num);
			} else {
				sum -= num;
				System.out.printf("-%d",num);
			}
			
		}//while
		
		System.out.printf(" = %d", sum);
		
	}//main

}//Q010
