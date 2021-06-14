package com.test.question.q27;

import java.io.File;
import java.util.HashMap;
import java.util.Set;

public class Q005 {

	public static void main(String[] args) {
		
		String path = "C:\\027_파일_디렉토리\\파일_디렉토리_문제\\확장자별 카운트";
		
		File dir = new File(path);
		File[] list = dir.listFiles();
		
		
		HashMap<String, Integer> count = new HashMap<String, Integer>();
		
		for(File file : list) {
			
			String ext = file.getName().substring(file.getName().lastIndexOf(".")+1);
			
			if(count.containsKey(ext)) {
				count.put(ext, count.get(ext) + 1);  //count = count + 1
			}else {
				count.put(ext, 1);
			}
			
		} 
		
		//HashMap -> 루프
		Set<String> keys = count.keySet();
		
		for(String key : keys) {
			System.out.printf("%s: %d개\n", key, count.get(key));
		}
		
	}//main
	
}//Q005
