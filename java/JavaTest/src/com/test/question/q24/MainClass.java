package com.test.question.q24;

public class MainClass {

	public static void main(String[] args) {
		
		
		//배열 생성
		MyArrayList list = new MyArrayList();

		//추가
		list.add("홍길동");
		list.add("아무개");
		list.add("하하하");
		list.add("가가가");
		list.add("나나나");
		list.add("다다다");
		
		//읽기
		System.out.println("<읽기>");
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println();
		
		//개수
		System.out.println("<개수>");
		System.out.println("요소의 갯수: " + list.size());
		System.out.println();
		
		//탐색 + 읽기
		System.out.println("<탐색 + 읽기>");
		for (int i=0; i<list.size(); i++) {
		    System.out.println(list.get(i));
		}
		System.out.println();
		
		//수정
		System.out.println("<수정>");
		list.set(0, "우하하");
		System.out.println(list.get(0));
		System.out.println();
		
		System.out.println("<탐색 + 읽기>");
		for (int i=0; i<list.size(); i++) {
		    System.out.println(list.get(i));
		}
		System.out.println();
		
		//삭제
		System.out.println("<삭제>");
		list.remove(0);
		for (int i=0; i<list.size(); i++) {
		    System.out.println(list.get(i));
		}
		System.out.println();
		
		//삽입
		System.out.println("<삽입>");
		list.add(1, "호호호");
		for (int i=0; i<list.size(); i++) {
		    System.out.println(list.get(i));
		}
		System.out.println();
		
		System.out.println("<삽입>");
		list.add(1, "홍길동");
		for (int i=0; i<list.size(); i++) {
		    System.out.println(list.get(i));
		}
	
		System.out.println("요소의 갯수: " + list.size());		
		System.out.println();
		
		//검색
		System.out.println("<검색>");
		if (list.indexOf("홍길동") > -1) {
		    System.out.println("홍길동 있음");
		} else {
		    System.out.println("홍길동 없음");
		}
		System.out.println();
		
		
		//검색
		System.out.println("<뒤에부터 검색>");
		if (list.lastIndexOf("홍길동") > -1) {
		    System.out.println("홍길동 있음");
		} else {
		    System.out.println("홍길동 없음");
		}
		System.out.println();
		
		
		//초기화
//		System.out.println("<초기화>");
//		list.clear();
//		System.out.println("요소의 갯수: " + list.size());		
		
		System.out.println("<탐색 + 읽기>");
		for (int i=0; i<list.size(); i++) {
		    System.out.println(list.get(i));
		}
		System.out.println();
		
		//문자열 포함하고 있는지.
		System.out.print("문자열 포함하고 있나(contains): ");
		System.out.println(list.contains("호호호"));
		
		list.trimToSize();

		System.out.print("빈방 있나: ");
		System.out.println(list.isEmpty());
		
	}//main
	
}//MainClass
