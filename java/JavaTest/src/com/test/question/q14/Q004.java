package com.test.question.q14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q004 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int dot = 0;
		int gif = 0;
		int jpg = 0;
		int png = 0;
		int hwp = 0;
		int doc = 0;
		
		String ext;
		
		for(int i= 0; i<10; i++) {
			System.out.println("파일명");
			String fileName= reader.readLine();
			
			for(int j= 0 ; j<fileName.length(); j++) {
				
				dot = fileName.lastIndexOf(".");/// '.'이 있는 인덱스 값을 dot에 저장
				
				ext =fileName.substring(dot+1, fileName.length());  // .을 제외한 확장자명만 저장
				
				if(ext.equals("gif") == true) { // 확장자명 비교
					gif++;
					break;
				}else if(ext.equals("jpg") == true){
					jpg++;
					break;
				}else if(ext.equals("png") == true) {
					png++;
					break;
				}else if(ext.equals("hwp") == true){
					hwp++;
					break;
				}else if(ext.equals("doc") == true) {
					doc++;
					break;
				}else {
					System.out.println("알 수 없는 확장자가 있습니다.");
					break;
				}
				
			}
				
		}//for문
		
		System.out.printf("gif: %d\n", gif);
		System.out.printf("jpg: %d\n", jpg);
		System.out.printf("png: %d\n", png);
		System.out.printf("hwp: %d\n", hwp);
		System.out.printf("doc: %d\n", doc);
		
	}//main
	
}//Q004

