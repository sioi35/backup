package com.test.java.inheritance;

import java.util.Random;

public class MyRandom {
	
	public int nextInt() { // 구색 갖추기용
		Random rnd = new Random();
		
		return rnd.nextInt();
	}

	public int nextTinyInt() {
		Random rnd = new Random();
		
		return rnd.nextInt(10) + 1;
	}
	
	public String nextColor() {
		Random rnd = new Random();
		
		String[] color = {"red", "yellow", "blue", "orange", "green"};
		
		return color[rnd.nextInt(color.length)];
	}
	
	public boolean nextBoolean() { //구색 갖추기용
		Random rnd = new Random();
		
		return rnd.nextBoolean();	
	}
	
}//MyRandom
