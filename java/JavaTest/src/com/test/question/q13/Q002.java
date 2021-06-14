package com.test.question.q13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("행의 갯수: ");
		int num = Integer.parseInt(reader.readLine());
		
		int i, j, k;
		
		
		for(i = 0; i< num; i++) {
			for(j=i; j<num-1; j++) {
				System.out.print(" ");
			}
			for(k=0; k<=i; k++) {
				System.out.print("*");
			}			
			System.out.println();
		}
		
	}//main
	
}//Q002
