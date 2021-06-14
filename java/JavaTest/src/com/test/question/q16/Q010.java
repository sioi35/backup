package com.test.question.q16;

public class Q010 {

	public static void main(String[] args) {
		
		//마방진.. 
		//1. 아무위치에 1넣기
		//2. 대각선 방향 정하기
		//3. 
		
		int[][] list = new int[3][3];
		int n = 1;
		
		int i=0; int j=0;
		list[0][0] = n;
		
		
		while(n < 10) {
			if(list[i][j]!=0) {
				list[i--][j++]= n;
				//if(i--)
			}
		}
		
		
		
		
		
		
	}//main
	
}//Q010
