package com.test.question.q16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q007 {

	//막대 그래프 출력 2차원 배열.. 
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[][]score = new String[10][3];
		
		System.out.print("국어 점수: ");
		int kor = Integer.parseInt(reader.readLine());
		
		System.out.print("영어 점수: ");
		int eng = Integer.parseInt(reader.readLine());
		
		System.out.print("수학 점수: ");
		int math = Integer.parseInt(reader.readLine());
		
		for(int i=0; i<10; i++) {
			if(i<kor/10) {
				score[9- i][0]= "■"; 			
			}else {
				score[9-i][0] = " ";
			}
			if(i<eng/10) {
				score[9- i][1]= "■"; 			
			}else {
				score[9-i][1] = " ";
			}
			if(i<math/10) {
				score[9- i][2]= "■"; 			
			}else {
				score[9-i][2] = " ";
			}
		}
		
		output(score);
		
	}//main
	
	private static void output(String[][] list) {
		
		for(int i = 0; i<list.length; i++) {
			for(int j=0; j<list[0].length; j++) {
				System.out.printf("%5s",list[i][j]);
			}
			System.out.println();
		}
		System.out.println("======================= ");
		System.out.println("  국어   영어   수학 ");
		System.out.println();
	}//output
	
}//Q007
