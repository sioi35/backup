package com.test.question.q15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q008 {

public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("삭제 위치: ");
		int index = Integer.parseInt(reader.readLine());
		
		int[] list = new int[10];
	
		for(int i=0; i<list.length; i++) {
			list[i] = (int)(Math.random()*59 + 1);
		}
		
		output(list);
		
		delete(list, index);
		
		output(list);
	
		
	}//main

	
	private static void delete(int[] list, int index) {
	
		//좌측 시프트 
		//삭제하고자 하는 배열 뒤에서부터 시작하여 한칸 앞으로 갚을 복사해야 손실되는 값이 없음!
		for(int i= index; i<list.length-1; i++) { 
			list[i]=list[i+1];
		}
		
	}//delete

	public static void output(int[] list) {
		
		for(int i =0; i<list.length; i++) {
			if(i==list.length-1) {
				System.out.print(list[i] + " ");
			}else {
				System.out.print(list[i] + ", ");	
			}
		}
		System.out.println();
		
	}//output
	
}//Q008
