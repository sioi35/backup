package com.test.question.q27;

import java.io.File;
import java.util.Arrays;
import java.util.Calendar;

public class Q010 {

	public static void main(String[] args) {
		
		//요구사항] 회원 > 회원별 개인 폴더 작성하기

		//폴더 생성
		String path = "C:\\027_파일_디렉토리\\파일_디렉토리_문제\\직원"; //희망하는 폴더의 경로
		File dir = new File(path);
		File[] list = dir.listFiles();
		
		for(File file : list) {
			if(file.isFile()) {
				
				//아무게_2014__17.txt
				String[] temp = getName(file.getName());
				System.out.println(Arrays.toString(temp));
				
				File subDir = new File(path + "\\" + temp[0] + "\\" + temp[1]);
				subDir.mkdirs();
				
				//파일 이동
				file.renameTo(new File(subDir.getAbsoluteFile() + "\\" + file.getName()));
			}
		}	
		System.out.println("완료");
		
	}//main
	
	private static String[] getName(String name) {
		
		//아무게_2014__17.txt
		String[] temp = new String[2];
		
		int index = name.indexOf("_");
		temp[0] = name.substring(0, index);
		
		int index2 = name.indexOf("_", index + 1);
		temp[1] = name.substring(index+1, index2);
		
		return temp;
		
	}//getName
	
}//Q010
