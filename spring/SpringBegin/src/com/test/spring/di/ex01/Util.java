package com.test.spring.di.ex01;

import java.util.Scanner;

public class Util {

	public String getName() {
		
		
		//**** Util은 Scanner를 의존한다.
		//**** Scanner는 Util의 의존객체라고 부른다.
		
		//**** Util은 PrintStream을 의존한다.(인식X)
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름: ");
		
		String name = scan.nextLine();
		
		return name;
		
	}
	
}
