package com.test.question.q26;

public class MainClass {

	public static void main(String[] args) {
		
		MyStack stack = new MyStack();
		
		//추가
		System.out.println("<추가>");
		stack.push("빨강");
		stack.push("노랑");
		stack.push("파랑");
		stack.push("주황");
		stack.push("검정");
		System.out.println("개수 : " +stack.size());
		System.out.println(stack);
		
		//읽기
		System.out.println("<읽기>");
		System.out.println(stack.pop());
		System.out.println("개수 : " +stack.size());
		System.out.println(stack.pop());
		System.out.println("개수 : " +stack.size());
		System.out.println(stack.pop());

		//개수
		System.out.println("개수 : " +stack.size());
		System.out.println(stack);
		
		
		//확인
		System.out.println("peek: "+stack.peek());
		System.out.println("peek: "+stack.peek());

		
		//크기 조절
		System.out.println("\n<크기 조절 후> ");
		stack.trimToSize();
		System.out.println(stack);
		
		//초기화
		stack.clear();
		System.out.println(stack.size());
		System.out.println(stack);

	
	}//main
	
}//MainClass
