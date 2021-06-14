package com.test.question.q5;

public class Q002 {
	
	public static void main(String[] args) {
		
		position("홍길동");
		System.out.println();
		
		position("홍길동", "유재석");
		System.out.println();
		
		position("홍길동", "유재석", "박명수");
		System.out.println();
		System.out.println();
	
		position("홍길동", "유재석", "박명수", "정형돈");
		System.out.println();

	}


	public static void position(String member1) {// 사원
		
		System.out.printf("사원: %s\n", member1);
		
	}
	
	public static void position(String member1, String member2) {
	
		System.out.printf("사원: %s\n대리: %s\n", member1, member2);
	}
	
	public static void position(String member1, String member2, String member3) {
		
		System.out.printf("사원: %s\n대리: %s\n과장: %s\n", member1, member2, member3);
	}
	
	public static void position(String member1, String member2, String member3, String member4) {
		
		System.out.printf("사원: %s\n대리: %s\n과장: %s\n부장: %s\n", member1, member2, member3, member4);
	}
	
	
}
