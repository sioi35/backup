package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex25_String {
	
	public static void main(String[] args) throws IOException {
		
		// 문자열, String(***)
		// - 문자열 관련된 여러가지 기능을 자바가 제공
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));	
	
	//m1();
	//m2(reader);
	//m3(reader);
	//m4(reader);
	//m5(reader);
	//m6(reader);
	//m7();
	//m8(reader);
	//m9(reader);
	//m10(reader);
	//m11(reader);
	//m12(reader);
	//m14(reader);
	m15(reader);
	}//main

	private static void m15(BufferedReader reader) {

		// 문자열 치환(바꾸기)
		// - 문자열의 일부를 교체
		// - String replace(String old, String new)
		
		String txt = "안녕하세요. 홍길동님.";
		System.out.println(txt.replace("홍길동", "아무개"));
		
		String oldValue = "홍길동";
		String newValue = "아무개";
		
		// "안녕하세요. 홍길동님."
		// "안녕하세요. "
		// "홍길동" -> "아무개"
		// "님."
		
		int index = txt.indexOf(oldValue);
		
		if(index > -1) {
			
			String str1 = txt.substring(0, index);// "안녕하세요. "
			String str3 = txt.substring(index + oldValue.length()); //"님."
			
			System.out.println(str1 + newValue + str3);
			
		}
		System.out.println();
		
		txt = "안녕하세요. 홍길동님. 반갑습니다. 홍길동님. 잘가세요. 홍길동님.";
		
		System.out.println(txt.replace("홍길동", "아무개"));
		
		System.out.println(txt.replace(" ", "")); // ***공백 없애기
		
		txt = "우리는 Java Class입니다.";
		String word = "Java Class";
		
		if(txt.replace(" ", "")
				.toUpperCase()
				.indexOf(word.replace(" ","")
						.toUpperCase()) > -1 ) {
			System.out.println("O");
		}else {
			System.out.println("X");
		}
		
	}

	private static void m14(BufferedReader reader) {

		//문자열 추출
		// - char charAt(int index) : 1문자 추출
		// - String substring(int beginIndex, int endIndex) : 여러문자 추출
		//		- beginIndex(inclusive), endIndex(exclusive)
		
		String txt = "가나다라마바사아자차카타파하";
		
		System.out.println(txt.substring(3, 8)); //라마바사아 -> 3~7
		//System.out.println(txt.substring(3,100));//에러
		System.out.println(txt.substring(3)); //라마바사아자차카타파하 시작위치 ~끝
		System.out.println();
		
		String jumin = "970509-1234567";
		
		System.out.println(jumin.charAt(6) == '-');
		System.out.println(jumin.indexOf("-") == 6);
		System.out.println(jumin.substring(6,7).equals("-"));
		System.out.println();
		
		// 남자? 여자
		System.out.println(jumin.substring(7,8).equals("1") ? "남자" : "여자");
		
		// charAt() or substring()
		// -> 추출한 글자수에 따라서
		// 1글자 추출 -> charAt() or substring() -> 문자 코드가 필요
		// N글자 추출 -> substring()
		
		// 자주 사용하는 예제
		String path = "C:\\class\\java\\JavaTest\\src\\com\\test\\java\\Hello.java";
		
		//파일명??Hello.java
		int index = path.lastIndexOf("\\");
		String filename = path.substring(index +1);
		System.out.println(filename);
		
		//확장자 없는 파일명 ? Hello 
		index = filename.lastIndexOf(".");
		String filenameWithOutExt = filename.substring(0, index);
		System.out.println(filenameWithOutExt);
		
		
		//확장자? .java
		String ext = filename.substring(index);
		System.out.println(ext);
		
	}

	private static void m13(BufferedReader reader) {

		// 검색
		// - int indexOf(String s)
		// - int lastIndexOf(String s)
		
		String txt = "안녕 홍길동. 잘가 홍길동.";
		
		System.out.println(txt.indexOf("홍길동")); // 첫번째 왼 -> 오
		System.out.println(txt.lastIndexOf("홍길동")); //두번째 오 -> 왼
		System.out.println(txt.lastIndexOf("홍길동", 10)); //오 -> 왼
		
	}

	private static void m12(BufferedReader reader) {
		
		// 패턴 검색
		// - boolean startsWith(String word)
		// - boolean endsWith(String word)
		
		String name = "홍길동";
		
		// 이름이 '홍'씨? > boolean
		System.out.println(name.startsWith("홍"));
		System.out.println(name.startsWith("김"));
		
		System.out.println(name.charAt(0) == '홍');
		System.out.println(name.indexOf("홍") == 0);
		System.out.println();
		
		//이름이 '동'으로 끝나는가?
		System.out.println(name.endsWith("동"));
		System.out.println(name.charAt(name.length()-1) == '동');
		System.out.println(name.indexOf("동") == name.length() - 1);
		System.out.println();
		
		String file = "cat.jpg";
		
		// 해당 파일이 이미지? 
		if(file.endsWith(".jpg")) {
			System.out.println("이미지 파일 맞음");
		}else {
			System.out.println("이미지 파일 아님");
		}
	
	}

	private static void m11(BufferedReader reader) {

		//대소문자 변경
		// - String toLowerCase()
		// - String toUpperCase()
		
		String txt = "Hello Word";
		
		System.out.println(txt);
		System.out.println(txt.toLowerCase());
		System.out.println(txt.toUpperCase());
		System.out.println();
		
		// 검색
		// 1. 정확도 높음
		// 2. 검색률 높음
		String content = "우리가 배우는 과목은 Java입니다."; //DB
		String word = "java";
		
		//System.out.println(content.toUpperCase());
		//System.out.println(word.toUpperCase());
		
		//if(content.indexOf(word) > -1) {
		if( content.toUpperCase().indexOf(word.toUpperCase()) > -1) {
			System.out.println("검색 결과 있음");
		}else {
			System.out.println("검색 결과 없음");
		}
		
		//메소드 체인
		//content.toUpperCase().indexOf()
		//"abc".toUpperCase().indexOf()
		//"ABC".indexOf()
		
		
		
	}

	private static void m10(BufferedReader reader) {
		
		// 문자열 검색(***)
		// - 문자열내에서 원하는 문자(열)을 검색 > 위치 반환
		// - int indexOf(char c)
		// - int indexOf(String s)
		// - int indexOf(char c, int index)
		// - int indexOf(String s, int index)
		
		String txt = "안녕하세요. 홍길동님. 반갑습니다. 홍길동님.안녕하세요. 홍길동님. 반갑습니다. 홍길동님.";
		
		// indexOf는 무조건 처음 만나는 검색어의 위치만 반환한다.
		System.out.println(txt.indexOf("홍길동")); //7
		System.out.println(txt.indexOf("홍길동")); //7
		
		System.out.println(txt.indexOf("홍길동", 10)); //20
		System.out.println();
		
		int index = txt.indexOf("홍길동");
		System.out.println(index); //7
		
		index = txt.indexOf("홍길동", index + "홍길동".length());
		System.out.println(index);// 20
		
		index = txt.indexOf("홍길동", index + "홍길동".length());
		System.out.println(index);//-1
		
		
		//최종본 ~!!
		// - 검색어를 모두 찾기 !!!
		index = 0;
		
		while(true) {
			
			index = txt.indexOf("홍길동", index);
			
			if(index == -1) {
				break;
			}
			
			System.out.printf("%d번째 발견\n", index);
			
			index += "홍길동".length();
			
		}
		
	}

	private static void m9(BufferedReader reader) {

		// 게시판 > 글쓰기
		// - 관리자 모드 : 금지어 설정
		
		String txt = "안녕하세요. 반갑습니다.";
		
		// 금지어: 바보
		if(txt.indexOf("바보") == -1) {
			System.out.println("글쓰기 진행");
		}else {
			System.out.println("금지어 사용 금지!");
		}
		
	}

	private static void m8(BufferedReader reader) throws IOException {

		// 문자열 검색(***)
		// - 문자열내에서 원하는 문자(열)을 검색 > 위치 반환
		// - int indexOf(char c)
		// - int indexOf(String s)
		
		String txt = "안녕하세요. 홍길동입니다."; // 0 ~ 13
		
		int n = txt.indexOf('홍');
		System.out.println(n);
		
		n = txt.indexOf("홍길동");
		System.out.println(n);
		
		n = txt.indexOf("아무개");
		System.out.println(n); //-1
		
		txt = "13일 기상청은 \"오늘 아침 기온은 어제보다 2~5도 올라 전국 대부분 지역에서 10도 내외가 되겠으나 낮부터 북서쪽에서 찬 공기가 남하해 쌀쌀해지겠다\"며 \"내일과 모레 아침 기온은 오늘보다 10도 가량 큰 폭으로 떨어져 전국 대부분 지역에서 5도 이하로 내려가겠다\"고 밝혔다.\r\n"
				+ "\r\n"
				+ "그러면서 \"일부 경기북부와 강원내륙, 강원산지, 충북북부, 전북동부, 경북북부 내륙에는 내일 아침 기온이 오늘보다 10도 이상 큰 폭으로 떨어져 한파특보가 발표효 가능성이 있다\"고 덧붙였다.\r\n"
				+ "\r\n"
				+ "14일 아침 최저기온은 -1~7도, 낮 최고기온은 12~18도로 예보됐다.\r\n"
				+ "\r\n"
				+ "기상청에 따르면 이날 낮 최고기온은 서울 14도, 인천 12도, 수원 14도, 춘천 16도, 강릉 17도, 청주 16도, 대전 17도, 세종 17도, 전주 16도, 광주 16도, 대구 17도, 부산 18도, 울산 17도, 창원 18도, 제주 14도 등이다.";
		
		while(true) {
			
			System.out.print("검색어: ");
			String word = reader.readLine();
			
			if(txt.indexOf(word) > -1) {
				//검색 O
				System.out.printf("txt의 %d번째 위치에서 발견함\n", txt.indexOf(word));
			}else {
				System.out.println("검색어 없음.");
				break;
			}
		}
		
		
	}

	private static void m7() {
		
		// 공백 제거
		// -String trim()
		// - 문자열내의 시작과 끝에 존재하는 공백을 제거
		
		String txt = "    하나   둘   셋    ";
		
		System.out.printf("[%s]\n", txt);
		System.out.printf("[%s]\n", txt.trim());
		
	}

	private static void m6(BufferedReader reader) throws IOException {

		// 주민 등록 번호 입력
		// - 반드시 '-'를 입력하시오.
		
		System.out.print("주민등록번호: ");
		String jumin = reader.readLine();
		
		// 970509-1234567
		
		if(jumin.charAt(6)=='-') {
			System.out.println("올바른 주민등록번호");
			
			if(jumin.charAt(7) == '1') {
				System.out.println("남자");
			}else if(jumin.charAt(7) == '2') {
				System.out.println("여자");
			}
			
		}else {
			System.out.println("잘못된 주민등록번호");
		}
		
	}

	private static void m5(BufferedReader reader) throws IOException {
		
		// 1. length() : 문자열 길이(문자수)
		// 2. charAt() : 특정 위치의 문자 추출
	
		//*** 원시형과 참조형간에는 형변환이 불가능하다.
		char c = 'A'; //값형, 원시형
		String s = "A"; //참조형
		
		System.out.println((int)c);
		//Cannot cast from String to int
		//System.out.println((int)s); // 문자열로부터는 형변환을 통해서 문자 코드값을 얻어 낼 수 없다.
		
		//Invalid character constant
		//c ='ABC';// -> 정수 -> 1문자의 문자 코드
		c = 'A';
		s = "ABC";
		
		c = s.charAt(0);
		System.out.println((int)c);
		System.out.println();
		
		System.out.print("입력: ");
		String input = reader.readLine();
		
		
		
		
		for(int i=0; i<input.length(); i++) {
			
			c = input.charAt(i);
			//System.out.printf("%c(%d)\n",c, (int)c);
			
			// 'a' <= c <='z'
			//if((int)c >= 97 && (int)c <= 122) { 
			//if((int)c < 97 || (int)c >122) {
			//if((int)c < (int)'a' || (int)c > (int)'z') {	
			
			// A. 영어 소문자만 입력
			// "hello"
			// "hello123"
			
//			if(c < 'a' || c > 'z') {	// 문자끼리 비교연산. -> char일때만 가능 Strig X
//				System.out.println("유효하지 않음");
//				break;
//			}
			
			//B. 영어 대문자만 입력
//			if(c < 'A' || c > 'Z') {
//				System.out.println("유효하지 않음");
//				break;
//			}
			
			// C. 영어 대소문자만 입력
//			if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
//				System.out.println("유효하지 않음");
//				break;
//			}
			
			// D. 숫자만 입력
//			if(c < '0' || c >'9') {
//				System.out.println("유효하지 않음");
//				break;
//			}
			
			// E. 영어 대소문자 + 숫자
//			if((c < 'a' || c > 'z') &&
//			   (c < 'A' || c > 'Z') &&
//			   (c < '0' || c >'9')) {
//				System.out.println("유효하지 않음");
//				break;
//			}
			
			// F. 한글만 입력
			// 조합형 한글 : 자음, 모음 조합 -> 한 문자
			// 완성형 한글 : 글자 자체를 등록 
//			if(c < '가' || c >'힣') {
//				System.out.println("유효하지 않음");
//				break;
//			}
			
			// G. 영어대소문자 + 숫자 + '_' + 공백만 입력
			if((c < 'a' || c > 'z') &&
			   (c < 'A' || c > 'Z') && 
			   (c < '0' || c >'9') &&
			   (c != '_' ) &&
			   (c != ' ')) {
				System.out.println("유효하지 않음");
				break;
			}
		
			
		}//for
		System.out.println("종료");
			
	}

	private static void m4(BufferedReader reader) {
		
		// 유효성 검사
		// - 이름 입력 > 2자 ~ 5자 이내 + 한글만..
		
		//영소문자로만 구성
		String id = "test";
		
		for(int i = 0; i < id.length(); i++) {
			
			char c = id.charAt(i);
			int code = (int)c;
			
			// 유효성 검사 -> 잘못된 경우 찾는 것이 좋다.
			if(code < 97 ||code > 122) {
				System.out.println("잘못된 문자가 있습니다.");
				break;// 잘못된 문자가 발견되면 더이상 유효성 검사가 필요없다.
			}
		
		}
		
		System.out.println("종료");	
		
	}

	private static void m3(BufferedReader reader) {
		
		// 문자열 추출
		// - 원하는 위치의 문자를 추출
		// - char charAt(int index)
		//		- index: 추출하고자 하는 문자의 위치(첨자, index)
		// - 서수를 0부터 센다. > Zero-based Index(자바)
		
		String txt = "홍길동";  //0, 1, 2 -> 3
		//char c = txt.charAt(7);
		//System.out.println(c);
		
		//java.lang.StringIndexOutOfBoundsException: index 6, length 6 // 인덱스가 범위를 벗어남.
		
		for(int i=1; i<=10; i++) {
			//10회전	(빈도 낮음)		
		}
		
		for(int i=0; i<10; i++) {
			//10회전 (빈도 높음)
		}
		
		//java.lang.StringIndexOutOfBoundsException: index 3, length 3
		for(int i=0; i<=txt.length(); i++) {
			System.out.println(txt.charAt(i));
		}
		
	}

	private static void m2(BufferedReader reader) throws IOException {
		
		// 길이
		// - 유효성 검사
		
		// 회원 가입 > 이름 입력 > [유효성 검사] -> DB 저장 (10글자)
		// -> 20자 입력 -> DB 에러 발생
		
		// 이름 입력 > 2자 ~ 5자 이내
		
//		System.out.print("이름 입력: ");
//		String name = reader.readLine();
//		
//		if(name.length() >= 2 && name.length()<=5) {
//			System.out.println("회원 가입 진행 ");
//		}else {
//			System.out.println("이름은 2자~5자 이내로 입력하세요.");
//		}
		
		// 올바른 이름을 입력할 때까지 위의 작업을 반복!
		
		String name = "";
		
		while(true) {
			System.out.print("이름 : ");
			name = reader.readLine();
			
			if(name.length() >= 2 && name.length() <= 5) {
				break;
			}else {
				System.out.println("이름은 2자~5자 이내로 입력하세요.");
			}
			
		}// while
		
		System.out.println("회원 가입 진행");
		
		
	}

	private static void m1() throws IOException {

		// 문자열 길이
		// - 문자열을 구성하는 문자의 갯수(글자 수)
		// - int length()
		
		String txt = "";
		
		txt = "ABCDEF";
		
		System.out.println(txt.length()); // 6글자
		System.out.println("ABCDEF".length());
		
		txt = "123 홍길동 !@#";//숫자, 한글, 영어, 특수문자, 공백 -> 모두 1글자로 취급
		System.out.println(txt.length()); // 11글자
		
		System.out.println((int)' ');	// 스페이스(32)
		System.out.println((int)'	');	// 탭(9)
		System.out.println((int)'\t');	// 탭(9)
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문장:");
		txt = reader.readLine();
		
		// 요구사항] 사용자 입력한 문장이 몇글자인지?
		System.out.printf("입력한 문장은 총 %d개의 문자로 구성되어있습니다.", txt.length());
		
	}
	
}//Ex25_String
