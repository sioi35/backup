package com.test.java.inheritance3;

public class Ex58_Generic {

	public static void main(String[] args) {
		
		Item<String> item1 = new Item<String>();
		item1.c = "홍길동";
		System.out.println(item1.c.length()); //형변환 불필요
		
		//Item<int> item4; --> int(값형)X , Integer(참조형)O만 지원
		Item<Integer> item2 = new Item<Integer>();
		item2.c = 10;
		System.out.println(item2.c * 2);
		
		Item<Boolean> item3 = new Item<Boolean>();
		item3.c = true;
		System.out.println(item3.c ? "참" : "거짓");
		
		
		Mouse<String> m1 = new Mouse<String>();
		m1.a = "문자열";
		m1.b = "홍길동";
		m1.c = "String";
		
		Keyboard<Boolean> k1 = new Keyboard<Boolean>();
		 k1.a = true;
		 k1.test(true);
		System.out.println(k1.get());
		
		//Keyboard is a raw type. References to generic type Keyboard<T> should be parameterized
		Keyboard<Boolean> k2 = new Keyboard(); //<>안붙여도 동작은 하지만 웬만하면 제네릭<> 붙여주세요. -> 사용하지 말것
		k2.a = false;
		
		Computer<String, Integer> c = new Computer<String, Integer>();
		c.set("홍길동", 20);
		System.out.println(c.getA());
		System.out.println(c.getB());
		
	}//main
	
}//Ex58_Generic

// 제네릭 클래스 선언하기
// - T : 타입 변수 -> 데이터를 저장하는 용도가 아니라, 자료형 자체를 저장하는 용도
// 		ex) T = int
//		ex) T = String
//		ex) T = Random
class Item<T> { 
	
	// 멤버
	public int a;
	public String b;
	public T c; //Object 느낌 -> 뭐든지 담을 수 있는 자료형
	
}

class Mouse<T>{ // T:type
	
	public T a;
	public T b;
	public T c;

}

class Keyboard<T>{
	
	public T a;
	
	public void test(T n) {
		//The value of the local variable m is not used
		//T m; //지역 변수를 사용할 수 없다. -> 겉으로 드러난 부분에만 사용을 권장 -> 통제가 불가능해짐. 
	}
	
	public T get() {
		return a;
	}
	
}

class Computer<T, U>{
	
	public T a;
	public U b;
	
	public void set(T a, U b) {
		this.a = a;
		this.b = b;
	}
	
	public T getA() {
		return this.a;
	}
	
	public U getB() {
		return this.b;
	}
	
}










