package com.test.java.inheritance2;

public class Ex48_Interface {

	public static void main(String[] args) {
		
		// 객체 지향 프로그래밍(OOP, Object Oriented Programming)
		// -> 클래스(객체) -> 인터페이스
		
		
		// 인터페이스 , interface
		// - 클래스의 일종(자료형)
		// - 클래스와 구조도 상이, 목적도 상이
		// - 인터페이스는 객체를 생성할 수 없다. -> 추상 메소드 때문에.. -> 실체화된 객체가 구현부를 가지지 못한 메소드를 호출할 수 없기 때문에..
		// - 객체도 못만드는 자료형이 과연 쓸모가 있느냐? -> 클래스의 부모 역할 -> *** 상속 관계에서 사용
		
		
//		Test t = new Test();
//		t.aaa();
//		t.test();
//		t.bbb();
		
		//Phone p = new Phone(); -> 행동이 불안정해서 객체를 만들 수 없음. 
		//p.test(); //이 작업이 불가능하기 때문에 인터페이스는 객체를 생성할 수 없다.
		
		
		S21 s = new S21();
		s.test();
		
		
		
	}//main
	
}//Ex48_Interface

// 인터페이스 선언하기
interface Phone{
	
	// 인터페이스 멤버
	
	// {} 없음 -> 구현부가 없는 메소드 -> 실체화가 되지 않은 메소드 -> 추상 메소드(Abstract Method) -> 호출해도 사용이 불가능하다. -> 현 상태로는 사용할 수 없다.
	public abstract void test(); //abstract 붙이는게 정석 
	
	//public int a;
	
	//public void test() {
	//}
	
}

// 상속 키워드
// 1. extends
// - 클래스 -> 클래스
// 2. implements
// - 클래스 -> 인터페이스

//The type S21 must implement the inherited abstract method Phone.test()
// - 물려받은 메소드를 꼭 구현해야함. -> 헤더 + 바디까지 구현해야함. 즉, 오버라이드 해라
class S21 implements Phone { //상속

	//public abstract void test()
	
	
	// 오버라이드 -> 구현부 생성
	// 인터페이스가 물려준 추상 메소드를 물려받고 + 재정의 -> ******
	
	// 일반 상속 -> 오버라이드 -> 개발자의 선택
	// 인터페이스 상속 -> 오버라이드 -> 개발자의 선택X -> 무조건 필수 !! -> 안하면 컴파일 오류 -> 강제 !!!!
	public void test() {
		System.out.println("테스트입니다.");
	}
	
}


// 네가(I12)가 내(Phone) 자식이 되려면 내가 시키는 걸 반드시 해라 !!
// -> 시키는 일 -> 추상 메소드를 구현하는 것 -> 추상 메소드에 없는 몸통을 만드는 것 -> 오버라이드
class I12 implements Phone {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

	
//	public void test() {
//		// 이 안쪽은 I12맘대로..
//	}

	
	
}


// 일반 클래스는 추상 메소드를 가질 수 없다(********)
class Test{
	
	// 추상 메소드와 일반 메소드와 구분 할 수 없음 -> 그래서 추상 메소드 가질 수 없음.
	//public abstract void test();
	
	public void aaa() {
		
	}
	public void bbb() {
		
	}
}
