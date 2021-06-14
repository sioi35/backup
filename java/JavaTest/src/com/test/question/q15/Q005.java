package com.test.question.q15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q005 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("최대범위: ");
		int max = Integer.parseInt(reader.readLine());
		
		System.out.print("최소범위: ");
		int min = Integer.parseInt(reader.readLine());
		
		int[] list = new int[20];
		int size=0;
		
		for(int i= 0; i<list.length; i++) {
			list[i] = (int)(Math.random()*20 + 1);
			if(list[i]>= min && list[i]<=max) { //난수가 최소~최대 범위에 포함하는 수만큼 result[]배열 크기 확보
				size++;
			}
		}
		
		int[] result = new int[size];
		int j=0;
		for(int i=0; i<list.length; i++) {
			if(list[i]>= min && list[i]<=max) { //범위에 속하는 값만 result[]배열에 넣기
				result[j] = list[i];
				j++;	
			}				
		}
		System.out.print("원본: ");
		output(list);
		
		System.out.print("결과: ");
		output(result);
		
	}//main
	
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
	
}//Q005
