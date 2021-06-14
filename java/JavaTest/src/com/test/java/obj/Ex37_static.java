package com.test.java.obj;

public class Ex37_static {

	//클래스 로딩 -> static 할당 -> main() 실행
	public static void main(String[] args) {
		
		// static 키워드
		// - 클래스 멤버에게 붙이는 키워드
		// 1. 멤버변수
		// - 객체 멤버 변수
		// 		- 객체가(개인이) 각각의 자신만의 값을 가져야 하는 경우에 사용한다.
		// - 정적 멤버 변수(static 멤버 변수)
		//		- 객체가 속한 클래스의 모든 객체가 동일한 값을 가져야 하는 경우에 사용한다. 
		
		// 2. 멤버 메소드
		// - 객체 멤버 메소드
		//		- 객체가 (개인이) 하는 행동을 구현하는 경우(-> 개인의 데이터를 사용해서 행동한다.)
		// - 정적 멤버 메소드
		//		- 객체가 하는 행동이 개인의 행동이 아닌 전체를 대변하는 행동을 구현하는 경우
		
		//****
		//1. 개인 정보 -> 객체 변수 저장 -> 객체 메소드로 행동
		//2. 공용 정보 -> 정적 변수 저장 -> 정적 메소드로 행동
		
		
		//static int a = 10; //지역 변수 X
		
		Student.setSchool("역삼 중학교");
		
		
		Student s1 = new Student();
		
		s1.setName("홍길동");
		s1.setAge(15);
		//s1.setSchool("역삼 중학교");
		
		Student s2 = new Student();
		
		s2.setName("아무개");
		s2.setAge(14);
		//s2.setSchool("역삼 중학교");
		
		Student s3 = new Student();
		
		s3.setName("하하하");
		s3.setAge(16);
		//s3.setSchool("역삼 중학교");
		
		//학생 1명 -> 질문
		
		// A. 홍길동이 다니는 학교가 어디니? 
		// B. 홍길동과 같은 학생들이 다니는 학교가 어디니?
		
		System.out.println("이름: " + s1.getName()); //개인정보
		System.out.println("나이: " + s1.getAge()); //개인정보
		//System.out.println("학교: " + s1.getSchool()); //A. 개인 정보 -> *** 다른 사람과 다른 값을 가질 수 있다. 
		System.out.println("학교: " + Student.getSchool());//B.
		System.out.println();
		
		System.out.println("이름: " + s2.getName());
		System.out.println("나이: " + s2.getAge());
		System.out.println("학교: " + Student.getSchool());
		System.out.println();
		
		
		
//		ZZZ z = new ZZZ();
//		z.setNum(10);
//		
//		Glass g = new Glass();
//		g.setPrice(111);
//		System.out.println(g.getPrice());
		
	}//main
	
}//Ex37_static


class Test{
	
	public int a;
	public static int b; //멤버 변수 o
	
	public void aaa(){
		
	}
	public static void bbb(){
		
	}	
}


//학생 클래스
// -> "역삼 중학교"
class Student{
	// Ctrl + Shift + L
	
	private String name;
	private int age;
	
	//private String school;
	private static String school;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public static String getSchool() {
		return school;
	}
	public static void setSchool(String school) {
		Student.school = school;
	}
	
	
//	public String getSchool() {
//		return school;
//	}
//	public void setSchool(String school) {
//		this.school = school;
//	}
	
}//Student
