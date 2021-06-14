package com.test.question.q13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q005 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행의 갯수: ");
		int num = Integer.parseInt(reader.readLine());
		
		char c = 'a'; 
				
		for(int i = 0; i<num; i++) { 
			for(int j=0; j<(num-i); j++) {
				System.out.print(" ");
			}
			c='a';
			for(int j = 0; j <= i; j++) { 
				System.out.printf("%c",c);
				c++;
			}
			for(int k= 0; k<=i; k++) {
				c--;
				System.out.printf("%c",c);	
				
			}
			System.out.println();
			
		} 
		System.out.println();

		
	}//main
	
}//Q005
