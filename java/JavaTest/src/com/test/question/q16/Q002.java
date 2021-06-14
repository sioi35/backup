package com.test.question.q16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q002 {
	//4,4 ~0,0거꾸로 접근

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("테이블의 행 갯수: ");
		int row = Integer.parseInt(reader.readLine());
		System.out.print("테이블의 열 갯수: ");
		int column = Integer.parseInt(reader.readLine());
		
		int[][] list = new int[row][column];
		
		int n=1;
		
		for(int i=list.length-1; i>=0; i--) {
			for(int j=list[0].length-1; j>=0; j--) {
				list[i][j]= n;
				n++;
			}
			
		}
		output(list);
		System.out.println();
		
		n=row*column;
		for(int i=0; i<list.length; i++) {
			for(int j=0; j<list[0].length; j++) {
				list[i][j] = n;
				n--;
			}
		}
		output(list);
		
	}//main
	
	private static void output(int[][] list) {

		for(int i = 0; i<list.length; i++) {
			for(int j=0; j<list[0].length; j++) {
				System.out.printf("%3d",list[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}//output
	
}//Q002
