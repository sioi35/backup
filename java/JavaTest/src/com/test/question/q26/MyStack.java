package com.test.question.q26;

import java.util.Arrays;

public class MyStack {

	private String[] list;
	private int index;
	
	public MyStack() {
		this.list = new String[4];
		this.index = 0;
	}// 기본 생성자
	
	
	public void push(String value) {
		doubling();
		this.list[this.index] = value;
		this.index++;
		
	}//push
	
	
	private void doubling() {

		if(this.index >= this.list.length) {
			
			String[] temp = new String[this.list.length * 2];
			
			//깊은 복사
			for(int i=0; i<this.list.length; i++) {
				temp[i] = this.list[i]; //요소 복사
			}
			this.list = temp; //배열 교체
			
		}
		
	} //doubling 방 크기 증가


	public int size() {
		return this.index;
	}//size
	
	
	public String pop() { // 요소 읽기 + 삭제
		
		if(this.index == 0) {
			return null; //꺼낼 요소가 없으면 null반환
		}
					
		this.index--;  
		return this.list[this.index]; // 제일 마지막으로 들어간 요소부터 꺼내진다
		
	}//pop

	
	public String peek() { //첫번째로 꺼내질 요소 확인
		if(this.index == 0) {
			return "방이 비어있습니다.";
		}
		return this.list[this.index-1];
	}//peek
	
	public void clear() { //배열 초기화
		this.index = 0;
	}//clear
	
	
	public void trimToSize() {// 길어진 배열을 데이터 갯수만큼으로 줄이기
			
		//현재 길이 -> size
		String[] temp = new String[this.index];// 현재 데이터 갯수만큼의 길이를 가지는 배열
			
		for(int i=0; i<temp.length; i++) {
			temp[i] = this.list[i];
		}
			
		this.list = temp; //짧은 배열로 바꾸기
			
	}//trimToSize
	
	
	@Override
	public String toString() {
		return String.format("length: %d\nindex: %d\n%s\n"
									, this.list.length
									, this.index
									, Arrays.toString(this.list));
	}//정보 제공
	
	
}//MyStack
