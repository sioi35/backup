package com.test.question.q15;

public class Q004 {

	public static void main(String[] args) {
		
		int[] list = new int[20];
		int max = 0; 
		int min = 0;
		
		for(int i =0; i<list.length; i++) {
			list[i]= (int)(Math.random()*20 + 1);
			
		}
		
		max = list[0];
		for(int i =1; i<list.length; i++) {
			if(max <= list[i]) {
				max = list[i];
			}
		}
		
		min = list[0];
		for(int i =1; i<list.length; i++) {
			if(min >= list[i]) {
				min = list[i];
			}
		}
		
		System.out.print("원본: ");
		for(int i =0; i<list.length; i++) {
			if(i==list.length-1) {
				System.out.print(list[i] + " ");
			}else {
				System.out.print(list[i] + ", ");	
			}
		}
		System.out.println();
		System.out.println();
		System.out.printf("최대값: %d\n", max);
		System.out.printf("최소값: %d\n", min);
		
	}//main
	
	
}//Q004
