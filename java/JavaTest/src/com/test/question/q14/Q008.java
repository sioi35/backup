package com.test.question.q14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q008 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("단어: ");
		String txt = reader.readLine();
		
		String result = txt.substring(0,1);// 첫 글자는 대문자여도 띄어쓰기 필요없으니까 저장해놓기
		

		for(int i =1; i<txt.length() ; i++) {// 두번쨰 글자부터 시작
			
			char c = txt.charAt(i); // 한글자씩 추출해서
			
			if(c >= 'A' && c <= 'Z') {// 대문자인지 비교
				result += " "+ c;//대문자면 띄어쓰기추가
			}else {
				result += c;
			}
		}
	
		System.out.printf("결과: %s\n", result);
		
	}//main
	
}//Q008
