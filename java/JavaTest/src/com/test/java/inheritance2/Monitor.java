package com.test.java.inheritance2;

//실제 제품(X) -> 규격 역할(O) -> 모니터의 자격을 가지려면, 최소한 이런 규칙은 지키세요!! -> 규칙의 집합 역할
public interface Monitor {

	// 인터페이스 멤버
	// - 추상 메소드
	// a. abstract 키워드
	// b. 구현부를 가지지 않는다. ({})
	
	public abstract void powerOn();
	
	public abstract void powerOff();
	
	//** 인터페이스는 구현된(실체화) 멤버를 가질 수 없다.
	//public int a;
	//public void test() {};
	
}//Monitor
