package com.test.question.q15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q007 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
				
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("삽입 위치: ");
		int index = Integer.parseInt(reader.readLine());
		
		System.out.print("값: ");
		int num = Integer.parseInt(reader.readLine());
		
		int[] list = new int[10];

		for(int i=0; i<list.length; i++) {
			list[i] = (int)(Math.random()*9 + 1);
		}
		output(list);
		
		add(list, index, num);
		
		output(list);
	
		
	}//main

	private static void add(int[] list, int index, int num) {
		
		for(int i =list.length-2; i>=index; i--) {
			list[i+1] = list[i];
		}
		list[index]= num;		
	}
	
	public static void output(int[] list) {
		
		for(int i =0; i<list.length; i++) {
			if(i==list.length-1) {
				System.out.print(list[i] + " ");
			}else {
				System.out.print(list[i] + ", ");	
			}
		}
		System.out.println();
		
	}
	
}//Q007
