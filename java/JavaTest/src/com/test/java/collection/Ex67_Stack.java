package com.test.java.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex67_Stack {

	public static void main(String[] args) {
		
		/*
		
		Stack, Queue
		
		Queue, 큐
		- 선입선출
		- FIFO, First Input First Output
		
		
		Stack, 스택
		- 후입선출
		- LIFO, Last Input First Output
		- 메모리 영역, 히스토리
		
		*/

		//m1();
		m2();
		
	}//main

	private static void m2() {

		// 큐, Queue
		//		==================== 
		//  ->   노랑 	파랑 	   빨강   ->   
		//		==================== 
		
		//Queue<String> queue = new Queue<String>();  //인터페이스 > 객체를 못 만든다.
		Queue<String> queue = new LinkedList<String>();
		
		// 요소 추가
		// - Enqueue
		queue.add("빨강");
		queue.add("파랑");
		queue.add("노랑");
		
		// 요소 개수
		System.out.println(queue.size());
		
		// 요소 읽기(+삭제)
		// -Dequeue
		System.out.println(queue.poll());
		System.out.println(queue.size());
		
		System.out.println(queue.poll());
		System.out.println(queue.size());
		
		System.out.println(queue.poll());
		System.out.println(queue.size());
		
		queue.add("빨강");
		queue.add("파랑");
		queue.add("노랑");
		
		System.out.println(queue.peek());  //빨강 - 꺼낼 수 있는 첫번째 공을 꺼내지 않고 확인만.
		
		// 루프
		while(queue.size() > 0) {
			System.out.println(queue.poll());
		}
		
		
	}//m2 - queue

	private static void m1() {

		// 스택, Stack
		//		==================== 
		// <->    노랑	파랑 	  빨강  || 
		//		==================== 
		
		
		Stack<String> stack = new Stack<String>();  //클래스
		
		// 요소 추가
		stack.push("빨강");
		stack.push("파랑");
		stack.push("노랑");
		
		// 요소 개수
		System.out.println(stack.size());
		
		// 요소 읽기(+삭제)
//		System.out.println(stack.pop());  //읽기와 동시에 삭제
//		System.out.println(stack.size());
//		
//		System.out.println(stack.pop());
//		System.out.println(stack.size());
//		
//		System.out.println(stack.pop());
//		System.out.println(stack.size());
//		
//		System.out.println(stack.pop());  //EmptyStackException
//		System.out.println(stack.size());
		
		// 루프
//		while(stack.size() > 0) {
//			System.out.println(stack.pop());
//			System.out.println(stack.size());
//		}
		
//		while(!stack.isEmpty()) {
//			System.out.println(stack.pop());
//			System.out.println(stack.size());
//		}
		
		System.out.println(stack.peek()); //노랑 - 꺼낼 수 있는 첫번째 공을 꺼내지 않고 확인만. > 사전 점검
		System.out.println(stack.size());
		
	}//m1-stack
	
}//Ex67_Stack
