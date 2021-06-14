package com.test.java.inheritance;

public class Ex41_Inheritance {

	public static void main(String[] args) {
		
		/*
		
		상속, Inheritance
		- 클래스 상속
		- 클래스와 클래스간에 구현 가능한 기술
		- 부모 -> (재산) -> 자식
		- 클래스 -> (멤버(변수, 메소드)) -> 클래스
		- 상속은 자신이 부모의 멤버를 거부할 권한이 없다. > 무조건 100% 물려받는다.
		- JDK 기준 > 1단계 ~ 7단계
		
		- 부모 클래스 -> 자식 클래스 // 상속(Inheritance)
		- 슈퍼 클래스 -> 서브 클래스 // UML
		- 기본 클래스 -> 확장 클래스
		
		상속을 왜 하는지??
		- 코드 재사용(***************)
		
		*/

		Parent p = new Parent();
		System.out.println(p.a);
		System.out.println(p.b);
		p.aaa();
		
		//System.out.println(p.c);
		//System.out.println(p.d);
		//p.bbb();
		
		Child c = new Child();

		// 부모로부터 상속받은 멤버
		System.out.println(c.a);
		System.out.println(c.b);
		c.aaa();
		
		//자신이 구현한 멤버
		System.out.println(c.c);
		System.out.println(c.d);
		
		
		GrandChild g = new GrandChild();
		//할아버지가 물려준 멤버(Parent 클래스)
		System.out.println(g.a);
		System.out.println(g.b);
		g.aaa();
		
		// 아버지가 물려준 멤버(Child 클래스)
		System.out.println(g.c);
		System.out.println(g.d);
		g.bbb();
		
		// 자신이 구현한 멤버(GrandChild 클래스)
		System.out.println(g.e);
		System.out.println(g.f);
		g.ccc();
		
		
		
	}//main
	
}//Ex41_Inheritance


// 부모 클래스(멤버 3개)
class Parent {
	public int a = 10;
	public int b = 20;
	
	public void aaa() {
		System.out.println("AAA");
	}
}

//자식 클래스 (멤버 6개)
class Child extends Parent{ // Parent 클래스를 부모로 해서 상속을 받겠다. (Parent와 Child를 상속 관계로 만든다.)
	
	public int c = 30;
	public int d = 40;
	public void bbb() {
		System.out.println("BBB");
	}
	
}

//손자 클래스(멤버 9개) > 생산성이 높아진다. + 사용이 어려워진다.
class GrandChild extends Child{
	
	public int e = 50;
	public int f = 60;
	
	public void ccc() {
		System.out.println("CCC");
	}
	
}
