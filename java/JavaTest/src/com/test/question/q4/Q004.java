package com.test.question.q4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q004 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("첫번째 숫자: ");
		int n1 = Integer.parseInt(reader.readLine());
		
		System.out.print("두번째 숫자: ");
		int n2 = Integer.parseInt(reader.readLine());
		
		int result ; 
		result = add(n1,n2);
		System.out.println(result);
		result = add(n1,n1);
		System.out.println(result);
		System.out.println();
		
		result = subtract(n1,n2);
		System.out.println(result);
		System.out.println();
		
		result = multiply(n1,n2);
		System.out.println(result);
		result = multiply(n1,n1);
		System.out.println(result);
		System.out.println();
		
		result = (int)divide(n1,n2);
		System.out.println();
		//System.out.println(result);
		
		result = mod(n1,n2);
		System.out.println(result);
		System.out.println();
		
	}//main
	
	public static int add(int a, int b) {
		
		int result = a + b;
		System.out.printf("%d + %d = ", a, b, result);
		return result;
	
	}//add
	
	public static int subtract(int a, int b) {
		
		int result = a - b;
		System.out.printf("%d - %d = ", a , b);
		return result;
		
	}//subtract
	
	public static int multiply(int a, int b) {
		
		int result = a * b;
		System.out.printf("%d * %d = ", a , b);
		return result;
		
	}//multiply
	
	public static double divide(int a, int b) {
		
		double result = (double)a / b;
		System.out.printf("%d / %d = %.1f\n", a , b, result);
		return result;
		
	}//divide

	public static int mod(int a, int b) {
		
		int result = a % b;
		System.out.printf("%d %% %d = ", a , b);
		return result;
	
	}//mod
}//Q005