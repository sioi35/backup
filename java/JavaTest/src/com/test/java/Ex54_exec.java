package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex54_exec {

	public static void main(String[] args) throws Exception {
		
		// 자바 프로그램에서 외부 프로그램 호출하기
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		while(true) {
			System.out.println("선택: ");
			
			String sel = reader.readLine();
			
			if(sel.equals("1")) {
				Process p1 = new ProcessBuilder("notepad.exe").start();
			}else if(sel.equals("2")) {
				Process p1 = new ProcessBuilder("mspaint.exe").start();
			}else if(sel.equals("3")) {
				//Process p1 = new ProcessBuilder("msedge.exe").start();
			}else if(sel.equals("4")) {
				Process p1 = new ProcessBuilder("explorer.exe").start();
			}else if(sel.equals("5")) {
				Process p1 = new ProcessBuilder("calc.exe").start();
			}
			
			System.out.println("확인");
		}
		*/
		
		//Process p1 = new ProcessBuilder("notepad.exe", "C:\\class\\java\\JavaTest\\src\\com\\test\\java").start();		
		//Process p1 = new ProcessBuilder("explorer.exe", "C:\\class\\java").start();		
		Process p1 = new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe").start();
		
	}//main
	
}//Ex54_exec
