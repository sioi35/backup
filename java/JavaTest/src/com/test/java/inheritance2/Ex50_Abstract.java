package com.test.java.inheritance2;

public class Ex50_Abstract {

	public static void main(String[] args) {
		
		//abstract 키워드
		// 1. 메소드 -> 추상 메소드
		// 2. 클래스 -> 추상 클래스
		
		//추상 클래스
		// - 추상 메소드를 소유하기 때문에 객체를 생성할 수 없다.
		
		//추상 클래스 vs 인터페이스
		// - 둘 다 추상 멤버를 가질 수 있다.(추상 메소드)
		// - 인터페이스는 구현 멤버를 가질 수 없다.
		// - 추상 클래스는 구현 멤버를 가질 수 있다.
		// - 인터페이스는 규칙만 강조하고 싶을 때 사용한다. 
		// - 추상 클래스는 규칙도 강조하면서, 구현 멤버를 물려주고 싶을 때 사용한다.
		
		//일반 클래스 - 추상 클래스 - 인터페이스
		//(구현) 	(구현 + 추상)  (추상)
		
		//User u1 = new User();
		
		
	}//main
	
}//Ex50_Abstract


//추상 클래스
abstract class User{
	
	// 멤버
	// - 추상 메소드
	public abstract void login();
	public abstract void logout();
	
	// 일반 멤버
	
	public int a; 
	public void test() {
		
	}
	
}

class Hong extends User{  // 클래스-클래스 extends , //인터페이스- 클래스 implements

	@Override
	public void login() {
		
	}

	@Override
	public void logout() {
		
	}
	
}
