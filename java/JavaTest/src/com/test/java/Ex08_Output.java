package com.test.java;

public class Ex08_Output {
	
	public static void main(String[] args) {
		
		
		// 콘솔 입출력, Console Input Output, Console IO
		// - 기본 입력 장치 : 키보드
		// - 기본 출력 장치 : 모니터
		
		// 콘솔 출력
		
		// 콘솔 입력
		
		// 콘솔에서 데이터를 모니터(화면)에 출력하는 방법
		// System.out.println()
		// 클래스, 필드, 메소드()
		
		
		// 1. System.out.println()
		// - 데이터를 출력한 뒤 엔터를 추가로 출력한다. 
		// - print line
		
		// 2. System.out.print()
		// - 데이터를 출력한 뒤 끝..
		// - 개행 없음.
		
		// 3. System.out.printf()
		// - print format
		// - 형식 문자열 지원
		// - 출력할 문자열을 보다 쉽게 구성할 수 있도록 도와주는 출력문
		
		
		System.out.println(100);
		System.out.println(200);
		System.out.println(300);
		
		System.out.print(100);
		System.out.print(200);
		System.out.print(300);
		System.out.println();
		System.out.println();
		
		String name1 = "홍길동";
		int kor1 = 90;
		int eng1 = 95;
		int math1 = 85;
		
		String name2 = "아무개";
		int kor2 = 81;
		int eng2 = 79;
		int math2 = 88;
		
		System.out.println("==============================");
		System.out.println("\t     성적표");
		System.out.println("==============================");
		System.out.println("[이름]\t[국어]\t[영어]\t[수학]"); //테이블 머릿말, table header

		System.out.print(name1 + "\t");
		System.out.print(kor1);
		System.out.print("\t");
		System.out.print(eng1);
		System.out.print("\t");
		System.out.print(math1 + "\n");
		
		System.out.print(name2 + "\t" + kor2 + "\t" + eng2 + "\t" +math2);
		
		System.out.println();
		System.out.println();
		
		
		// 70kg -> byte
		// 개발자는 항상 데이터의 변화를 미리 예측해야한다. 
		
		// printf()
		// - %s : 형식 문자, place holder
		
		// 요구사항] "안녕하세요. 홍길동님" > 출력
		String name = "홍길동";
		System.out.println("안녕하세요. " + name+ "님");
		
		System.out.printf("안녕하세요. %s님\n", name); //출력후 엔터 안침
		
		System.out.printf("안녕하세요. %s님\n", "아무개");
		System.out.println();
		
		//수정사항] "안녕하세요. 홍길동님. 반갑습니다. 홍길동님" > 출력
		System.out.println("안녕하세요. " + name+ "님. 반갑습니다. " +name + "님"); //유연한 코드, 동적인 코드
		System.out.printf("안녕하세요. %s님. 반갑습니다. %s님\n", name, name);
		
		System.out.println("안녕하세요. 홍길동님. 반갑습니다. 홍길동님"); // 정적인 코드
		System.out.println();
		
		//insert int0 tblMember (seq, name, age, address, tel) values (10, '홍길동', 20, '서울시 강남구 역삼동', '010-1234-5678')
		
		String seq = "10";
		name = "홍길동";
		String age = "20";
		String address = "서울시 강남구 역삼동";
		String tel = "010-1234-5678";
		
		System.out.println("insert into tblMember (seq, name, age, address, tel) values (" + seq+ ", '" +name+ "' ," + age+", '"+address+"', '" +tel+ "')");
		
		System.out.printf("insert into tblMember (seq, name, age, address, tel) values (%s, '%s', %s, '%s', '%s')", seq, name, age, address, tel);
		System.out.println();
		// printf()
		// - 형식문자
		// 1. %s : String
		// 2. %d : Decimal(byte, short, int, long)
		// 3. %f : Float(float, double)
		// 4. %b : Boolean
		// 5. %c : Char
		
		System.out.printf("문자열: %s\n", "문자열");
		System.out.printf("정수: %d\n", 100);
		System.out.printf("실수: %f\n", 3.14);
		System.out.printf("논리: %b\n", true);
		System.out.printf("문자: %c\n", 'A');
		
		
		//System.out.printf("이름: %s, 나이 : %d");
		//System.out.printf("이름: %s, 나이 : %d", "홍길동");
		//System.out.printf("이름: %s, 나이 : %d", "홍길동", 20);
		//System.out.printf("이름: %s, 나이 : %d", "홍길동", "20");
		//System.out.printf("이름: %s, 나이 : %d", "홍길동", 20, "남자");
		
		//안세요
		System.out.println("안녕하\b\b세요.");
		System.out.println();
		
		// 자동 줄바꿈
		// Alt + Shift + y
		
		// 프로그래밍 시장에서 자바가 차지하는 점유율은 45%입니다.
		int java = 45;
		
		// 어떤 특수한 역할을 하는 문자를 이스케이프하고 싶으면 .. 보통 같은 문자를 한 번 더 적는다.
		// -> 자바(\) -> \\
		// -> 자바(%) -> %%
		// ->SQL(') -> ''
		System.out.printf("프로그래밍 시장에서 자바가 차지하는 점유율은 %d%%입니다.", java);
		System.out.println();
		System.out.println();
		
		
		// 형식 문자 기능
		// - 출력할 데이터의 위치를 지정하는 요소
		
		// 1. %숫자d 
		// - 출력할 내용물의 최소 너비
		// - %d, %f, %c, %b, %s
		// - +(우측 정렬)
		// - -(좌측 정렬)
		// - 수치 데이터(연산 대상) > 우측 정렬
		// - 수치가 아닌 데이터(숫자, 문자열) > 좌측 정렬(중앙 정렬)
		
		// 2. %.숫자f
		// - 소수점 이하 자릿수 지정
		// - %f(float, double) 
		
		
		// 3. %,d 
		// - 천단위 표기(3자리마다, 찍기)
		// - %d, %f
				
		
		System.out.printf("숫자:%d입니다.\n", 10); //숫자:10입니다.
		System.out.printf("숫자:%5d입니다.\n", 10);//숫자:   10입니다.
		System.out.printf("숫자:%10d입니다.\n", 10);//숫자:        10입니다.
		System.out.printf("숫자:%5d입니다.\n", 1234567);//숫자:1234567입니다. //데이터가 더 크면 아무 의미 없음
		System.out.printf("숫자:%d입니다.\n", 1234567);
		System.out.printf("숫자:%-5d입니다.\n", 10);
		System.out.println();
		System.out.println();
		System.out.println();
		
		//System.out.printf("숫자: %f\n", 123); //error
		System.out.printf("숫자: %f\n", 123.4567);//double
		System.out.printf("숫자: %.4f\n", 123.4567);
		System.out.printf("숫자: %.1f\n", 123.4567);
		System.out.printf("숫자: %.0f\n", 123.4567);
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.printf("숫자: %d\n", 1000000);
		System.out.printf("숫자: %,d\n", 1000000);
		System.out.println();
		System.out.println();
		System.out.println();
		
		// 1,000,000 -영문권(3자리)
		// 100,0000  -한국(4자리)
		
		
		// 3가지 모두 적용
		System.out.printf("숫자:%,10.1f\n", 1234.5678);//숫자:    1,234.6 //10자릿수, 소수점 한자리, ,채우기
		System.out.println();
		System.out.println();
		System.out.println();

		
		//****************
		// - 숫자 출력 > 반드시 !!!!!!!! 단위 표기 
		System.out.println("=======================");
		System.out.println("    음료가격(단위: 원)");
		System.out.println("=======================");
		System.out.printf("1. 콜라: %d\n", 2500);
		System.out.printf("2. 스무디: %d\n", 3500);
		System.out.printf("3. 쿠키: %d\n", 500);
		System.out.printf("4. 아메리카노: %d\n", 12500);
		
		
		
		System.out.println();
		System.out.println();
		System.out.println("=======================");
		System.out.println("    음료가격(단위: 원)");
		System.out.println("=======================");
		System.out.printf("1. 콜라:\t\t%,6d\n", 2500);
		System.out.printf("2. 스무디:\t%,6d\n", 3500);
		System.out.printf("3. 쿠키:\t\t%,6d\n", 500);
		System.out.printf("4. 아메리카노:\t%,6d\n", 12500);
		
		System.out.println();
		System.out.println();
		
		
		/*
		 
		 에러, Error
		 - 오류, 버그(Bug), 예외(Exception) 등등..
		  
		 1. 컴파일 오류
		 -  컴파일 작업할 때 발생하는 오류
		 -  컴파일러 발견 > 문법이 틀렸다 !!!
		 -  발견 시 모든 컴파일 작업 중단 !!! > 산출물 발생 안함
		 -  난이도 가장 낮음 > 발견 쉬움 > 컴파일러가 알려줌 > 고치기 쉽다.
		 -  오타
		 - 빨리 모든 패턴 익숙하게 ,, 
		 
		 2. 런타임 오류
		 -  프로그램 실행 중 발생하는 오류
		 -  컴파일 작업 중에는 발견되지 않았지만 실행 중에 발견이 되는 오류
		 -  예외(Exception)
		 -  일단, 발견 즉시 수정해야 하는 오류 > 발견이 힘들다 > 고치기 힘들다.
		 -  돈 + 사람 > 검사
		 -  Closed Alpha > Closed Beta > Opened Alpha > Open Beta
		 
		 3. 논리 오류 
		 -  컴파일 성공, 실행 성공 > 결과가 이상함 ... 
		 -  발견이 엄청 힘듬 > 고치기 엄청 힘듬. 
		 -  처음 ~ 끝까지 다시 살펴보기 ,,
		 -  정신차리고 작업 !!
		  
		 
		*/
		// 이클립스는 javac.exe(컴파일러)와 편집기가 실시간 연동이 된다. 코드 작성을 할 때마다 구문 검사가 실시간으로 자동 실행된다.
		//int a = 10
		
		int num;
		
		num = 1; //사용자가 키보드로 입력한 숫자 > 경우의 숫자 ? > 42억
		
		// 나눗셈
		// 피재수 / 재수
		// - 정수의 나눗셈은 재수가 0이 될 수 없다.		
		
		//java.lang.ArithmeticException:  /by zero
		System.out.printf("100 / %d = %d\n", num, 100/num);
		System.out.println();
		
		System.out.println(10 - 20); //-> 논리오류 (+를 -로 사람의 실수 ) 
		
	}//main
}//Ex08_Output
