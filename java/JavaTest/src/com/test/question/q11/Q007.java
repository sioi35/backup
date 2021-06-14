package com.test.question.q11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q007 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// if문을 줄일 수 있는 방법을 찾으면 좋을 것 같다.
		
		System.out.print("숫자 입력: ");
		int one = Integer.parseInt(reader.readLine());
		
		System.out.print("숫자 입력: ");
		int two = Integer.parseInt(reader.readLine());
		
		System.out.print("숫자 입력: ");
		int three = Integer.parseInt(reader.readLine());
		
		System.out.print("숫자 입력: ");
		int four = Integer.parseInt(reader.readLine());
		
		System.out.print("숫자 입력: ");
		int five = Integer.parseInt(reader.readLine());
		
		int odd = 0; //홀
		int even = 0;//짝
		
		if(one % 2 == 0) {
			even++;
			
		}else {
			odd++;
		}
		
		if(two % 2 == 0) {
			even++;
		}else {
			odd++;
		}
		
		if(three % 2 == 0) {
			even++;
		}else {
			odd++;
		}
		
		if(four % 2 == 0) {
			even++;
		}else {
			odd++;
		}
		
		if(five % 2 == 0) {
			even++;
		}else {
			odd++;
		}
			
		System.out.printf("짝수는 %d개 홀수는 %d개 입력했습니다.\n", even, odd);
		
		if (even > odd) {
			System.out.printf("짝수가 홀수보다 %d개 많습니다.\n",  even-odd);
		}else {
			System.out.printf("홀수가 짝수보다 %d개 많습니다.\n", odd-even);			
		}
		
	}
}
