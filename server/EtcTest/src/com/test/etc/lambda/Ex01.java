package com.test.etc.lambda;

import java.util.ArrayList;
import java.util.Comparator;

public class Ex01 {

	public static void main(String[] args) {
		
		//홍길동
		//전화기 인터페이스를 구현한 클래스 객체들
		MyClass a1 = new MyClass();
		OtherClass a2 = new OtherClass();
		
		//인터페이스 사용의 목적
		// -> 객체가 바뀌더라도 사용자 경험을 그대로 유지하는 것!!
		
		a1.test();
		a2.test();
		
		a1.test();
		a1.other();
		
		a2.test();
		//a2.other(); //부재 - 문제점
		a2.print(); //신규 - 문제점
		
		//해결책 > 인터페이스 변수를 사용하기!!
		MyInterface a3 = new MyClass();
		
		a3.test();
		//a3.other();//X
		
		MyInterface a4 = new OtherClass();
		
		a4.test();
		//a4.print();//X
		
		//AA -> 인터페이스
		// 건전지(로켓트건전지) AA > 편의점 > 건전지(로켓트건전지) AA
		//								  > 건전지(듀라셀) AA
		
		
		
		//클래스 객체를 클래스 변수에 담아서 사용하기
		MyClass m1 = new MyClass();
		m1.test();
		
		//업캐스팅
		//인터페이스를 구현한 객체를 인터페이스 변수에 담아서 사용하기
		MyInterface m2 = new MyClass();
		m2.test();
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(5);
		list.add(2);
		list.add(4);
		list.add(3);
		
		
		list.sort(new MyComparator());
		
		list.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
			
		});
		
		list.sort((Integer o1, Integer o2) -> { return o1 - o2; });
		
		list.sort((o1, o2) -> o2 -o1);
		
		System.out.println(list);
		
	}//main
	
}//Ex01

class MyComparator implements Comparator<Integer>{
	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 - o2;
	}
}

interface MyInterface{
	void test();
}

class MyClass implements MyInterface{
	@Override
	public void test() {
		System.out.println("실명 클래스의 객체가 구현한 메소드");
	}
	
	public void other() {
		System.out.println("자체 구현한 메소드");
	}
}

class OtherClass implements MyInterface {
	@Override
	public void test() {
		System.out.println("구현");
	}
	
	public void print() {
		System.out.println("자체 구현한 메소드");
	}
}
















