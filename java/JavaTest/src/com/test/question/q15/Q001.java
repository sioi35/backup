package com.test.question.q15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q001 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = new int[5];
		int i=0;
		
		for(i =0; i< 5; i++) {
			System.out.print("숫자: ");
			nums[i] = Integer.parseInt(reader.readLine());
		}
		
		for(i=nums.length-1; i>=0; i--) {
			System.out.printf("nums[%d] = [%d]\n", i, nums[i]);
		}
		
	}//main
	
}//Q001
