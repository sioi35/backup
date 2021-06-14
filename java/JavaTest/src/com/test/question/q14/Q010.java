package com.test.question.q14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q010 {
	
	public static void main(String[] args) throws IOException {
		
		//입력받은 금액을 한글로 출력하시오.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("금액(원): ");
		String money = reader.readLine();

		String result = "";//결과를 저장할 변수 초기화
		
		int j = money.length(); // 단위 계산을 위해 money의 길이를 저장
		
		for (int i=0; i<money.length(); i++) {
			if(money.length() > 5) {
				System.out.println("최대 자릿수를 초과했습니다.");
				break;
			}
			char c = money.charAt(i);
			if(i<0) { // 영백원 영천원 이 나오지 않게 설정
				if (c == '0') {
					result += "영";
				}	
			}
			if (c == '1') {
				result += "일";
			} else if (c == '2') {
				result += "이";
			} else if (c == '3') {
				result += "삼";
			} else if (c == '4') {
				result += "사";
			} else if (c == '5') {
				result += "오";
			} else if (c == '6') {
				result += "육";
			} else if (c == '7') {
				result += "칠";
			} else if (c == '8') {
				result += "팔";
			} else if (c == '9') {
				result += "구";
			} else {
				result+="";
			}
			
			// 금액이 다섯자리이면 만단위부터 시작. 
			// for문 한번 돌때마다 한 단위씩 작게 j--해줌.
			if(c != '0') {
				if(j==5) {
					result += "만";
					j--;
				}else if(j==4) {
					result += "천";
					j--;
				}else if(j==3) {
					result += "백";
					j--;
				}else if(j==2) {
					result += "십";
					j--;
				}else if(j==1) {
					result +="원";
				}
			}
			else {  // 금액에 0이 들어오면 단위 출력 X, 단위는 줄여줌 // 2200원일때 이천이백영십영원->이천이백원
				j--;
			}
			
		}//for
		System.out.println(result);
	}//main

} //Q010
