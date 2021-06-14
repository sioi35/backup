package com.test.question.q14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q012 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("연산식 입력: ");
		String txt = reader.readLine();
		txt = txt.replace(" ", ""); //연산에 방해가 되지 않게 공백 제거
		
		String num1, num2;
		int index= 0;
		char op = ' '; //연산자를 저장할 변수 초기화
		
		if(txt.indexOf("+") > -1) {
			index = txt.indexOf("+");
			op = '+';
		}else if(txt.indexOf("-") > -1) {
			index = txt.indexOf("-");
			op = '-';
		}else if(txt.indexOf("*") > -1) {
			index = txt.indexOf("*");
			op = '*';
		}else if(txt.indexOf("/") > -1) {
			index = txt.indexOf("/");
			op = '/';
		}else if(txt.indexOf("%") > -1) {
			index = txt.indexOf("%");
			op = '%';
		}else {
			System.out.println("연산자가 올바르지 않습니다.");
		}
		
		
		//얻어온 index를 기준으로 앞 뒤 피연산자를 저장.
		num1 = txt.substring(0, index);
		num2 = txt.substring(index+1, txt.length());
	
		if(num1 == "" || num2 == "") {
			System.out.println("피연산자가 부족합니다.");
		}else {
			switch(op) {
				case '+':
					System.out.printf("%s + %s = %d\n", num1, num2, Integer.parseInt(num1) + Integer.parseInt(num2));
					break;
				case '-':
					System.out.printf("%s - %s = %d\n", num1, num2, Integer.parseInt(num1) - Integer.parseInt(num2));
					break;
				case '*':
					System.out.printf("%s * %s = %d\n", num1, num2, Integer.parseInt(num1) * Integer.parseInt(num2));
					break;
				case '/':
					System.out.printf("%s / %s = %.1f\n", num1, num2, Double.parseDouble(num1) / Double.parseDouble(num2));
					break;
				case '%':
					System.out.printf("%s %% %s = %d\n", num1, num2, Integer.parseInt(num1) % Integer.parseInt(num2));
					break;
			}
			
		}
		
	
	}//main
	
}//Q012