package com.test.java.inheritance2;

public class Ex51_Abstract {

	public static void main(String[] args) {
		
		// 인터페이스 vs 추상 클래스
		// - 둘 다 추상 메소드를 통해서 메소드를 강제 구현
		// - 구현 멤버도 물려주고 싶으면 추상클래스를 사용해야 한다. 인터페이스는 불가능(X)
		// - 용도가 다르다. 
		// - 인터페이스 > 추상클래스 : 인터페이스를 설계하는게 추상클래스 설계보다 생각해야할 경우의 수가 적다.
		
	}//main
	
}// Ex51_Abstract


//컴퓨터가 갖춰야할 사용법들의 집합
interface Computer{
	//인터페이스는 구현된 멤버를 가질 수 없다.
	public abstract void on();
	public abstract void off();
	
}

abstract class AComputer{
	// 추상 클래스는 구현멤버도 가질 수 있다.
	private String serialNumber;
	private int weight;
	private int price;
	
	public void check() {
		System.out.println("바이러스 검사");
	}
	
	public abstract void on();
	public abstract void off();
	
}


//class ASUS100 implements Computer{
class ASUS100 extends AComputer{
	
//	private String serialNumber;
//	private int weight;
//	private int price;
//	
//	public void check() {
//		System.out.println("바이러스 검사");
//	}
	
	@Override
	public void on() {
		// 추상 메소드의 의도? 
		// - 겉으로 보이는 사용법을 강제 (헤더)
		// - 구현부는 자유롭게 맘대로 ~ -> 되도록 on 이름에 걸맞는 행동을 구현하는 걸 권장
		System.out.println("ASUS100 전원 On");
	}

	@Override
	public void off() {
		System.out.println("ASUS100 전원 Off");
	}
	
	
}

//class Samsung200 implements Computer{
class Samsung200 extends AComputer{

//	private String serialNumber;
//	private int weight;
//	private int price;
//	
//	public void chick() {
//		System.out.println("바이러스 검사");
//	}
	
	@Override
	public void on() {
		System.out.println("Samsung200 Power On");
	}

	@Override
	public void off() {
		System.out.println("Samsung200 Power Off");
	}
	
}
