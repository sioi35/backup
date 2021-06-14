package com.test.java;

public class Ex18_Recursive {

	public static void main(String[] args) {
		// 이름 바꿀 때 -> 클릭하고 f2키 누르면 사용한 전체 이름 바꿔줌 
		//Ex18_Recursive.java 
		
		// 재귀 메소드, Recursive Method
		// - 메소드가 자신의 구현부에서(body) 자신을 호출하는 구문을 가지는 메소드
		// - 자기가 자기를 호출하는 메소드
				
		//test();
		
		// 팩토리얼 
		// 4! = 4 x 3 x 2 x 1
		// 4! = 24
		
		int n = 4;
		
		int result = factorial(n);
		
		System.out.printf("%d! = %d\n", n, result);
		
	}//main
	
	public static int factorial(int n) {
		
		int temp = (n == 1) ? 1 : n * factorial(n - 1);
		
		return temp;
	}

	// test() 메소드의 호출 횟수 : 무한대
	public static void test() {
		//StackOverflowError - 메모리가 꽉차서 더이상 아무것도 못합니다...
		System.out.println("테스트입니다.");
		
		test(); //****
	}
		
}//Ex18_Recursive