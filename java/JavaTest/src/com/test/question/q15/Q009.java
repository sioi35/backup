package com.test.question.q15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q009 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("배열의 길이: ");
		int size = Integer.parseInt(reader.readLine());
		
		int[] list = new int[size];
		int[] result = new int[size/2];
		
		for(int i =0 ; i< list.length; i++) {
			list[i] = (int)(Math.random() * 9 +1);
		}
		
		for(int i = 0; i<result.length; i++) {
			result[i] = list[i+i]+list[i+i+1];
		}
		System.out.print("nums = ");
		output(list);
		System.out.print("reslut = ");
		output(result);
		
	}//main

	public static void output(int[] list) {
		System.out.print("[ ");
		for(int i =0; i<list.length; i++) {
			
			if(i==list.length-1) {
				System.out.print(list[i] + " ");
			}else {
				System.out.print(list[i] + ", ");	
			}
		}
		System.out.print("]");
		System.out.println();
	}//output
	
}//Q009
