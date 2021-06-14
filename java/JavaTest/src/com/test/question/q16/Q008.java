package com.test.question.q16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q008 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("테이블의 행(열) 갯수: ");
		int row = Integer.parseInt(reader.readLine());
		
		int[][] list = new int[row][row];
		int n=1;

		 for(int i=0; i<row; i++) {
		     for(int j=0; j<i+1; j++) {
		    	 list[j][i-j]= n;
		    	 n++;
		     }
		 }
	
		 for(int i=row; i<row*2 -1; i++) {
		     for(int j=row-1; j>=i-(row-1); j--) {
		    	 list[i-j][j]= n;
		    	 n++;
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
	
	}//output
	
}//Q005\8
