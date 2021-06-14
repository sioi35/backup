package com.test.question.q27;

import java.io.File;

public class Q008 {
	private static int fcount = 0;  // 파일 개수
	private static int dcount = 0;  // 폴더 개수
	
	public static void main(String[] args) {
		
		// - 크기 : 711MB (746,154,477 바이트)
		// - 내용: 파일 11,329, 폴더 2,287
		
		String path =  "C:\\027_파일_디렉토리\\파일_디렉토리_문제\\폴더 삭제\\delete";
		File dir = new File(path);
		
		if(dir.exists()) {
			deleteFile(dir);
		}

		System.out.println("폴더를 삭제했습니다.");
		System.out.printf("삭제된 폴더는 %,d개이고, 파일은 %,d개입니다.\n", dcount, fcount);
		
	}//main
	
	
	private static void deleteFile(File dir) {
		
		File[] list = dir.listFiles();
		
		//현재 폴더가 가지는 모든 파일 삭제
		for(File file : list) {
			if(file.isFile()) {
				file.delete();
				fcount++;
			}
		}
		
		//자식 폴더로 들어가서 동일한 일을 반복 -> 재귀
		for(File sub : list) {
			if(sub.isDirectory()) {
				//재귀 호출
				deleteFile(sub);
			}
		}
		
		//현재 폴더에는 아무것도 없다.
		dcount++;
		dir.delete();
	}
	
}//Q008
