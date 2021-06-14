package com.test.java.obj;

import lombok.Data;

//@XXX : 어노테이션(Annotation) -> 주석같은 형태 + 프로그래밍 명령어

//@Getter
//@Setter

@Data //@Getter, @Setter, @toString().... 기본 모음
public class Glass {
	
	//Lombok 사용 -> 메소드 편집 불가능 -> 유효성 검사 or 데이터 조작 -> 개발자 개입 불가능 -> ???
	//멤버 변수(private) + Getter/Setter 이유
	// -> 잘못된 데이터가 유입될까봐 -> 유효성 검사
	
	//객체를 사용하는 환경
	//1. 열린 환경
	// - 내가 만든 클래스를 소통이 없는 다른 사람이 사용할 수 있는 환경
	//2. 닫힌 환경
	// - 내가 만든 클래스를 나만 사용하거나, 의사 소통이 아주 긴밀한 사람들만이 사용할 수 있는 환경
	// - 유효성 검사가 필요없는 클래스 멤버

	private String name;
	private String color;
	private int price; //-1000
	
}