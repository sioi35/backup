package com.test.question.q27;

import java.io.File;

public class Q006 {

	public static void main(String[] args) {
		
		// - 크기 : 711MB (746,154,477 바이트)
		// - 내용: 파일 11,329, 폴더 2,287
		
		String path = "C:\\027_파일_디렉토리\\파일_디렉토리_문제\\파일 제거";
		File dir = new File(path);
		int count =0;
		
		File[] list = dir.listFiles();
		
		for(File sub : list) {
			if(sub.length()==0) {
				count++;
				sub.delete();
			}
			
		}
		System.out.printf("총 %d개의 파일을 삭제하였습니다.\n", count);
		
	}//main
	
}//Q006
