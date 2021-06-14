package com.test.question.q27;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Q001 {

	public static void main(String[] args) throws IOException {
		
		//경로 C:\class\java\file\test.txt
		System.out.print("파일 경로: ");
		Scanner scan = new Scanner(System.in);
		String path = scan.nextLine();	
		
		int index = path.lastIndexOf(".");
		String ext = path.substring(index+1);  //index+1 ~ 끝까지.
		
		//참조 객체 생성
		File file = new File(path);
		
		System.out.printf("파일명: %s\n",file.getName());
		System.out.printf("종류: %s %s\n",ext, (file.isFile()==true ? "파일": "폴더"));
		System.out.printf("파일 크기: %,dB\n",file.length());	
		System.out.printf("파일 크기 : %,.1fKB\n",(double)file.length()/1024);
		System.out.printf("파일 크기 : %,.1fMB\n",(double)file.length()/1024/1024);
		System.out.printf("파일 크기 : %,.1fGB\n",(double)file.length()/1024/1024/1024);
		System.out.printf("파일 크기 : %,.1fTB\n",(double)file.length()/1024/1024/1024/1024);
		
		
	}//main
	
}//Q001
