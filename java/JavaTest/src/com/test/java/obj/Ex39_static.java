package com.test.java.obj;

public class Ex39_static {

	public static void main(String[] args) {

		//외부 환경
		// 1. 객체 변수 접근
		StaticItem item1 = new StaticItem();
		
		item1.a = 100;
		
		// 2. 정적 변수 접근
		StaticItem.b = 200;
		
		item1.aaa();
		
		StaticItem.bbb();
		
		
	}//main
	
}//Ex39_static


class StaticItem{
	
	//멤버
	//1. 변수
	// a. 객체 변수 -> 개인 정보 저장
	// b. 정적 변수 -> 공용 정보 저장
	//2. 메소드
	// a. 객체 메소드 -> 개인 행동
	//		- 객체 변수 접근 가능
	// 		- 정적 변수 접근 가능
	// b. 정적 메소드 -> 공용(단체) 행동
	//		- 객체 변수 접근 불가능
	//		- 정적 변수 접근 가능
	
	
	
	public int a = 10;
	public static int b = 20;
	
	//객체 메소드
	public void aaa() {
		System.out.println(a);
		System.out.println(b);
		
		System.out.println(this.a); //같은 객체 내부라서 생략 가능
		System.out.println(StaticItem.b); // 같은 클래스 내부라서 생략 가능
	}
	
	//정적 메소드
	public static void bbb(){
		//Cannot use this in a static context //static메소드 안에서 this. 사용 못함
		//System.out.println(this.a);//Cannot make a static reference to the non-static field a
		System.out.println(StaticItem.b);
	}
}