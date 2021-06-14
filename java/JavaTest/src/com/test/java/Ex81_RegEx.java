package com.test.java;

public class Ex81_RegEx {

	public static void main(String[] args) {
		
		
		
		String name = "홍길동, 아무개, 하하하, 호호호, 후후후";
		
		//분할 메소드 -> 구분자를 기준으로 문자를 자르는 기능
		String[] result = name.split(",");		
		
		
//		for(String n : result) {
//			System.out.println(n);
//		}
		
		for(int i=0; i<result.length; i++) {
			System.out.printf("result[%d] = %s\n", i, result[i]);
		}
		
		
		
	}//main
	
}
