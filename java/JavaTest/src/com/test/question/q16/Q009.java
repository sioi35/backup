package com.test.question.q16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q009 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
	// 1~5 J증가, 5~9행증가........같은 색깔마다 한싸이클 방번호 증가.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("테이블의 행 갯수: ");
		int row = Integer.parseInt(reader.readLine());
		System.out.print("테이블의 열 갯수: ");
		int column = Integer.parseInt(reader.readLine());
		
		int[][] list = new int[row][column];

		int n=1;
		
		int i=0, j=0;
		list[i][j]=1;
		n++;
		while(n<= row * column) { 
			
			// 1) 열j증가하면서 다음 index가 0 일때만 실행
			while(j+1<column && list[i][j+1]==0){
				j++;
				list[i][j]=n;
				n++;
			}

			// 2) 행i증가하면서 배열에 0이 들어있는 부분 채우기
			while(i+1<row && list[i+1][j]==0) {
				i++;			
				list[i][j]=n;
				n++;
			}
			
			//3) 열j 감소
			while(j-1>=0 && list[i][j-1]==0){
				j--;
				list[i][j]=n;
				n++;
			}
		
			// 4) 행 i 감소
			while(i-1>=0 && list[i-1][j]==0) {
				i--;
				list[i][j] = n;
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
	
}//Q009
