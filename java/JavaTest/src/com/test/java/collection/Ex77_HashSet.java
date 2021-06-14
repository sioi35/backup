package com.test.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Ex77_HashSet {

	public static void main(String[] args) {

		/*
		 * 
		 * List 인터페이스 - Collection 인터페이스의 자식 - 순서가 있는 배열(***) - 순수배열, ArrayList,
		 * LinkedList -> 방번호 존재 -> 첨자(idnex)를 사용해서 요소를 관리한다. - 요소가 중복값을 가질 수 있다.
		 * 
		 * 
		 * Set 인터페이스 - Collection 인터페이스의 자식 - 순서가 없는 배열(***) - 방번호 존재X -> 첨자(index)를
		 * 사용하지 않음 -> 순서가 없다. - 요소가 중복값을 가질 수 없다.
		 * 
		 * 
		 */

		// m1();
		//m2();
		m3();
		//m4();
		
		
	}// main

	private static void m4() {

		int a = 10;
		int b = 10;
		
		//값형
		System.out.println(a==b);
		
		boolean f1 = true;
		boolean f2 = true;
		System.out.println(f1 == f2);
		
		//참조형
		
		//1. 문자형은 불변이다.(Immutable) -> 메모리 성질, 문자열 재사용
		//2. 모든 참조형 변수의 비교는 주소값을 비교한다.
		String s1 = "홍길동";
		String s2 = "홍길동";
		s1 = "홍길동님";
		
		String s3 = "홍";
		s3 = s3 + "길동";
		
		//절대로 하지 말것(==) 문자열 비교는 반드시 equals로 할 것
		System.out.println(s1 == s2);//true
		System.out.println(s1.equals(s2));//String.equals(Object anObject)
		
		System.out.println(s1 == s3);
		System.out.println(s1.equals(s3));
		
		
		//참조형 객체의 비교
		Keyboard k1 = new Keyboard("K810",200000);
		Keyboard k2 = new Keyboard("K810",200000);
		Keyboard k3 = k1;
		Keyboard k4 = new Keyboard("k990", 350000);
		
		
		System.out.println(k1 == k2); //false
		System.out.println(k1.equals(k2)); //주소값 비교(Object.equals)
		System.out.println();
		
		System.out.println(k1 == k3); //true
		System.out.println(k1.toString());
		System.out.println(k2.toString());
		
		System.out.println(k1.hashCode()); // 객체의 위치(메모리 주소값)
		System.out.println(k2.hashCode()); 
		System.out.println(k4.hashCode());
		
		System.out.println(k1==k2);
		System.out.println(k1.equals(k2));//true
		
		System.out.println(k1.equals(k2));//true -> false
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println(k1.hashCode());
		System.out.println(k2.hashCode());
		System.out.println(k4.hashCode());
		System.out.println();
		System.out.println();
		
		System.out.println(k1.equals(k2));  //같은 키보드
		System.out.println(k1.equals(k4));  //다른 키보드
		
	}//m4

	private static void m3() {

		//단일값(원자값) 집합
		// - String[]
		// - int[]
		//HashSet<String>
		//HashSet<Integer>
		
		
		//복합값 집합 -> 객체 배열
		// - Student[]
		// - HashSet<Student>
		
		
		HashSet<Integer> lotto = new HashSet<Integer>();
		lotto.add(10);
		lotto.add(5);
		lotto.add(10);  //허용 X
		
		
		//Set -> 중복값 허용 안함
		HashSet<Keyboard> set = new HashSet<Keyboard>();
		
		set.add(new Keyboard("K810",200000));  //A
		set.add(new Keyboard("K310",50000));   //B
		set.add(new Keyboard("K810",200000));  //C
		
		//A와 C는 같은 키보드?
		// - 모든 참조형(객체)는 아무리 상태(멤버 변수의 값)가 동일해도.. 다른 객체로 취급한다.
		// - 쌍둥이 개념
		
		System.out.println(set);
		
		
	}//m3

	
	private static void m2() {

		// 로또 번호 만들기 -> 중복값 허용X

		Random rnd = new Random();

		// List
		ArrayList<Integer> lotto = new ArrayList<Integer>();

		for (int i = 0; i < 6; i++) {
			
			boolean flag = false;
			
			//1~45
			int n = rnd.nextInt(45) + 1;
			
			//같은 숫자 검사
			for(int j=0; j<i; j++) {
				if(n==lotto.get(j)) {
					flag = true;
					break;
				}
			}
			if(flag) {
				i--;
			}else {
				lotto.add(n);
			}
			
		}
		Collections.sort(lotto);
		System.out.println(lotto);
		
		//Set
		HashSet<Integer> lotto2 = new HashSet<Integer>();
		
		while(lotto2.size()<6) {
			int n = rnd.nextInt(45)+1;
			System.out.println(lotto2.add(n));
		}
		System.out.println(lotto2);
		
	}

	private static void m1() {

		ArrayList<String> list = new ArrayList<String>();
		HashSet<String> set = new HashSet<String>();

		// 요소추가
		list.add("사과");
		list.add("딸기");
		list.add("바나나");
		list.add("딸기"); // 중복값 허용, 방번호가 달라서 구분 가능하기 때문에

		set.add("사과");
		set.add("딸기");
		set.add("바나나");
		set.add("딸기");// 중복값 허용 안함. 방번호가 없어서 데이터로 구분이 안되면 아예 구분 불가능하기 떄문에..

		// 갯수
		System.out.println(list.size());
		System.out.println(set.size());

		// 덤프(출력용으로 사용 금지 -> 개발자만 보는 용도)
		System.out.println(list);
		System.out.println(set);

		// 요소 접근/ 탐색
		System.out.println(list.get(0));

		// get(), indexOf(), lastIndexOf(), remove().. X
		// System.out.println(set);
		System.out.println();

		for (String item : list) {
			System.out.println(item);
		}
		System.out.println();

		// Set -> Iterator 지원
		Iterator<String> iter = set.iterator();

		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

	}// m1

}// Ex77_HashSet


class Keyboard{
	
	private String model;
	private int price;
	
	
	public String getModel() {
		return model;
	}
	public Keyboard(String model, int price) {
		this.model = model;
		this.price = price;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "[model=" + this.model + ", price=" + this.price + "]";
	}
	
	
	
	//hasgCode 오버라이딩 + equals 오버라이딩
	@Override
	public int hashCode() {
		
		//return 100;//고정 상수 반환 금지
		
		//본인의 상태에 따라 달라지는 값을 반환하도록 재정의
		//k1: "K810", 200000 -> "K810200000" -> 100번지
		//k2: "K810", 200000 -> "K810200000" -> 100
		//k4: "K990", 350000 -> "k990350000" -> 200
		
		return (this.model + this.price).hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {

		return this.hashCode() == obj.hashCode();
	}
	
	
}






