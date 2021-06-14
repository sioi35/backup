package com.test.question.q15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q006 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("시작 숫자: ");
		int start = Integer.parseInt(reader.readLine());
		
		System.out.print("종료 숫자: ");
		int end = Integer.parseInt(reader.readLine());
		
		System.out.print("배열 크기: ");
		int size = Integer.parseInt(reader.readLine());
		
		int[] list = new int[size];
		
		for(int i=0; i<list.length; i++) {
			
			list[i]= (int)(Math.random()* (end-start+1)+start);
			for(int j=0; j<i; j++) {
				if(list[i]==list[j]) {
					i--;
					break;
				}
			}
		}
		
		for(int i =0; i<list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
		
	}//main
	
}//Q006
