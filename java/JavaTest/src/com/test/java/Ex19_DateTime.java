package com.test.java;

import java.util.Calendar;
import java.util.Date;

public class Ex19_DateTime {
	
	public static void main(String[] args) {
		
		/*
		
		날짜, 시간 자료형
		
		- 시간
		- 시각
		ex) 2021.04.07 09:10 -> 시간? 시각?(O) -> 한축의 점 
		ex) 8시간, 10분 -> 시간 -> 한축의 점과 점 사이의 거리
		
		- 시간과 시각은 연산의 대상이 된다.(피연산자의 자격이 있다.) -> 산술 연산, 비교 연산
		
		- 시각 + 시각 -> 2021.04.07 09:10 + 2021.04.08 12:30 = X
		- 시각 - 시각 -> 2021.04.08 - 2021.04.07 = O
		- 시각 * 시각 -> X
		- 시각 / 시각 -> X
		- 시각 % 시각 -> X
		
		- 시간 + 시간 -> 2시간 + 3시간 = O
		- 시간 - 시간 -> 3시간 - 2시간 = O
		- 시간 * 시간 -> X
		- 시간 / 시간 -> X
		- 시간 % 시간 -> X
		
		- 시각 + 시간 -> 2021.04.07 09:10 + 1시간 = 시각	(add())
		- 시각 - 시간 -> 2021.04.07 09:10 - 1시간 = 시각	(add())
	
		*/
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		m6();
		
	}//main
	
	private static void m6() {
		
		// 시간 + 시간
		// 시간 - 시간
		
		// 2시간 30분 -> 데이터
		
		Calendar c1 = Calendar.getInstance(); //-> 시각을 나타내는 클래스
		c1.set(Calendar.HOUR_OF_DAY, 2);
		c1.set(Calendar.MINUTE, 30);
		
		System.out.printf("%tF %tT\n", c1, c1); 
	
		int hour = 2;
		int min = 30;
		
		//시간 + 시간 = 시간
		min = min + 20;
		System.out.printf("%d시간 %d분\n", hour, min);
		 
		
		//2시간 50분 + 30분 => 2시간 80분 => 3시간 20분
		min = min + 30;
		System.out.printf("%d시간 %d분\n", hour, min); //=> 3시간 20분
		
		hour += min / 60; //몫 반올림
		min = min % 60;// 나머지
		
		System.out.printf("%d시간 %d분\n", hour, min);
		
	}

	private static void m5() {
		
		// 날짜 시간 연산
		// - 시각 - 시각 = 시간
		
		// 내가 태어난지 며칠째인지? 
		
		Calendar now = Calendar.getInstance();
		Calendar birthday = Calendar.getInstance();
		birthday.set(1997, 4, 9, 15, 30, 50);
		
		
		//산술 연산자 -> 피연산자는 원시형밖에 가질 수 없다. (특히 숫자형만 가능)
		
		//The operator - is undefined for the argument type(s) java.util.Calendar, java.util.Calendar   // 피연산자가 원시형이 아니라 알 수 없음.
		//System.out.println(now - birthday);
		
		// 기준점(기준시각)
		// 1970-01-01 00:00:00
		// 01-01-01 00:00:00
		
		//  2021-04-07 11:19:00
		//- 1995-04-09 15:30:50
		
		
		// 기준점 ~ 특정 시각까지의 누적 시간 -> tick값, epoch time
		//1617762442263
		//System.out.println(now.getTimeInMillis());
		
		long nowTick = now.getTimeInMillis();
		long birthTick = birthday.getTimeInMillis();
		
		// 시간 : 초, 분, 시, 일(부분 허용), 월(X), 년 (X)
		System.out.println((nowTick - birthTick) / 1000 / 60 / 60 / 24); //8733
		System.out.println();
		
		// 올해 크리스마스 며칠이 남았는지? 
		
		Calendar christmas = Calendar.getInstance();
		christmas.set(2021, 11, 25, 0, 0, 0);
		
		long christmasTick = christmas.getTimeInMillis();
		
		System.out.printf("올해 크리스마스는 %d일 남았습니다.\n", (christmasTick - nowTick) / 1000 / 60 / 60 / 24);
		
	}

