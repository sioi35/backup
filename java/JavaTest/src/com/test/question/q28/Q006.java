package com.test.question.q28;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;

public class Q006 {
	private final static String DATA;

	static {
		DATA = "C:\\Users\\sioi3\\Desktop\\Downloads\\파일_입출력_문제\\괄호.java";
	}
	
	public static void main(String[] args) {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(DATA));
			Stack<String> stack = new Stack<String>();	
			
			String line= "";
			int startC =0;
			int closeC =0;
			while((line= reader.readLine()) != null) {
				
				
				if(line.contains("(")) {
					stack.push("(");
					startC++;
				}
				if(line.contains(")")) {
					stack.push(")");
					closeC++;
				}
				if(line.contains("{")) {
					stack.push("{");
					startC++;
				}
				if(line.contains("}")) {
					stack.push("}");
					closeC++;
				}

			}
			
			for(int i=0; i<stack.size(); i++) {
				if(stack.get(i).equals("("))
				System.out.println(stack.get(i));
				
			}
			
			
			System.out.printf("start- %d, close%d", startC, closeC);
			
			if(stack.size() %2 != 0) {
				System.out.println("올바르지 않은 소스입니다.");
			}
			
			if(startC != closeC) {
				System.out.println("올바르지 않은 소스입니다.");
				
			}else {
				System.out.println("올바른 소스입니다.");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}//main

}
