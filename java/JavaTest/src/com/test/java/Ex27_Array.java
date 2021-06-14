package com.test.java;

public class Ex27_Array {

	public static void main(String[] args) {
		
		m1();
		
	}//main

	private static void m1() {

		//배열의 업무(용도)에 맞는 사용법
		//책상 > 상자 x 3개
		
		//기본 사용법
		//1. 방을 순차적으로 접근
		//2. 원하는 방을 선택해서 접근
		
		int[] num = new int[] {2, 6, 7, 5, 8, 10, 1, 3, 4, 9};
		
		//1. 차례대로 접근
		for(int i=0; i<num.length; i++) {
			System.out.println(num[i]);
		}
		
		for(int n : num) {
			System.out.println(n);
		}
		System.out.println();
		
		System.out.println(num[5]);
		num[5] = 1000;
		System.out.println(num[5]);
		
		//다른 사용법
		
		int[] list = new int[10];
		
		output(list);
		
		add(list,10); //list에 비어있는 방 중 가장 처음 방에 10을 넣어주세요.
		
		output(list);
		
		add(list,20);
		add(list,30);
		add(list,40);
		
		output(list);
		
		add(list,50);
		add(list,60);
		add(list,70);
		add(list,80);
		
		output(list);
		
		insert(list, 3, 90);
		
		output(list);
		
		delete(list,5);
		
		output(list);
				
		
	}

	private static void delete(int[] list, int index) {
		
		//좌측 시프트
		for(int i = index; i<=list.length-2; i++) {
			list[i] = list[i+1];
		}
	
	}//delete

	private static void insert(int[] list, int index, int n) {
		
		//우측 시프트
		for(int i = list.length-2; i >= index; i--) {
			list[i+1] = list[i];
		}
		list[index] = n;
		
	}//insert

	private static void add(int[] list, int n) {
			
		//가장 앞에 있는 빈방이 어딘지?
		int index = -1;
		
		for(int i=0; i<list.length; i++) {
			if(list[i]==0) {
				index = i;
				break;
			}
		}
		list[index] = n; //빈방에 숫자 채워넣기
		
	}//add

	private static void output(int[] list) {
		
		for(int i =0; i<list.length; i++) {
			System.out.printf("%d ",list[i]);
		}
		System.out.println();
		
	}//output
	
}//Ex27_Array
