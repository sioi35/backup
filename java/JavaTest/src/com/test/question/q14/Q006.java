package com.test.question.q14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q006 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("주민등록번호: ");
		String jumin = reader.readLine();
		
		// 970509-1234567
		for(int i= 0; i<jumin.length(); i++) {
			
			if(jumin.charAt(i) < '0' || jumin.charAt(i) >'9' ) {
				System.out.println("올바르지 않은 주민등록번호입니다.");
				break;
			}
			if(jumin.charAt(2)>3) {
				System.out.println("올바르지 않은 주민등록번호입니다.");
				break;				
			}
			
			
		
			
		}
		
		
		
		
		
		
	}//main
	
}//Q006
