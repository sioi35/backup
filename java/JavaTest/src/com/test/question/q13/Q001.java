package com.test.question.q13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q001 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int i, j, k;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("행의 갯수: ");
		int num = Integer.parseInt(reader.readLine());
		
		for(i = 0; i< num; i++) {
			for(k=0; k<i; k++) {
				System.out.print(" ");
			}
			for(j=i; j<num; j++) {
				System.out.print("*");
			}			
			System.out.println();
		}
		
	}//main

}//Q001
