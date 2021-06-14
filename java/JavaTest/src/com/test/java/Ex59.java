package com.test.java;

public class Ex59 {

	public static void main(String[] args) {
		
		//Wrapper Class, Util Class 등..
		// - int -> Integer
		// - double -> Double
		// - boolean -> Boolean
		
		//1. 
		System.out.println(Integer.parseInt("100") + 100);
		
		//2. 
		System.out.println(Integer.MAX_VALUE); //final static 상수 : 변하지 않는 , 공용 정보
		System.out.println(Integer.MIN_VALUE);
		
		//3.
		System.out.println(Integer.compare(10, 5));  //1  -> 앞의 값이 크다
		System.out.println(Integer.compare(5, 10));  //-1 -> 뒤의 값이 크다
		System.out.println(Integer.compare(10, 10)); //0  -> 같다
		
		//4. 
		System.out.println(Integer.max(10, 5));
		System.out.println(Integer.min(10, 5));
		System.out.println(Integer.max(5, 10));
		System.out.println(Integer.min(5, 10));
		
		//5
		System.out.println(10 + "");
		System.out.println(String.valueOf(10));
		System.out.println(Integer.toString(10));
		
		//6. 
		System.out.println(Integer.toBinaryString(10));  //1010 -> 2진수
		System.out.println(Integer.toHexString(255));    //ff -> 16진수
		System.out.println(Integer.toOctalString(10));   //12 -> 8진수
		
		String s1 = "A";
		String s2 = "B";
		
		//System.out.println(s1 > s2); //주소값 비교.
		System.out.println(s1.charAt(0) > s2.charAt(0)); //값 비교 -> 문자코드값 비교
		
		s1 = "ABC";
		s2 = "abc";
		
		// 정렬(Sort)
		// - 숫자 : 크기 정렬
		// - 문자 : 문자코드 정렬(숫자 정렬)
		//System.out.println(s1 > s2);
		
		System.out.println(compareString(s1,s2)); //앞이 크다(1), 뒤가 크다(-1), 같다(0)
		
		System.out.println(s1.compareTo(s2)); //앞이 크다(양수), 뒤가 크다(음수), 같다(0)
		
		System.out.println(s1.compareToIgnoreCase(s2)); //0 //대소문자 구분없이 비교 
		
	}//main
	
	private static int compareString(String s1, String s2) {
		
//		s1 = s1.toUpperCase();
//		s2 = s2.toUpperCase();
		
//		s1 = "홍길동";
//		s2 = "남궁성진";
		int min = 0;
		
//		if(s1.length() < s2.length()) {
//			min = s1.length();
//		}else {
//			min = s2.length();
//		}
		
		min = Integer.min(s1.length(), s2.length());
		
		for(int i=0; i<min ; i++) {
			if(s1.charAt(i)>s2.charAt(i)) {
				return 1;
			}else if(s1.charAt(i)<s2.charAt(i)){
				return -1;
			}
		}
		if(s1.length() > s2.length()) {
			return 1;
		}else if(s1.length() < s2.length()) {
			return -1;
		}
		
		return 0;
	}//compareString
	
}//Ex59
