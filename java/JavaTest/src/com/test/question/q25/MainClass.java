package com.test.question.q25;

public class MainClass {

	public static void main(String[] args) {
		
		// 배열 생성
		MyHashMap map = new MyHashMap();
		
		//추가
		map.put("국어", "합격");
		map.put("영어", "불합격");
		map.put("수학", "보류");
		
		//읽기
		System.out.println("<읽기>");
		System.out.println("국어: " + map.get("국어"));
		System.out.println("영어: " + map.get("영어"));
		System.out.println("수학: " + map.get("수학"));

		
		//개수
		System.out.println("개수: " + map.size());
		System.out.println();
		
		//수정
		map.put("영어", "합격");
		System.out.println("영어: " + map.get("영어"));
		System.out.println(map.toString());

				
		//삭제
		System.out.println("\n<삭제>");
		map.remove("영어");
		System.out.println("영어: " + map.get("영어"));
		System.out.println("개수: " + map.size());
		System.out.println(map.toString());
		
		//검색(key)
		System.out.println("\n<검색(key)>");
		if(map.containKey("국어")) {
			System.out.println("국어 점수 있음");
		}else {
			System.out.println("국어 점수 없음");
		}
		
		//검색(value)
		System.out.println("\n<검색(value)>");
		if(map.containValue("합격")) {
			System.out.println("합격 과목 있음");
		}else {
			System.out.println("합격 과목 없음");
		}
		
		
		System.out.println("\n<초기화>");
		map.clear();
		System.out.println(map.size());
		
		
	}//main
	
}//MainClass
