package com.test.question.q5;

public class Q001 {

	public static void main(String[] args) {
		sum(10);
		
		sum(10, 20);
		
		sum(10, 20, 30);
		
		sum(10, 20, 30, 40);
		
		sum(10, 20, 30, 40, 50);
		
	}//main

	private static void sum(int i) {
		
		int sum = i;
		System.out.printf("%d = %d\n", i, sum);
		
	}
	
	private static void sum(int i, int j) {
				
		int sum = i + j;
		System.out.printf("%d + %d = %d\n", i, j, sum);
		
	}	
	
	private static void sum(int i, int j, int k) {
		
		int sum = i + j + k;
		System.out.printf("%d + %d + %d = %d\n", i, j, k, sum);
		
	}
	
	private static void sum(int i, int j, int k, int l) {
		
		int sum = i + j + k + l;
		System.out.printf("%d + %d + %d + %d = %d\n", i, j, k, l, sum);
		
	}
	
	private static void sum(int i, int j, int k, int l, int m) {
		
		int sum = i + j + k + l + m;
		System.out.printf("%d + %d + %d + %d + %d = %d\n", i, j, k, l, m, sum);
		
	}
	
}
