package com.test.java.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ex76_Collection {

	public static void main(String[] args) {
		
		//컬렉션 탐색 도구
		// - 집합의 요소를 접근하는 도구
		// 1. for문(***)
		// 2. 향상된 for문(***)
		// 3. Enumeration
		// 4. iterator(***)
		// 5. ListIterator
		
		//m1();
		m2();
		
	}//main

	private static void m2() {

		//HashMap -> 탐색
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("과장", "홍길동");
		map.put("사원", "아무개");
		map.put("대리", "하하하");
		map.put("부장", "호호호");
		
		Set<String> set = map.keySet();  // 키 집합 반환
		
		Iterator<String> iter = set.iterator();
		
		while(iter.hasNext()) {
			//키 출력 + 값 출력
//			System.out.println(iter.next()); // 키
//			System.out.println(map.get(iter.next()));  //값
			
			String key = iter.next();
			
			System.out.println(key);
			System.out.println(map.get(key));
		}
		
		
	}//m2

	private static void m1() {

		ArrayList<String> list = new ArrayList<String>();
		
		list.add("사과");
		list.add("바나나");
		list.add("포도");
		list.add("딸기");
		list.add("귤");
		list.add("복숭아");
		list.add("참외");

		
		//M1. 일반 for문 -> index 사용 O
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println();
		
		//M2. 향상된 for문 -> index 사용X
		for(String item : list) {
			System.out.println(item);
		}
		System.out.println();
		
		//M3. Iterator -> index 사용X
		// - ArrayList는 Iterator를 지원한다.
		// - iter: 탐색기(판독기)
		//		a. hasXXX()
		//		b. nextXXX()
		Iterator <String> iter = list.iterator();
		
//		System.out.println(iter.hasNext());  //true
//		System.out.println(iter.next());  
//		
//		System.out.println(iter.hasNext());
//		System.out.println(iter.next());
//		
//		System.out.println(iter.hasNext());
//		System.out.println(iter.next());
//
//		System.out.println(iter.hasNext());
//		System.out.println(iter.next());
//		
//		System.out.println(iter.hasNext());
//		System.out.println(iter.next());
//		
//		System.out.println(iter.hasNext());
//		System.out.println(iter.next());
//		
//		System.out.println(iter.hasNext());
//		System.out.println(iter.next());
//		
//		System.out.println(iter.hasNext()); //false
//		System.out.println(iter.next());
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
	}//m1
	
}//Ex76_Collection
