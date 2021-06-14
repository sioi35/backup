package com.test.question.q28;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Q004 {
	
	private static Scanner scan;
	private final static String DATA;

	static {
		scan = new Scanner(System.in);
		DATA = "C:\\Users\\sioi3\\Desktop\\Downloads\\파일_입출력_문제\\단일검색.dat";
	}

	public static void main(String[] args) {
		
		try {

			BufferedReader reader = new BufferedReader(new FileReader(DATA));

			System.out.print("이름: ");
			String name = scan.nextLine();
			String line = "";

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");
			
				if (temp[1].equals(name)) {
					System.out.printf("[%s]\n", temp[1]);
					System.out.printf("번호: %s\n", temp[0]);
					System.out.printf("주소: %s\n", temp[2]);
					System.out.printf("전화: %s\n", temp[3]);
					break;
				}else {
					System.out.println("해당 이름이 없습니다.");
					break;
				}
				
			} // while
			System.out.println("종료");
				
			reader.close();
			
		} catch (Exception e) {
			System.out.println("load: " + e);
		}
		
	}//main
	
}//Q004
