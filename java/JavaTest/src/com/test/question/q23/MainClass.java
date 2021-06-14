package com.test.question.q23;

public class MainClass {

	public static void main(String[] args) {
		
		//학생
		System.out.println("<학생>");
		Student s1 = new Student();
		System.out.println(s1.info());
		
		Student s2 = new Student("홍길동", 13);
		System.out.println(s2.info());
		
		Student s3 = new Student(3,10,30);
		System.out.println(s3.info());
		
		Student s4 = new Student("아무개", 12, 1, 5, 11);
		System.out.println(s4.info());
		System.out.println();
		
		//시간
		System.out.println("<시간>");
		Time t1 = new Time();
		System.out.println(t1.info());
		
		Time t2 = new Time(2, 30, 45);
		System.out.println(t2.info());
		
		Time t3 = new Time(1, 70, 30);
		System.out.println(t3.info());
	
		Time t4 = new Time(30, 10);
		System.out.println(t4.info());
		
		Time t5 = new Time(90, 10);
		System.out.println(t5.info());
		
		Time t6 = new Time(50);
		System.out.println(t6.info());

		Time t7 = new Time(10000);
		System.out.println(t7.info());
		
	}//main
}//MainClass
