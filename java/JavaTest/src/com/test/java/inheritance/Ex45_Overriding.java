package com.test.java.inheritance;

import java.util.Random;

public class Ex45_Overriding {

	public static void main(String[] args) {
		
		// 메소드 오버라이드, Method Override
		// - 메소드 재정의(수정)
		// - 상속에서만 발생
		
		
		Phone p1 = new Phone();
		p1.dial();
		
		SmartPhone s1 = new SmartPhone();
		//s1.dial(); //물려받긴 했지만.. 사용하기엔.. 찜찜한.. 상황 > 상속을 거부할 수도 없음
		
		s1.dial(); //무조건 자식이 선언한 dial() 메소드가 호출된다. (100%)
		
		// 메소드가 하는일 바뀌었다. -> 메소드 재정의
		
		
		MyRandom3 rnd = new MyRandom3();
		System.out.println(rnd.nextColor());
		System.out.println(rnd.nextBoolean());
		System.out.println(rnd.nextDouble());
		System.out.println(rnd.nextInt());
		
		
		//멤버 6개
		CCC c = new CCC();
		System.out.println(c.a);
		System.out.println(c.b);
		System.out.println(c.c);
		
		c.aaa();
		c.bbb();
		c.ccc();
		
		
		
	}//main
	
}//Ex45_Overriding

// 폴더폰
class Phone{ 
	
	public String model;
	
	public void dial() {
		System.out.println("버튼을 눌러 전화를 겁니다.");
	}
	
}

//스마트폰
class SmartPhone extends Phone{
	
	// 전화기
	// - model
	// - dial()
	
	//자신의 멤버
	public void game() {
		System.out.println("게임을 합니다.");
	}
	
	// **** 상속관계에서 부모가 물려준 메소드와 동일한 시그너처로 메소드를 선언하게 되면
	// 		자식의 메소드가 부모의 메소드보다 우선해서 노출된다. (호출당하게 된다.)
	
	//메소드 오버라이드
	public void dial() {
		System.out.println("화면을 터치해서 전화를 겁니다.");
	}
	
}

// Random이 가지는 기능이 모두 필요 + 추가 기능 필요 -> 확장
// - Random의 모든 기능을 필요 !!
// - nextInt() 사용을 안함
// - nextInt() 사용을 안함 or nextInt()의 범위 부담
class MyRandom3 extends Random{
	
	//nextTinyInt() -> nextInt()
//	public int nextTinyInt() {
//		return 1;
//	}
	
	//부모의 nextInt()를 자식이 재정의 -> 오버라이드
	public int nextInt() {
		
		Random rnd = new Random();
		return rnd.nextInt(10);
	
	}
	
	public String nextColor() {
		Random rnd = new Random();
		String[] color = {"red", "yellow", "blue"};
		
		return color[rnd.nextInt(color.length)];
	}
	
}//MyRandom2


class AAA{
	public int a;
	public void aaa() {
		System.out.println("부모 행동");
	}
}

class BBB extends AAA{
	public int b;
	public void bbb() {
		
	}
	
	public int a; // 변수 오버라이드 -> 사용안함(100%) -> 의미 전혀 없음;;
	
	@Override //어노테이션
	public void aaa() {
		System.out.println("자식 행동");		
	}
}

class CCC extends BBB{
	public int c;
	public void ccc() {
		
	}
	//부모클래스인 BBB클래스에서 AAA에서로부터 물려받은 aaa()를 재정의하면 
	// CCC에서도 오버라이드된 aaa() 물려받음.
}
