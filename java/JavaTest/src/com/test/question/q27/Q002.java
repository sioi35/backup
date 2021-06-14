package com.test.question.q27;

import java.io.File;
import java.util.Scanner;

public class Q002 {

	public static void main(String[] args) {

		System.out.print("폴더 경로: ");
		Scanner scanner = new Scanner(System.in);
		String path = scanner.nextLine();
		
		File dir = new File(path);
		File[] list = dir.listFiles();
		
		System.out.print("파일 확장자: ");
		String fileExt = scanner.nextLine();
		
		if(dir.exists()) {
			for(File sub : list) {
				int index = sub.getName().lastIndexOf(".");
				String ext = sub.getName().substring(index+1);
				if(fileExt.toLowerCase().equals(ext.toLowerCase())) {
					System.out.printf("[%s]\n", sub.getName());
				}
			}
		}else {
			System.out.println("폴더가 존재하지 않습니다.");
		}
	}//main
	
}//Q002
