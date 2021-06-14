package com.test.question.q14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q002 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이메일(@포함) : ");
		String email = reader.readLine();
		int at = 0; // @
			
		for(int i = 0; i< email.length(); i++) { // @ 위치 찾기
			
			if(email.charAt(i) == '@') {
				at = i;
				break;
			}	
		}
		
		String ID = email.substring(0, at ); // @ 앞으로는 아이디.
		String domain = email.substring(at+1, email.length()); // @뒤로는 도메인
		
		System.out.printf("아이디: %s",ID);
		System.out.printf("도메인 : %s", domain);
		
		
	}//main
	
}//Q002
