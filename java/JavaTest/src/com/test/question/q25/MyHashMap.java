package com.test.question.q25;

public class MyHashMap {
	
	//Case A. 
	private String[] keys; //키를 담을 배열
	private String[] values; // 값을 담을 배열
	private int index; // **여전히 중요, 역할 동일
	
	public MyHashMap() {
		this.keys = new String[4];
		this.values = new String[4];
		this.index = 0;
	}
	
	public void put(String key, String value) {
		
		doubling();  // 값을 넣어줄 방이 남아있는지 확인
				
		for(int i = 0; ; i++) {
			 // index가 0일 경우와 포문을 다 돌아 검사하였는데 동일한 값이 없을 경우 값 추가
			if(this.index == 0 || i == this.index-1) { 
				this.keys[this.index] = key;
				this.values[this.index] = value;
				this.index++;
				break;
			}else if(this.keys[i] == key) {  //배열에 동일한 값이 들어있을때
				this.values[i] = value;  //덮어쓰기
				break;
			}
		}
			
		
	}//put
	
	private void doubling() {
		
		if(this.index >= this.keys.length) {
			
			String[] tempK = new String[this.keys.length * 2];
			String[] tempV = new String[this.values.length * 2];
			
			//깊은 복사(짧은 배열 길이만큼 반복) //주소복사X, 방끼리 복사O
			for(int i=0; i<this.keys.length; i++) {
				tempK[i] = this.keys[i]; //원래 배열의 방 -> 2배 배열의 방 -> 1:1 복사
				tempV[i] = this.values[i];
			}
			this.keys = tempK; //배열 교체
			this.values = tempV;
		}
	}
	

	public String get(String key) {
		
		for(int i=0; i<this.index; i++) {
			if(this.keys[i].equals(key)) {
				return this.values[i];
			}
		}
		throw new IndexOutOfBoundsException();
		
	}//get
	
	
	public int size() {
		return this.index;
	}//size
	

	public void remove(String key) {
		
		for(int i=0; i<this.index; i++) {
			if(this.keys[i] == key) {
				this.values[i] = null;
				this.index--;
			}
		}
		
	}//remove
	
	
	public boolean containKey(String key) {
		
		for(int i=0; i<this.index; i++) {
			if(this.keys[i] == key) {
				return true;
			}
		}
		return false;
	}
	
	
	public boolean containValue(String value) {

		for(int i=0; i<this.index; i++) {
			if(this.values[i] == value) {
				return true;
			}
		}
		return false;
	}
	
	
	public void clear() {
		this.index = 0;
	}
	
	
	@Override
	public String toString() {
		
		
		return String.format("key_length: %d\nvalue_length: %d\nindex: %d\n" 
									,this.keys.length //실제 내부 배열의 길이
									,this.values.length 
									,this.index);

	}
	
}//MyHashMap
