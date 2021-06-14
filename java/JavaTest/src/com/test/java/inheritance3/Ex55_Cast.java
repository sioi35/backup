package com.test.java.inheritance3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Random;

public class Ex55_Cast {

	public static void main(String[] args) {
		
		
		AAA a = new AAA(); // 자기 타입
		AAA b = new BBB(); // 업 캐스팅. 부모 = 자식
		AAA c = new CCC(); // 업 캐스팅. 할아버지 = 손자
		AAA d = new DDD(); // 업 캐스팅. 증조할아버지 = 증손자
		
		Object o1 = new Object();
		
		Object o2 = new AAA(); //업캐스팅
		Object o3 = new BBB();
		Object o4 = new CCC();
		Object o5 = new DDD();
		
		Object o6 = new Random();
		Object o7 = Calendar.getInstance();
		Object o8 = new BufferedReader(new InputStreamReader(System.in));
		Object o9 = new int[5];
		Object o10 = "문자열";
		
		// Object -> 만능 주머니 (*********)
		
		//배열 특징 : 같은 자료형의 집합
		Object[] list = new Object[10];
		
		list[0] = new AAA();
		list[1] = new BBB();
		list[2]	= new Random();
		
		AAA[] list2 = new AAA[3];
		list2[0] = new AAA();
		list2[1] = new AAA();
		
		// 위의 내용 -> 참조형을 Object 변수에 넣었음.
		
		
		//??? -> 값형을 넣었음.
		int n = 123; // 값형 int
		
		Integer n11 = new Integer(100); // 참조형 int
		
		System.out.println(n + n11);
		
		//Boxing(박싱)
		// - 값형의 데이터를 Object 변수에 담을 때 발생하는 현상
		Object o11 = 100; // new Integer(100) 실행 -> 주소값 -> o11 저장
		Object o12 = true; // new Boolean(true) 실행 -> 주소값 -> o12 저장
		
		System.out.println(o11); //100
		System.out.println(o11.toString());
		System.out.println(o12);
		
		//The operator + is undefined for the argument type(s) Object, int
		// 모든 산술 연산자는 피연산자로 객체를 가질 수 없다. (왜?? - 객체는 데이터의 집합 -> 그 중 누구를 연산의 대상을 할지 알수가 없기 때문에.)
		//System.out.println(o11 + 100); // 200(?) X

		//값형과 참조형간에는 형변환이 발생할 수 없다 !!
		System.out.println((int)o11 + 100); //예외 케이스
		
		System.out.println((Integer)o11 + 100); // 다운 캐스팅 
		
		
//		Time t1 = new Time();
//		t1.hour = 1;
//		t1.min = 10;
//		
//		Time t2 = new Time();
//		t2.hour = 2;
//		t2.min = 5;
//		
//		System.out.println(t1 + t2);
		
		if((boolean)o12) {
			System.out.println("참");
		}else {
			System.out.println("거짓");
		}
		
		
		// *** 모든 값형의 데이터도 Object 변수에 넣을 수 있다.
		// -> Boxing 발생 // 비용 발생
		
		// *** Object 변수의 값형 데이터를 (올바르게) 사용하려면 원래 값형으로 형변환을 해야 한다. 
		// -> UnBoxing 발생 // 비용 발생
		
		int n1 = 10;
		Object n2 = 10; // 객체 1개 생성
		
		System.out.println(n1 + 10); 
		System.out.println((int)n2 + 10); // 객체 1개 소멸
		
		// Object 사용 중 단점
		// o5 -> 뭐가 들어있는지? 
		System.out.println(o5);
		
		// n1 -> 뭐가 들어있는지?
		System.out.println(n1);
	
	}//main
	
}//Ex55_Cast

class Time{
	public int hour;
	public int min;
}

class AAA{
	
}

class BBB extends AAA{
	
}

class CCC extends BBB{
	
}

class DDD extends CCC{
	
}