package com.test.question.q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q005 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("한달 수입 금액(원): ");
		int money = Integer.parseInt(reader.readLine());
		
		double tax = 0.967;
		
		System.out.printf("세후 금액(원): %,.0f원\n", money*tax);
		System.out.printf("세금(원): %,.0f원", money - (money*tax));
		

	}
	
}
