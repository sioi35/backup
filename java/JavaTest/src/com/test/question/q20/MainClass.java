package com.test.question.q20;

import java.util.Calendar;

public class MainClass {
	
	public static void main(String[] args) {
		
		Bugles snack = new Bugles();
		snack.setSize(500);
		
		Calendar c = Calendar.getInstance();
		c.set(2021, 4-1, 13);		
		snack.setCreationTime(c);
		
		System.out.println("가격: " +snack.getPrice() + "원");
		System.out.printf("유통기한이 %d일 남았습니다.\n",snack.getExpiration());
		snack.eat();
		
		// 사이즈 잘못입력했을 때
		Bugles snack2 = new Bugles();
		snack2.setSize(900);  
		
		c.set(2021, 4-1, 1);		
		snack2.setCreationTime(c);
		
		System.out.println("가격: " +snack2.getPrice() + "원");
		System.out.printf("유통기한이 %d일 남았습니다.\n",snack2.getExpiration());
		snack2.eat();
		
		
		Bugles snack3 = new Bugles();
		snack3.setSize(300);
		
		
		c.set(2021, 4-1, 1);		
		snack3.setCreationTime(c);
		
		System.out.println("가격: " +snack3.getPrice() + "원");
		System.out.printf("유통기한이 %d일 남았습니다.\n",snack3.getExpiration());
		snack3.eat();
		
	}//main
	
}//MainClass
