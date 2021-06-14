package com.test.java;

public class Ex15_Method {
	
	public static void main(String[] args) {
		
		/* 
		public static 반환타입 test(인자 리스트){
			실행코드;
		}
		*/
		
		// 메소드 반환값
		// - 메소드 실행 후 돌려받는 데이터
		// - 누가 돌려받는지? > 메소드를 호출한 곳에서 반환값을 돌려받는다. 
		
		
		int result = m1(); //메소드의 반환값을 받아서 콘솔에 출력 !!!
		System.out.println(result);
		
		add(10,20);
		System.out.println(add(10,20));
		
		// 메소드 = 함수 -> 수학의 함수 정의 f(x) = y
		int n = add(30,40);
		System.out.println(n);
		
		int age = 25;
		String result2 = check(age) ? "성인" : "미성년자";
		System.out.println(result2);
		
		
	} //main
	
	// 반환값이 있는 메소드를 선언했다. 
	public static int m1(){
		
		int num = 100;
		
		return num; //return문, 반환문
	}	
	
	/*
	public static String m2(){
		
		int num = 100;
		
		return "홍길동"; //return문, 반환문 -> 반환값은 한개만 가능
	}	
	*/
	
	//void : 돌려줄 값이 없다. 
	public static int add(int a, int b) {
		
		return a + b;		
		
	}
	
	// 나이에 따라 성인/미성년을 확인해주는 메소드
	public static boolean check(int age) {		
		
		return age >= 19 ? true : false;
		
	}
	
}//Ex15_Method
