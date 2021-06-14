package com.test.question.q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q019 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("첫번째 숫자 : ");
		int first = Integer.parseInt(reader.readLine());
		
		System.out.print("두번째 숫자 : ");
		int second = Integer.parseInt(reader.readLine());
		
		
		System.out.printf("%d의 약수:", first);
		for(int j = 1; j <= first; j++) {
			if(first % j ==0) {
				System.out.printf("%d ",j);
			}
		}System.out.println();
		
		
		System.out.printf("%d의 약수:", second);
		for(int j = 1; j <= second; j++) {
			if(second % j ==0) {
				System.out.printf("%d ",j);
			}
		}System.out.println();
			
		int num = first > second? first: second;
		System.out.printf("%d와 %d의 공약수: ", first, second);
		for(int i=1; i< num; i++) {
			if(first % i ==0 && second % i == 0) {
				System.out.printf("%d ",i);
			}
		}
		
		
		
	}//main
	
}//Q019
