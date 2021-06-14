package com.test.java.collection;

import java.util.Arrays;

public class Ex68_Queue {

	public static void main(String[] args) {
		
		MyQueue queue = new MyQueue();
		System.out.println(queue);
		
		queue.add("빨강");
		queue.add("파랑");
		queue.add("노랑");
		queue.add("검정");
		System.out.println(queue);

		System.out.println(queue.poll());
		System.out.println(queue);
		
		System.out.println(queue.size());
		
		System.out.println(queue.peek());
		
		queue.clear();
		System.out.println(queue);
		
		
	}//main
	
}//Ex68_Queue

class MyQueue{
	
	private String[] list;
	private int index;
	
	public MyQueue() {
		this.list = new String[4];
		this.index = 0;
	}//기본 생성자
	
	
	public void add(String value) {
		
		doubling();
		
		this.list[this.index] = value;
		this.index++;
		
	}//add
	
	private void doubling() {

		if(this.index >= this.list.length) {
			
			String[] temp = new String[this.list.length * 2];
			
			//깊은 복사(짧은 배열 길이만큼 반복) //주소복사X, 방끼리 복사O
			for(int i=0; i<this.list.length; i++) {
				temp[i] = this.list[i]; //원래 배열의 방 -> 2배 배열의 방 -> 1:1 복사
			}
			this.list = temp; //배열 교체
			
		}
		
	}
	
	public String poll() {
		
		//1. 가독성 좋음
		// 부정 전처리 - 잘못된 상황을 먼저 발견해서 업무 중지
		//예외 블럭
		if(this.index == 0) {
			return null;
		}
		
		//업무 블럭
		String temp = this.list[0]; // 첫번째 공 꺼낼 공 !
		
		// 좌측 시프트
		for(int i=0; i<this.index-1; i++) {
			this.list[i] = this.list[i+1];
		}
		this.index--;
		
		return temp;
		
		//2. 가독성 떨어짐. 
//		if(this.index != 0) {
//			//업무 블럭
//			
//			String temp = this.list[0]; // 첫번째 공 꺼낼 공 !
//			
//			// 좌측 시프트
//			for(int i=0; i<this.index-1; i++) {
//				this.list[i] = this.list[i+1];
//			}
//			this.index--;
//			
//			return temp;
//		}else {
//			//예외 블럭
//			return null;
//		}
		
	}//poll 요소 꺼내기
	
	public int size() {
		return this.index;
	}//size
	
	public String peek() {
		return this.list[0];
	}//peek
	
	public void clear() {
		this.index = 0;
	}//clear
	
	
	@Override
	public String toString() {
		
		return String.format("length: %d\nindex: %d\n%s\n"
									,this.list.length
									,this.index
									,Arrays.toString(this.list));
	}//정보 제공
	
}//MyQueue