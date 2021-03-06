package com.test.spring.di.ex06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex06 {

	public static void main(String[] args) {
		
		//Student 객체를 생성 + 사용
		
		//m1();
		//m2();
		m3();
		
		
	}//main

	private static void m3() {

		//원래 방식
		Student s1 = new Student("홍길동", "중학교");
		System.out.println(s1);

		
		//스프링 방식
		ApplicationContext context = new ClassPathXmlApplicationContext(".\\config06.xml");

		Student s2 = (Student)context.getBean("s2"); //<bean id="s2">
		System.out.println(s2);
		
		
		Student s3 = (Student)context.getBean("s3"); //id
		System.out.println(s3);
		
		
		Student a4 = (Student)context.getBean("temp"); //name
		System.out.println(a4);
		
		
		
		
	}

	private static void m2() {

		//객체 생성을 개발자가 직접하지 않고 스프링 프레임워크에게 그 역할을 맡기기
		// -> 스프링에게 Student 객체를 만들어 주세요~
		
		//스프링 설정 파일(config06.xml)에 정의되어 있는 s1이라는 <bean>을 통해서 객체 생성하기
		//스프링 설정 파일 읽기
		ApplicationContext context = new ClassPathXmlApplicationContext(".\\config06.xml");
		
		//new Student() <- 이 코드가 없음
		Student s1 = (Student)context.getBean("s1"); //return new Student()의 역할
		
		s1.setName("아무개");
		s1.setSchool("대치 고등학교");
		
		System.out.println(s1);
	}

	private static void m1() {
		
		//평범한 객체 생성 방식(new 연산자 + 생성자)
		Student s1 = new Student();
		
		s1.setName("홍길동");
		s1.setSchool("역삼 중학교");
		
		System.out.println(s1);
	}
	
	
}
