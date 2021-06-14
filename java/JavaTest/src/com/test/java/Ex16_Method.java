package com.test.java;

public class Ex16_Method {

	public static void main(String[] args) {
		
		// 자바 변수 종류
		// 1. 클래스 멤버 변수
		// 2. 지역 변수 
		
		// 지역 변수, Local Variable
		// - 변수는 자신의 영역이 존재한다. (자신이 활동할 수 있는 지역) > Scope
		// - 지역을 벗어나면 사용이 불가능(접근이 불가능)하다. 
		
		// 변수 생명 주기, Life Cycle
		// - 변수가 언제 태어나고, 언제 죽는지?
		// - 변수가 언제 메모리에 할당이 되고.. 언제 메모리에서 해제가 되는지? 
		// - 변수는 변수 선언문이 실행되는 시점에 태어난다.(메모리에 할당된다.)
		// - 변수는 자신이 속한 블럭에서 제어가 벗어나는 순간 죽는다.(메모리에서 소멸된다.)
				
		// Local Variable, 로컬 변수, 지역 변수
		// - 여태 수업했던 모든 변수는 지역 변수이다. 
		int a = 10; //main() 메소드를 자신의 영역으로 하는 지역 변수이다.
		
		m1(); // Ctrl + 1 > 메소드 생성
		System.out.println(a);
		//System.out.println(b);  //에러.. m1 지역 변수를 main 지역에서는 접근 불가능
	
		String name = "홍길동";
		
		
	}//main

	private static void m1() {
		
		String name = "아무개";
		//a cannot be resolved to a variable
//		System.out.println(a);  // 지역변수라서..
		
		int b = 20; //m1()을 자기 영역으로 가지는 지역 변수
		System.out.println(b);
	}

}//Ex16_Method
