package com.test.java.obj;

public class Ex31_Class {

	public static void main(String[] args) {
		
		//객체(Object)
		// - 철학 용어
		// - 데이터 + 행동(Behavior)
		// - 변수 + 메소드		
		
		//클래스의 용도
		//1. 데이터의 집합 : 멤버 변수들의 집합 > 10~20%
		//2. 행동 집합 : 멤버 메소드들의 집합 > 3~4%
		//3. 데이터 + 행동 집합 : 멤버 변수 + 멤버 메소드들의 집합 > 80~90%
		
		divide(20,5); //생략형
		Ex31_Class.divide(10, 2); //정석

		//add.(10,20);//add cannot be resolved to a variable
		
	
		add(10,20); //아빠
		
		Ex31_Class.add(10, 20); //우리집 아빠 
		MyMath.add(10,20); //다른집 아빠
		
	}//main
	
	public static void add(int a, int b) {
		System.out.println(a + b);
	}
	
	public static void divide(int a, int b) {
		System.out.println(a / b);
	}//divide메소드
		
}//Ex31_Class // 같은 동네

//행동의 집합
class MyMath{ // 다른 동네
	
	public static void add(int a, int b) {
		System.out.println(a + b);
	}
	
	public static void substract(int a , int b) {
		System.out.println(a - b);
	}
	
	public static void multiply(int a, int b) {
		System.out.println(a * b);		
	}
	
} //MyMath클래스
