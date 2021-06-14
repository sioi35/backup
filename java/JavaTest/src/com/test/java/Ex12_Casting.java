package com.test.java;

public class Ex12_Casting {

	public static void main(String[] args) {
		
		/*
		
		(자료)형변환, (Data)Type Casting
		- 자료형을 변환시키는 기술
		- int -> float
		- double -> byte
		- 코드 유연
		
		암시적인 형변환, 자동 타입 변환
		- 큰형 = 작은형
		- 100% 안전
	
		- byte -> short
		- byte -> int
		- byte -> long
		
		- short -> int
		- short -> long
		
		- int -> long
		
		*/		

		byte b1 = 10;
		short s1;
		
		// = 연산자
		// - 변수 = 값;
		// - LValue(변수) = RValue(상수, 변수)
		// - ***** = 연산자는 반드시(100%) LValue와 RValue의 자료형이 동일해야 한다. > 동일하지 않으면 복사를 못한다. 에러 발생 !!
		
		// short = byte
		//  2byte = 1byte
		// 큰형 = 작은형
		// 개발자가 모르게 형변환이 발생한다. > 암시적인 형변환, 자동 형변환
		
		//s1 = b1;
		//s1 = (short)b1; //컴파일러가 컴파일을 할 때 윗줄을 현재줄과 같이 번역한다. 
		//() : 형변환 연산자
		
		s1 = b1; //권장 (익숙함)
		s1 = (short)b1; //권장 (가독성 향상)
		
		System.out.println("복사본: " +s1);
		
		b1 = Byte.MIN_VALUE;
		s1 = b1;
		System.out.println("복사본: " +s1); //최솟값
		
		b1 = Byte.MAX_VALUE;
		s1 = b1;
		System.out.println("복사본: " +s1); //최댓값
		
		long l1;
		
		// long = byte
		// 4byte = 1byte
		// 큰형 = 작은형
		// ***암시적 형변환 발생
		l1 = b1;
		l1 = (long)b1;
		
		System.out.println("복사본: " +l1); //최댓값
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		/*
		명시적인 형변환, 강제 타입 변환
		- 작은형 = 큰형
		- 경우에 따라 다르다. (작은형이 포함할 수 있는 원본이면 안전하고, 포함할 수 없는 원본이면 불안전하다.)
		- 결론: 굉장히 위험 > 틀려도 에러가 안남 !!!!!!!! > 값이 이상하게나옴 ;; -> 논리 오류
		*/
		
		// 컴파일 작업 vs 런타임 작업
		// - 컴파일 : 실제 프로그램을 실행하는 것이 아니라, 단지 언어만 번역하는 작업만 한다. 단, 그 과정 중에 문법이 유효한지 검사를 한다.
		
		short s2 = 10;
		byte b2;
		
		//Type mismatch: cannot convert from short to byte
		//b2 =s2;  
		b2 = (byte)s2;
		
		System.out.println("복사본: " +b2); //최댓값
		
		s2= 127;
		b2 = (byte)s2;
		System.out.println("복사본: " +b2); //최댓값
		
		s2=128;
		//b2 = 128; //컴파일 에러
		b2 = (byte)s2; //런타임 에러
		System.out.println("복사본: " +b2); //-128
		
		s2= 1000;
		b2 = (byte)s2;
		System.out.println("복사본: " +b2); //-24
		
		s2= 10000;
		b2 = (byte)s2;
		System.out.println("복사본: " +b2); //16
		
		
		// 기업은행 계좌 : 20억
		int m1 = 2000000000;
		
		// 부산 -> 이체 -> 20억
		short m2;
		
		// 사전체크 !!! 필수
		m2=(short)m1;
		
		System.out.println("잔액:" +m2);  //-27648
		System.out.println();
		System.out.println();
		System.out.println();
		
		// 암시적인 형변환
		// -> 왜 암시적? -> 개발자가 이 사실을 알던 모르던 결과는 안전하니까 .. 생략
		// short = byte
		
		// 명시적 형변환
		// -> 왜 명시적? -> 이 작업은 잘못될 가능성이 존재 -> 개발자가 이 사실을 명시적으로 책임지고 직접 형변환 해야함! > 개발자 책임!
		//byte = (byte)short
		
		s2 = 200;
		b2 = (byte)s2; //오버플로우(Overflow) or 언더플로우(Underflow) 발생 
		
		//---------------정수형끼리 형변환
		
		// 실수형
		// float, double
		
		float f1 = 3.14f;
		double d1;
		
		//8byte = 4byte
		d1 = f1;
		
		System.out.println(d1);
		
		float f2 ;
		double d2 = 3.14;
		
		//4byte = 8byte
		f2 = (float)d2;
		System.out.println(f2);
		System.out.println();
		System.out.println();
		
		
		//정수형: byte, short, int, long -> int, long 사용
		//실수형 : float, double -> double 사용(정밀도 때문에..)
		
		//정수형 상수는 무조건 int이다.
		// -100L : long
		
		byte n1  = 100; //1. byte = int 예외
		short n2 = 100; //2. short = int 예외
		int n3   = 100; //3. int = int
		long n4  = 100; //4. long = int -> 암시적 형변환
		
		//byte, short
		
		//----------------------
		
		// 정수 <-> 실수
		
		int a1;
		float a2;
		
		a1 = 100;
		
		// float = int
		// 4byte = 4byte
		a2 = a1; //암시적인 형변환
		System.out.println(a2);
		
		int a3; 
		float a4;
		
		a4 = 3.14F;
		
		// int = float
		// 4byte = 4byte
		// int(+-21억) = float(+-무한대)
	
		a3 = (int)a4; //명시적인 형변환
		
		System.out.println(a3); //3.14 ->3 //잘못된 게 아니고 의도적인 것. 
		
		long a5;
		float a6;
		
		a5 = 10000000;
		
		// float = long
		// 4byte = 8byte
		// 무한대 = +-922경
	
		a6 = a5; //명시적 아닌 암시적 형변환!
		
		System.out.println(a6);
		System.out.println();
		System.out.println();
		
		// 숫자 자료형의 크기
		// byte(1) < short(2) < int(4) < long(8)
		// float(4) < double(8)
		// byte(1) < short(2) < int(4) < long(8) <<< float(4) < double(8) ****
		
		//--------------------------------------------------------------
		
		//char
		// - 문자형 -> 문자코드로 저장 -> char는 숫자자료형에 속한다. 단, 가감승제를 안하는 숫자형
		
		// char를 정수로 형변환할 때는 반드시 int 사용한다.(short(byte)를 사용하면 안된다.)
		
		
		char c5;
		short s5;
		
		s5 = 97;
		System.out.println(s5);
		
		c5 = (char)s5;
		System.out.println(c5);
		
		
		char c6;
		short s6;
		
		c6 = 'A';
		s6 = (short)c6;
		
		System.out.println(s6);
		System.out.println((int)'A');
		System.out.println((int)'가'); 
		System.out.println((short)'가'); //오버플로우 발생
		
	}//main
	
}//Ex12_Casting