	private static void m4() {
		
		// 날짜 시간 연산
		// - void add(int, int)
		// - 시각 + 시간
		
		Calendar now = Calendar.getInstance();
		
		System.out.printf("%tF\n", now); //현재시각
		
		// 현재 시각 + 100일
		now.add(Calendar.DATE, 100);  //***주의 !! -> 원본 수정
		System.out.printf("%tF\n", now); //100일 후로 교체 됨.
		
		//현재시각 + 200일
		now.add(Calendar.DATE, 100);
		System.out.printf("%tF\n", now);
		
		//초기화 - 다시 현재 시각
		now = Calendar.getInstance();
		
		// 125일 -> 만난날?
		// now -125
		now.add(Calendar.DATE, -125);
		System.out.printf("%tF\n", now);
		
		now = Calendar.getInstance();
		
		now.add(Calendar.HOUR_OF_DAY, 4);
		now.add(Calendar.MINUTE, 30);
		System.out.printf("%tT\n", now);
				
	}

	private static void m3() {
		
		//m2() : 현재 시각 만들기
		//m3() : 특정 시각 만들기
		
		// 내 생일
		// - 1995년 5월 9일 15시 30분 50초
		
		Calendar birthday = Calendar.getInstance();
		
		// System.out.println(birthday);
		
		//obj.get() : 읽기 메소드
		//obj.set() : 쓰기 메소드
		
		
		// 일단 현재 시각을 만든 뒤 원하는 시각으로 수정을 한다.
		// 수정
		// - void set(int, int)
		// - void set(int, int, int) // year, month, date
		// - void set(int, int, int, int, int, int) //년월일, 시분초
		
		birthday.set(Calendar.YEAR, 1997);
		birthday.set(Calendar.MONTH, 4);
		birthday.set(Calendar.DATE, 9);
	
		//birthday.set(Calendar.DATE, 9);
		
		//System.out.println(birthday);
		
//		System.out.println(birthday.get(Calendar.YEAR));
//		System.out.println(birthday.get(Calendar.MONTH));
//		System.out.println(birthday.get(Calendar.DATE));
		
		//printf() -> %s, %d, %c, %b, %f + 날짜시간 형식문자
		
		System.out.printf("%tF\n", birthday); // 년월일 // 1995년 5월 9일
		System.out.printf("%tT\n", birthday); // 시분초 // 현재시각
		
		
		birthday.set(Calendar.HOUR, 15);
		birthday.set(Calendar.HOUR_OF_DAY, 15);  //** 권장
		birthday.set(Calendar.MINUTE, 23);
		birthday.set(Calendar.SECOND, 50);
		
		System.out.printf("%tT\n", birthday); // 특정시각
		System.out.println();
		System.out.println();
		
		
		//수료날짜(2021-09-02 18:00:00
		Calendar endDay = Calendar.getInstance();
		
		//endDay.set(2021, 8, 2);
		//endDay.set(18, 0, 0);
		
		endDay.set(2021, 8, 2, 18, 0, 0);
		System.out.printf("%tF %tT\n", endDay, endDay);
		
	}

