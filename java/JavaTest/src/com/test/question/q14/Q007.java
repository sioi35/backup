package com.test.question.q14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q007 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자: ");
		String num = reader.readLine();
	

		String result = "";
		
		int index = num.length(); 
				
		for (int i=0; i<num.length(); i+=3) {				
			result = num.substring((index - i - 3) > 0 ?  
					(index - i - 3) : 0, index - i) 
					+ "," + result;
		}
		
		System.out.printf("결과: %s\n ", result.substring(0, result.length()-1));
		
			
	}//main
	
}//Q007
