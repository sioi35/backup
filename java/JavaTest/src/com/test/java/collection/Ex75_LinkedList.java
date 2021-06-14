package com.test.java.collection;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex75_LinkedList {

	public static void main(String[] args) {
		
		/*
		비슷한 우리의 클래스.. > 인터페이스 관심!! > 컬렉션
		
		1. Collection 인터페이스
		2. List 인터페이스
			- Collection > List
		3. Set 인터페이스
			- Collection > Set
		4. Map 인터페이스
		
		
		List
		- ArrayList, Stack, Queue, LinkedList, (Properties)
		
		Set
		- HashSet, TreeSet
		
		Map
		- HashMap, TreeMap, (HashTable)
		
		
		LinkedList
		- List 계열
		- ArrayList와 사용법 유사(같은 추상 메소드를 구현 > 사용법 동일)
		- 내부 구조는 다르다. -> 데이터 저장소의 사용 목적이 다르다, 용도 다름
		
		ArrayList vs LinkedList
		- 공통점: 순서를 가지는 배열 > 방번호를 사용한다. > index
		- ArrayList
			- 장점: 모든 컬렉션을 통틀어 특정 요소에 접근 속도가 가장 빠르다.(순수배열과 동일)
			- 단점: 요소의 추가(insert), 삭제 작업 비용이 많이 든다.
			
		- LinkedList
			- 장점: 요소의 추가(insert), 삭제 작업 비용이 저렴하다.
			- 단점: 특정 요소에 접근 속도가 느리다.
			
		순차적으로 추가/삭제 작업
		- ArrayList > LinkedList
		
		중간 추가/삭제 작업
		- LinkedList >>> ArrayList
		
		
				 
		*/
		
		m1();
		
	}//main

	private static void m1() {

		//ArrayList vs LinkedList
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		
		// 요소 추가(Append)
		list1.add(100);
		list1.add(200);
		list1.add(300);
		
		list2.add(100);
		list2.add(200);
		list2.add(300);
		
		//요소 접근
		for(int i=0; i<list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		
 		for(int i=0; i<list2.size(); i++) {
			System.out.println(list2.get(i));
		}
		

 		//장단점 테스트
 		long begin = 0, end = 0;
 		
 		// 1. 순차적으로 데이터를 추가하기, Append
 		System.out.println("1. 순차적으로 데이터를 추가하기, Append");
 		
		begin = System.currentTimeMillis(); //tick
		
		//작업
		for(int i=0; i<1000000; i++) {
			list1.add(i);
		}
		
		end = System.currentTimeMillis(); //tick
		System.out.printf("ArrayList 작업시간: %,dms\n", end-begin);
		
		
		begin = System.currentTimeMillis(); //tick
		
		//작업
		for(int i=0; i<1000000; i++) {
			list2.add(i);
		}
		
		end = System.currentTimeMillis(); //tick
		System.out.printf("LinkedList 작업시간: %,dms\n", end-begin);
		
		
		
		
		//2. 배열 중간에 데이터 추가하기, Insert(Right Shift 발생)
		System.out.println("배열 중간에 데이터 추가하기, Insert(Right Shift 발생)");
		begin = System.currentTimeMillis(); //tick
		
		//작업
		for(int i=0; i<1000; i++) {
			list1.add(0,i);
		}
		
		end = System.currentTimeMillis(); //tick
		System.out.printf("ArrayList 작업시간: %,dms\n", end-begin);
		
		
		
		begin = System.currentTimeMillis(); //tick
		
		//작업
		for(int i=0; i<1000000; i++) {
			list2.add(0,i);
		}
		
		end = System.currentTimeMillis(); //tick
		System.out.printf("LinkedList 작업시간: %,dms\n", end-begin);
		
		
		//3. 배열 중간에 있는 데이터 삭제하기, Delete(Left Shitf 발생)
		System.out.println("3. 배열 중간에 있는 데이터 삭제하기, Delete(Left Shitf 발생)");
		
		begin = System.currentTimeMillis(); //tick
		
		//작업
		for(int i=0; i<1000; i++) {
			list1.remove(0);
		}
		
		end = System.currentTimeMillis(); //tick
		System.out.printf("ArrayList 작업시간: %,dms\n", end-begin);
		
		
		begin = System.currentTimeMillis(); //tick
		
		//작업
		for(int i=0; i<10000; i++) {
			list2.remove(0);
		}
		
		end = System.currentTimeMillis(); //tick
		System.out.printf("LinkedList 작업시간: %,dms\n", end-begin);	
		
		
		//4. 순차적으로 데이터 삭제학. 끝 -> 처음(Shift 발생 안함)
		System.out.println("4. 순차적으로 데이터 삭제학. 끝 -> 처음(Shift 발생 안함)");
		
		begin = System.currentTimeMillis(); //tick
		
		//작업
		for(int i=0; i<1000; i++) {
			list1.remove(0);
		}
		
		end = System.currentTimeMillis(); //tick
		System.out.printf("ArrayList 작업시간: %,dms\n", end-begin);
		
		
		begin = System.currentTimeMillis(); //tick
		
		//작업
		for(int i=list1.size()-1; i>=0; i--) {
			list1.remove(i);
		}
		
		end = System.currentTimeMillis(); //tick
		System.out.printf("LinkedList 작업시간: %,dms\n", end-begin);	
		
		
		begin = System.currentTimeMillis(); //tick
		
		//작업
		for(int i=list2.size()-1; i>=0; i--) {
			list2.remove(i);
		}
		
		end = System.currentTimeMillis(); //tick
		System.out.printf("LinkedList 작업시간: %,dms\n", end-begin);	
		
	}
	
}//Ex75_LinkedList
