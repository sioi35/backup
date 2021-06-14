package com.test.question.q27;

import java.io.File;

public class Q004 {

	public static void main(String[] args) {
		
		String path = "C:\\027_파일_디렉토리\\파일_디렉토리_문제\\음악 파일\\Music";
		File dir = new File(path);

		if(dir.exists()) {
			
			File[] list = dir.listFiles(); // 사용 빈도 높음
			
			int i=1;
			//출력 -> 탐색기처럼 출력
			for(File sub : list) {
				if(sub.isFile()) {
					String path2 = String.format("%s\\[%03d]%s",path, i,sub.getName());
					File dir2 = new File(path2);
					
					System.out.println(sub.renameTo(dir2));
					System.out.println(dir2.getName());
					i++;
				}
			}
		}//if
		
	}//main
	
}//Q004