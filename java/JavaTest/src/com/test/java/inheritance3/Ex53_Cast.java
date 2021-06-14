package com.test.java.inheritance3;

public class Ex53_Cast {

	public static void main(String[] args) {
		
		/*
		형변환, Type Cast
		1. 값형 형변환 : 값형끼리만 가능
		2. 참조형 형변환 : 참조형끼리만 가능 > 클래스간의 형변환
		
		값형 형변환
		- 숫자형끼리 가능(boolean 불가능)
		- 작은형 -> 큰형 : 암시적(100% 안전)
		- 큰형 -> 작은형 : 명시적(Overflow 발생 가능)
		
		
		참조형 형변환
		- 클래스간의 형변환
		- 상속 관계를 맺은 (직계)클래스간에만 가능
		- 자식클래스 -> 부모클래스 : 암시적(100% 안전), 업 캐스팅(Up Casting)
		- 부모클래스 -> 자식클래스 : 명시적(Overflow 발생 가능), 다운 캐스팅(Down Casting), 100% 불가능, 되는 경우O
		 
		*/
		
		Parent p1 = new Parent();
		
		Child c1 = new Child();
		
		
		Parent p2;  //복사본
		Child c2 = new Child();  //원본
		
		// Parent = Child 
		// 부모 클래스 = 자식 클래스
		// 업 캐스팅 발생(암시적)
		p2 = c2;
		//p2 = (Parent)c2;
		
		
		// 복사가 제대로 이루어졌는지 확인??
		// -> 참조형 형변환의 확인 방법 -> "복사된 참조 변수(p2)를 올바르게 사용할 수 있는가?"(***********************)
		
		//"p2로 할 수 있는 모든 행동을 테스트 중.."(***********)
		
		p2.a = 10;
		p2.b = 20;
		
		System.out.println(p2.a);
		System.out.println(p2.b);

		
//		Parent p3 = new Parent(); //원본
//		Child c3; //복사본
//		
//		// Child = Parent
//		// 자식 클래스 = 부모 클래스
//		// 다운 캐스팅(명시적)
//		c3 = (Child) p3; //에러 !!(java.lang.ClassCastException) -> Parent cannot be cast to class Child 
//		
//		
//		//검증
//		// 복사가 제대로 이루어졌는지 확인??
//		//"p3로 할 수 있는 모든 행동을 테스트 중.."(***********)
//		
//		c3.a = 10; //O
//		c3.b = 20; //O
//		c3.c = 30; //X
//		c3.d = 40; //X
//		
//		System.out.println(c3.a); //O
//		System.out.println(c3.b); //O
//		System.out.println(c3.c); //X
//		System.out.println(c3.d); //X
		
		Parent p4;
		Child c4 = new Child();
		
		//업캐스팅
		p4 = c4; //안전
		
		Child c5;
		
		//다운 캐스팅(100% 불가능) -> 가능한 (작업**)
		// 자식 클래스 = 부모 클래스
		c5 = (Child)p4; // 실제(**): Child -> Child
		
		System.out.println(c5.a);
		System.out.println(c5.b);
		System.out.println(c5.c);
		System.out.println(c5.d);
		
	}//main
	
}//Ex53_Cast


class Parent{
	public int a;
	public int b;
}

class Child extends Parent{
	public int c;
	public int d;
}


