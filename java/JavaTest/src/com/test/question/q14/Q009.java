package com.test.question.q14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q009 {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("입력: ");
		String txt = reader.readLine();
		
		String bannedWord1 ="바보";
		String bannedWord2 ="멍청이";
		
		int count = 0; //금지어 횟수
		int index = 0;
		
		while (true) {
			index = txt.indexOf(bannedWord1, index);
			if (index > -1) { // 금지어 발견하면
				count++; // 횟수 추가
				index += bannedWord1.length(); // 발견한 위치 다음으로 인덱스 조정
			} else {
				break;
			}
		}
		
		while (true) {
			index = txt.indexOf(bannedWord2, index);
			if (index > -1) {
				count++;
				index += bannedWord2.length();
			} else {
				break;
			}
		}
			
				
		txt = txt.replace("바보", "**");
		txt = txt.replace("멍청이", "***");
		System.out.println(txt);
		
		System.out.printf("금지어를 %d회 마스킹했습니다.", count);
		
			
		
	}//main	

}//Q009
