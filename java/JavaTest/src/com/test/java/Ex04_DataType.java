package com.test.java;

public class Ex04_DataType {
	
	//전제조건: 구문은 외우고.. 사용
	//1. 인텔리센스, 코드 어시스트 : Ctrl + Space  
	//2. 코드 조각(템플릿) : 키워드 작성 > [Ctrl + Space]

	public static void main(String[] args) { //main + Ctrl + Space
		
		//출력 명령어
		//System.out.println(); //syso + Ctrl + Space 
		
		//자료형 + 변수 + 리터럴(상수)
		// 1. 자료형을 사용해서
		// 2. 변수를 만든다.
		// 3. 변수에 리터럴을 사용해서 값을 넣는다. 
		// - 모든 자료형에 대해서 (8가지)
		
		//정수형 (byte, short, int, long)
		//byte
		
		byte b1;
		
		b1=100; //100 - 정수형 리터럴, 정수형 상수, 정수형 데이터
		System.out.println("byte: "+b1);
		
		
		b1 = -100;
		//Ctrl + Alt + 방향키(아래) : 라인 복사 (여러줄 가능)
		//Alt + 방향키(아래) : 라인 이동
		System.out.println("byte: "+b1);
		
		b1 = 127;
		System.out.println("byte: "+b1);
		
		
		//Type mismatch: cannot convert from int to byte
		//b1 = 128; 
		
		
		//short
		short s1;
		
		s1 = 100;
		System.out.println("short: " + s1);
		
		s1 = 128;
		System.out.println("short: " + s1);
		
		s1 = 32767;
		System.out.println("short: " + s1);
		
		//s1 = 32768;
		s1 = -32768;
		//s1 = -32769;
		
		//int(******) -> 가장 많이 사용 !!
		int n1;
		n1 = 100;
		
		n1 = 210000000;
		System.out.println("int: " + n1);
		
		n1 = -210000000;
		System.out.println("int: " + n1);
		
		
		//자료형 -> 클래스
		//byte -> Byte
		//short -> Short
		//int -> Integer
		//long -> Long
		//float -> Float
		//double -> Double
		
		System.out.println(Byte.SIZE);//8
		System.out.println(Byte.BYTES);//1
		System.out.println(Byte.MAX_VALUE);//127
		System.out.println(Byte.MIN_VALUE);//-128
		
		System.out.println(Integer.MAX_VALUE);//2147483647
		System.out.println(Integer.MIN_VALUE);//-214783648
		
		System.out.println(Long.MAX_VALUE);//9223372036854775807
		
		//long
		long l1;
		
		l1 = 100;
		System.out.println("long: " + l1);
		
		l1 = 100000000;
		System.out.println("long: " + l1);
		
		//9223372036854775807
		//The literal 10000000000000000 of type int is out of range 
		//l1 = 100000000000000;
		l1 = 100000000000000L;
		System.out.println("long: " + l1);
		
		
		//상수의 자료형??
		// - 자바의 모든 정수형 상수의 자료형은 int이다.(**********)
		// - 왜? CPU 관계 -> 오래전부터 어떤 언어의 int 자료형은 해당 CPU가 한번에 처리할 수 있는 데이터의 크기이다.
		
		//CPU -> 64bit, 32bit, 16bit, 8bit.. -> CPU가 한번에 처리하는 데이터의 크기 (더 크게도 ,더 작게도 처리 못함)
		
		byte b2 = 100; 
		short s2 = 100;
		int n2 = 100;
		long l2 = 100L;
		
		System.out.println(b2); //byte 값을 출력한다.
		System.out.println(l2); //long 값을 출력한다.
		System.out.println(100); //? 
		
		//정수형 상수는 int 범위를 벗어나서 사용할 수 없다. 
		System.out.println(2100000000);
		//System.out.println(2200000000);//The literal 2200000000 of type int is out of range 
		
		//정수형 상수를 int 범위 밖의 숫자를 표현하고 싶을 떄..
		// - 접미사(L, l)을 사용 -> Long
		System.out.println(2200000000L); //권장
		System.out.println(2200000000l); //비권장
		
		
		
		//실수형(float, double)
		
		//float
		float f1;
		
		//실수형 리터럴 표기법
		f1 = 3.14F;
		System.out.println("float: " +f1);
		
		
		//double
		double d1;
		d1 =3.14; //3.14D 붙여도 되고 안붙여도 됨
		System.out.println("double: " + d1);
		
		System.out.println(3.14); //실수형 상수 3.14의 자료형? > double
		
		//실수 사용시 주의점!! -> 정밀도
		float f2 = 1.2345678901234567890123456789F;
		double d2 = 1.2345678901234567890123456789D;
		
		System.out.println("f2: " + f2); //f2: 1.2345679
		System.out.println("d2: " + d2); //d2: 1.2345678901234567
		
		
		//문자형
		// - 한글자를 저장하는 자료형
		char c1;
		//A cannot be resolved to a variable
		//c1 = A;
		
		//문자형 리터럴 표기법
		c1 = 'A';
		System.out.println("char: " + c1);
		
		c1 = '가';
		System.out.println("char: " + c1);
		
		c1 = '5'; //아라비안 숫자 5하고 문자 5는 다른 값이다. (*****)
		System.out.println("char: " + c1);
		
		int num1 = 5;
		char num2 = '5'; //글자 -> 문자코드값 저장 53
		
		//c1 = 'AB';  //Invalid character constant
		
		//논리형
		boolean flag;
		
		//논리형 리터럴 표기법
		flag = true;
		System.out.println("boolean: " + flag);

		flag = false;
		System.out.println("boolean: " + flag);
		
		
		//---------------------------------------
		
		//자바 자료형
		// 1. 원시형, 값형
		// - 정수형(4개), 실수형(2개), 문자형(1개), 논리형(1개)
		
		// 2. 참조형
		// - 문자열(String) : 문자열들이 열을 지어 있는 형태의 자료형
		
		//이름 (홍길동) -> 변수 저장 -> 출력
		//char name = '홍길동';
		char name1 = '홍';
		char name2 = '길';
		char name3 = '동';
		
		System.out.println("이름: " + name1+ name2+ name3);
		
		//char의 집합 -> 새로운 자료형 -> String
		String name;
		
		//문자열 리터럴 표기법 " "
		name = "홍길동";
		System.out.println("이름: " + name);
		
		
		//char m1 = ''; //문자형은 ''안에 반드시 무언가가 표현이 되야된다. 
		char m1 = 'A';
		String m2 = ""; //빈문자열(Empty String) -> 주로 문자열 변수를 초기화할 때 사용 or 그 외 등등..
		
		System.out.println("m2: " + m2);
		
		
	}//main
	
}//Ex04_DataType
