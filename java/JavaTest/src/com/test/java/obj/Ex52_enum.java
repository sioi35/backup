package com.test.java.obj;

public class Ex52_enum {

	public static void main(String[] args) {
		
		//열거형, Enumeration
		// - 클래스의 일종(자료형)
		// - 열거값을 가지는 자료형 > 사용자가 임의의 값을 생성할 수 없고 주어진 값들 중 1개를 선택해서 사용 가능한 자료형
		
		
		// 쇼핑몰] 의류 > 티셔츠 > 선택 > 색상 선택 > 빨강, 노랑 , 파랑
		
		// 색상을 선택하세요.
		//String color = "노랑"; // 주관식
		
		//Color c -> enum 변수
		//Color.빨강 -> enum 리터럴
		Color c = Color.빨강;  
		
		//Color sel = Color.검정;
		//Color sel = Color.느랑;
		Color sel = Color.파랑;
		
		// 회사 업무
		//String 직급 = "";
		
		직급 s = 직급.사원;
		
		
		//녹색점 : 멤버 변수
		// S: static
		// F: final
		System.out.println(Color.노랑); // static final 상수 
		
		System.out.println(MyColor.BLUE); 
		
		Color input = Color.빨강;
		
		if(input == Color.노랑) {
			
		}else if(input == Color.빨강) {
			
		}
		
		
		
	}//main
	
}//Ex52_enum

/*
class Color{
	//멤버
	public int a;
	public void test(){
	}

}
*/

enum Color{
	//멤버
	// - 변수만 (자료형X, 값 X, 이름 O)
	빨강,
	노랑,
	파랑
}

enum 직급{
	회장, 
	사장,
	이사,
	전무,
	부장,
	과장,
	대리,
	주임,
	사원
}


class MyColor{
	// 일종의 열거형 -> 좀더 편하게(?) 하기위해 ->  enum
	public final static int RED = 0;
	public final static int BLUE = 1;
	public final static int YELLOW = 2;
}














