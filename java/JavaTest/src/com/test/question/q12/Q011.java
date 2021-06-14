package com.test.question.q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q011 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("최대 숫자(3자리까지만): ");
		int maxNum = Integer.parseInt(reader.readLine());
		if(maxNum>100) {
			System.out.println("잘못 입력했습니다.");
		}
		for(int i = 1; i< maxNum; i ++) {
			if(i % 3 == 0 || (i>=30 && i<40) || (i>=60 && i<70) || (i>=90 && i<100) ) {
				System.out.print("짝 ");
			}else{
				System.out.printf("%d ", i);
			}
		}
		
	}//main
	
}//Q011
