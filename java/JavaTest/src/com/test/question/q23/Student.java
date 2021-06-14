package com.test.question.q23;

public class Student {

	private String name; //이름
	private int age; // 나이
	private int grade; // 학년
	private int classNumber; //반
	private int number; //번호

	
	public Student() {
		this("미정", 0, 0, 0, 0); //생성자 호출
	}
	
	public Student(String name, int age) {
		this(name, age, 0, 0, 0); //생성자 호출
	}
	
	public Student(int grade, int classNumber, int number) {
		this("미정", 0, grade, classNumber, number); //생성자 호출
	}
	
	
	//중복 코드 제거하기 위해 다른 생성자에 의해 호출됨
	public Student(String name, int age, int grade, int classNumber, int number) {
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.classNumber = classNumber; 
		this.number = number;
	}
		
	public String info() {
		// 변수에 0값이 들어있을때 삼항연산자 사용하여 -> "미정"출력
		return this.name+ "(나이: " + (this.age != 0 ? this.age +"세" : "미정") +", 학년:"+ (this.grade!= 0 ? this.grade:"미정" )
				+ ", 반: " + (this.classNumber!= 0 ? this.classNumber:"미정") +", 번호: " + (this.number!=0 ? this.grade:"미정") +")";
	}
	
}//Student
