package com.test.question.q27;

import java.io.File;
import java.util.ArrayList;

public class Q007 {

	public static void main(String[] args) {
		
		String pathA = "C:\\027_파일_디렉토리\\파일_디렉토리_문제\\동일 파일\\MusicA";
		String pathB = "C:\\027_파일_디렉토리\\파일_디렉토리_문제\\동일 파일\\MusicB";
		
		File dirA = new File(pathA);
		File dirB = new File(pathB);
		
		File[] listA = dirA.listFiles();
		File[] listB = dirB.listFiles();
		
		int count=1;
		System.out.println("<<두 폴더에 모두 존재하는 곡>>");
		for(File nameA: listA) {
			for(File nameB: listB) {
				if(nameA.getName().equals(nameB.getName())) {
					System.out.printf("%d-%s\n",count,nameA.getName());
		            count++;
				}	      
			}
		}
		System.out.println();
				
		System.out.println("<<A폴더에만 존재하는 곡>>");
		count=1;
		for(int i=0; i<listA.length; i++) {
			for(int j=0; j<listB.length; j++) {
				if(listA[i].getName().equals(listB[j].getName())) {
					break;
				}else {
					if(j==listB.length-1) {  // 마지막 인덱스까지 돌았는데 중복되는 곡이 아닐경우만 출력
						System.out.printf("%d-%s\n",count,listA[i].getName());
						count++;
					}
				}

			}
		}
		System.out.println();
		
		
		System.out.println("<<B폴더에만 존재하는 곡>>");
		count=1;
		for(int i=0; i<listB.length; i++) {
			for(int j=0; j<listA.length; j++) {
				if(listB[i].getName().equals(listA[j].getName())) {
					break;
				}else {
					if(j==listA.length-1) { // 마지막 인덱스까지 돌았는데 중복되는 곡이 아닐경우만 출력
						System.out.printf("%d-%s\n",count,listB[i].getName());
						count++;
					}
				}

			}
		}
		System.out.println();
		
	}//main
	
}//Q007
