package com.test.java.obj;

public class Ex33_Access {

	public static void main(String[] args) throws Exception {
		
		//접근 지정자(제어자), Access Modifier
		// - public, private / protected, default(friendly)
		
		//1. public
		// - 클래스(객체)의 울타리를 기준으로 외부에 100% 공개한다.
		
		//2. private
		// - 클래스(객체)의 울타리를 기준으로 외부에 100% 비공개한다.
		
		// 가이드 라인
		// 1. 멤버 변수의 접근 지정자는 무조건 private 한다.
		// - 잘못된 값을 제어할 방법이 없다; 
		// 2. private 멤버 변수 제어를 위한 Setter, Getter를 구현한다.
		// - 제어가 가능하기 때문에 안전하다.
		
		Circle c1 = new Circle();
		c1.a = 10;
		//c1.b = 20;  //The field Circle.b is not visible, 접근 불가능 or사용 불가능
		
//		Keyboard k1 = new Keyboard();
//		
//		k1.model = "k810";
//		k1.weight = 500;
//		k1.color = "Black";
//		k1.price = 140000;
//		
//		System.out.println("model : " + k1.model);
//		System.out.println("weight : " + k1.weight);
//		System.out.println("color : " + k1.color);
//		System.out.println("price : " + k1.price);
//		System.out.println();
//
//		Keyboard k2 = new Keyboard();
//		k2.model = "G3000";
//		k2.weight = 3000000;
//		k2.color = "홍길동";
//		k2.price = -21000;
//		
//		System.out.println("model : " + k2.model);
//		System.out.println("weight : " + k2.weight);
//		System.out.println("color : " + k2.color);
//		System.out.println("price : " + k2.price);
		
		Keyboard k3 = new Keyboard();
		//k3.aaa();
		//k3.bbb();
		//k3.ccc("");
		
		// k3.weight (not visible)
		k3.setWeight(300); // 쓰기 작업
		
		//출력?? 
		//System.out.println(k3.weight);  //not visible
		System.out.println(k3.getWeight());  //읽기 작업
	   
	    
	}//main
	
}//Ex33_Access

class Keyboard {
	
//	public String model;
//	public int weight;
//	public String color;
//	public int price;
	
	private String model;
	private int weight;
	private String color;
	private int price;
	
	//클래스 내부에서는 서로 접근 지정자가 동작하지 않는다. 
	
	//Setter, Getter
	// - 본질은 일반 멤버 메소드
	// - 역할이 있다.
	// - 주로 private 변수를 입출력하기 위한 역할을 한다.
	// - public 변수를 사용하는것과 다른 점은 내부에서 통제를 할 수 있다는 것이다.(************)
	
	
	// 쓰기 작업 메소드
	// -> Setter
	// -> setXXX-> set멤버변수명 -> "set" + "weight" -> setweight -> 캐멀 표기법 -> setWeight
	
	public void setWeight(int weight) throws Exception {  //int weight -> 지역변수
		
		//지역변수와 멤버변수의 충돌
		// -> 무조건 지역변수가 이긴다.
		
		// 절대 규칙!!
		// 큰 지역과 작은 지역이 충돌나면 작은 지역이 이긴다.
		// 두리몽실한 것과 자세한 것이 충돌나면 자세한 것이 이긴다.
		// 부모와 자식이 충돌하면 자식이 이긴다.
		
		//this -> 객체 접근 연산자(객체 지정 연산자) -> 객체 자신을 참조한다.
		//this.weight = weight; 
		
		if(weight > 0 && weight <10000) {
			this.weight = weight;
		}else {
			//무게로써 올바르지 않은 수치입니다. -> 잘못됨 -> 복사 X
			throw new Exception("잘못된 무게입니다.");
		}
		
	}
	
	//읽기 작업 메소드
	// -> Getter
	// -> "get" + 멤버변수명
	public int getWeight() {
		
		return weight;
	}
		
	
//	public void ccc(String txt) {
//		model = txt;
//	}
//	
//	
//	public void aaa() {
//		
//	}
//	
//	private void bbb() {
//		
//	}
	
}//Keyboard

class Circle{
	
	//멤버 변수, 필드(Field)
	public int a;
	private int b;
	
}//Circle