	private static void m2() {
		
		// Calendar 클래스
		
		// 현재 시각 얻어오기
		Calendar now = Calendar.getInstance();
		
		//java.util.GregorianCalendar[time=1617756225570,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2021,MONTH=3,WEEK_OF_YEAR=15,WEEK_OF_MONTH=2,DAY_OF_MONTH=7,DAY_OF_YEAR=97,DAY_OF_WEEK=4,DAY_OF_WEEK_IN_MONTH=1,AM_PM=0,HOUR=9,HOUR_OF_DAY=9,MINUTE=43,SECOND=45,MILLISECOND=570,ZONE_OFFSET=32400000,DST_OFFSET=0]
		
		System.out.println(now);
		System.out.println();
		System.out.println();
		System.out.println();
		
		//Calendar 결과에서 원하는 항목을 추출하는 방법
		// - int get(int)
		
		System.out.println(now.get(1)); //2021
		System.out.println(now.get(2)); //3
		System.out.println(now.get(3)); //15
		System.out.println(now.get(4)); //2
		System.out.println(now.get(5)); //7
		
		// 상수와 변수의 역할 차이
		// 1. 변수(변경 가능), 상수(변경 불가능)
		// 2. 변수(의미O), 상수(의미X)
		int year = 1;
		
		System.out.println(now.get(1));
		System.out.println(now.get(year));
		
		//상수를 직접 사용하지 말자!! -> 반드시 변수에 담아서 사용하자!!! -> 가독성
	//	System.out.println(now.get(20)); //?
		
		int age = 20;
		System.out.println(age); //나이
		
		
		System.out.println("홍길동"); //? -> 사람이름 ? X 오해의 소지 있음. 
		System.out.println();
		
		//now.get(원하는 항목 번호);
		// int year = 1;
		System.out.println(Calendar.YEAR);
		
		System.out.println(now.get(year));
		System.out.println(now.get(Calendar.YEAR));//0
		System.out.println();
		System.out.println();
		System.out.println();
		
		// 주의 시작 -> 일 or 월 
		// 우리나라 -> 주의 시작 -> 월 
		// ISO -> 월 
		// 해당 월의 첫주는 -> 목요일 포함 유무
		
		//Calendar.YEAR : Calendar 상수
		System.out.println(now.get(Calendar.YEAR));			//년. 2021
		System.out.println(now.get(Calendar.MONTH));		//월. 3	 1월(0) ~ 12월(11)
		System.out.println(now.get(Calendar.DATE));			//일. 7
		System.out.println(now.get(Calendar.HOUR));			//시(12H)
		System.out.println(now.get(Calendar.MINUTE));		//분
		System.out.println(now.get(Calendar.SECOND));		//초
		System.out.println(now.get(Calendar.MILLISECOND));	//밀리초(1/1000초)
		System.out.println(now.get(Calendar.AM_PM));		//오전(0), 오후(1)
		System.out.println(now.get(Calendar.DAY_OF_MONTH));	//일(Date)
		System.out.println(now.get(Calendar.DAY_OF_WEEK));	//요일 일(1) ~ 토(7)
		System.out.println(now.get(Calendar.DAY_OF_YEAR));	//올해들어 며칠째? 
		System.out.println(now.get(Calendar.HOUR_OF_DAY));	//시(24H)
		System.out.println(now.get(Calendar.WEEK_OF_YEAR));	//몇주차
		System.out.println();
		System.out.println();
		System.out.println();
		
		// 요구사항] 오늘은 '2021년 4월 7일'입니다.
		
		now = Calendar.getInstance();
		
		System.out.printf("오늘은 '%d년 %d월 %d일'입니다.\n", now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, now.get(Calendar.DATE));
		
		
	}
	
	private static void m1() {
	
		/*
		 
		자바의 날짜시간 자료형
		
		- JDK 1.0: Date 클래스 -> 거의 사용 안함(deprecated- 소멸 예정)
		- JDK 1.1: Calendar 클래스 -> O
		- JDK 1.8: java.time 클래스 -> O
		 		 
		*/
		
		// 현재 시스템의 시간이 now라는 변수에 담긴다.
		Date now = new Date(); 
		
		System.out.println(now);
		
		//The method getMinutes() from the type Date is deprecated
		System.out.println(now.getHours()); //deprecated
		System.out.println(now.getMinutes());
		
	}
		
}//Ex19_DateTime
