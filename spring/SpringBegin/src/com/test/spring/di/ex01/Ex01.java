package com.test.spring.di.ex01;

public class Ex01 {
	
	public static void main(String[] args) {
		
		//요구사항] 사용자에게 이름을 입력받아 인사하시오.
		
		//m1.
//		Scanner scan = new Scanner(System.in);
//		System.out.print("이름: ");
//		String name = scan.nextLine();
//		System.out.printf("안녕하세요. %s님\n", name);
		
		
		//m2.
		//Ex01 객체 -> (업무 위임) -> Util 객체
		//*** Ex01은 Util이 없으면 자신의 일을 못한다.
		//***** Ex01은 Util을 의존한다.
		//******* Util을 Ex01의 의존객체(Dependency Object)라고 부른다.(*****) 
		
		
		Util util = new Util();
		String name = util.getName(); //업무 위임(Delegate)
		System.out.printf("안녕하세요. %s님\n", name);
		
		
	}//main
	
}
