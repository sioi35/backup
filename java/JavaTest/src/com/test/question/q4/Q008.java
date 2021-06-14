package com.test.question.q4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q008 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in ));
		
		System.out.print("맑은 날: ");
		int sun = Integer.parseInt(reader.readLine());
		
		System.out.print("흐린 날: ");
		int rain = Integer.parseInt(reader.readLine());
		
		System.out.printf("사과가 총 %d개 열렸습니다", getApple(sun,rain));
		
		
	}//main
	
	public static int getApple(int sun, int rain) {
		int tree = sun * 5 + rain *2;
		int apple = 0;
		
		apple = (tree-100)/10 + 1 ; 
		
		return apple;
	}
}//Q008
