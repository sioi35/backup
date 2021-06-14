package com.test.java.inheritance;

import java.util.Random;

public class MyRandom2 extends Random{ // Random 클래스를 부모로 모든 기능을 상속받는다. 
	
	//nextInt()
	//nextBoolean()

	public int nextTinyInt() {
		Random rnd = new Random();
		
		return rnd.nextInt(10) + 1;
	}
	
	public String nextColor() {
		Random rnd = new Random();
		
		String[] color = {"red", "yellow", "blue", "orange", "green"};
		
		return color[rnd.nextInt(color.length)];
	}
	
}//MyRandom2
