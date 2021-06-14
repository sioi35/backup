package com.test.question.q16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q006 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//5x5배열만들어서 넣기. 포문 회색먼저 돌때 줄의 합을 초록색 칸에 .2중포문
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("테이블의 행 갯수: ");
		int row = Integer.parseInt(reader.readLine());
		System.out.print("테이블의 열 갯수: ");
		int column = Integer.parseInt(reader.readLine());
		
		int[][] list = new int[row][column];

		int n=1;
		int total=0;
		for(int i=0; i<list.length; i++) {
			int Rsum=0;
			
			for(int j=0; j<list[0].length; j++) {
				
				if(j==list[0].length-1 && i==list.length-1) { // 열과 행 둘 다 마지막자리일때 
					list[i][j]= total;
				}
				else if(j==list[0].length-1) { // [i,4] <= [i,0]~[i,3]의 합을 넣어줌
					list[i][j]= Rsum;
					total+=Rsum;
				}
				else if(i==list.length-1) { // [4,j] <= [0,j]~[3,j]의 합을 넣어줌
					int Csum=0;
					for(int k=0; k<list.length; k++) {
						Csum+=list[k][j];
					}
					list[i][j]=Csum;
				}
				else {// 행과 열 모두 마지막 자리가 아니면 1부터 순차적으로 넣어줌
					list[i][j] = n;
					Rsum+=n;
					n++;					
				}
				
			}//소회전 for문 // 열
			
		}//대회전 for문 //행
		
		
		/*
		int[][] list = new int[row][column];
		
		int n=1;
		
		for(int i=0; i<list.length-1; i++) {
			
			for(int j=0; j<list[0].length-1; j++) {
				
				list[i][j] = n;
				list[i][list[0].length-1] += n;
				list[list.length-1][j] += n;
				list[list.length-1][list[0].length-1] += n;
				n++;
				
			}//소회전for문 
			
		}//대회전for문 
		
		*/
			
		output(list);
		
	}//main
	
	private static void output(int[][] list) {

		for(int i = 0; i<list.length; i++) {
			for(int j=0; j<list[0].length; j++) {
				System.out.printf("%4d",list[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}//output
	
}//Q006