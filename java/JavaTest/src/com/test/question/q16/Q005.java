package com.test.question.q16;

import java.io.IOException;

public class Q005 {

	//위아래 두번에 나눠서 출력
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int[][] num = new int[5][5];
		
		int n=1;

		 for(int i=0; i<num.length/2+1; i++) {
		       for(int j=num.length/2-i; j<=i+num.length/2; j++) {
		          num[i][j] = n;
		          n++;
		       }
		 }
		 
		 for(int i=num.length/2+1; i<num.length; i++) {
		       for(int j=i-num.length/2; j<=num.length+ 1-i; j++) {
		          num[i][j] = n;
		          n++;
		       }
		  }
		    
		output(num);
		
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
	
}//Q005
