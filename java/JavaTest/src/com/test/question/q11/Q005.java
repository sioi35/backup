package com.test.question.q11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q005 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번쨰 숫자: ");
		int firstNum = Integer.parseInt(reader.readLine());
		
		System.out.print("두번쨰 숫자: ");
		int secondNum = Integer.parseInt(reader.readLine());
		
		System.out.print("연산자: ");
		char operator = (char) reader.read();
		
		if (operator == '+') {
			System.out.printf("%d %s %d = %d", firstNum, operator, secondNum, firstNum + secondNum);
		}else if(operator == '-') {
			System.out.printf("%d %s %d = %d", firstNum, operator, secondNum, firstNum - secondNum);
		}else if(operator == '*') {
			System.out.printf("%d %s %d = %d", firstNum, operator, secondNum, firstNum * secondNum);
		}else if(operator == '/') {
			System.out.printf("%d %s %d = %d", firstNum, operator, secondNum, firstNum / secondNum);
		}else if(operator == '%') {
			System.out.printf("%d %s %d = %d", firstNum, operator, secondNum, firstNum % secondNum);
		}else {
			System.out.println("연산 불가");
		}
		
	}
	
}
