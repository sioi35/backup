package com.test.question.q24;

public class MyArrayList {

	private String[] list;
	private int index; // *** 중요한 역할 (요소가 들어갈 방의 번호)
	
	public MyArrayList() {  //기본 생성자. 초기화
		this.list = new String[4];
		this.index = 0;
	}// 기본 생성자
	
	public void add(String s) {
		
		//방이 남아있는지 체크 ? 
		checkLength();

		this.list[this.index] = s;
		this.index++;
	
	}//add 마지막 배열에 추가
	
	public void add(int index, String value) {

		if (index >= 0 && index < this.index) {
			checkLength();
			for(int i=this.index-1; i>=index; i--) {  //우측 시프트
				this.list[i+1] = this.list[i];
			}
		
			this.list[index] = value;
			this.index++;
		}else {
			throw new IndexOutOfBoundsException();
		}
		
		
	}//add 원하는 index에 insert 모드로 추가 
	
	private void checkLength() {  // 삽입할 방이 남아있는지!  -> 요소 삽입할때마다 검사해야하니까 메서드로 따로 분리.
		
		if(this.index >= this.list.length) {  // 삽입할위치(this.index)가 배열의 길이보다 클때 > 방이 꽉찼을경우
			// 1. 2배 길이의 배열 만든다.
			// 2. 기존 배열의 각 방의 값을 새 배열에 복사한다.
			// 3. 새 배열을 this.list에 넣는다.
			
			String[] temp = new String[this.list.length * 2];  // 배열의 길이를 x2배 늘려줌
			for(int i=0; i< this.list.length; i++) {
				temp[i] = this.list[i];  // 배열 값 복사
			}
			this.list = temp;  // 만든 배열을 this.list에 넣기
		}
		
	}//isEmpty
	
	public String get(int index) {
		
		if(index >= 0 && index < this.index) {
			return this.list[index];
		}else {
			throw new IndexOutOfBoundsException();
		}
		
	}//get 요소 가져오기
	
	public int size() {
		return this.index;
	}//size 배열 사이즈 구하기
	
	public void set(int index, String value) {
		
		if (index >= 0 && index < this.index) {
		
			this.list[index] = value; //수정			

		} else {
			
			throw new IndexOutOfBoundsException();
		}
		
	}//set 요소 수정
	
	public void remove(int index) { // 좌측시프트 
		if(index>=0 && index <this.index) {
			for(int i=index; i <this.index-1; i++) { 
				this.list[i] = this.list[i+1];
			}	
			this.index--; // 배열을 좌측시프트 시킨 후 this.index 줄여주기.// 배열을 하나 삭제 시켰으니까 
		}else {
			throw new IndexOutOfBoundsException();
		}
	}// 요소 삭제
	
	public int indexOf(String value) {
		
		for(int i=0; i<this.index; i++) {
			if(this.list[i].equals(value)) {  // 배열을 0번부터 검사하여 value값이 있는 경우 인덱스를 반환
				return i;
			}	
		}
		return -2;  // 찾는 값이 없는경우 -1이하의 값을 반환.
		
	}//indexOf
	
	
   //lastIndexOf
   public int lastIndexOf(String value) {
      for(int i=this.index -1; i>=0; i--) { //배열의 맨뒤에서부터 찾는다.
         if(this.list[i].equals(value)) {
            return i;
         } 
      }
      return -2;
   }//lastIndexOf
	   
   
   /*
   1. 새배열을 만들어 대입.
   public void clear() {  // 새 배열을 만들어 대입
      String[] newlist = new String[list.length];
      this.list = newlist;
      this.index = 0;
   }
   
	2. 모든 인덱스 값을 remove() 실행
	public void clear() {
		for(int i=this.index; i>0; i--) {
			remove(i);
		}
	}//clear
	
	
    */
  
   public void clear() {

	   this.index = 0;

   }//clear
   
   
   public boolean contains(String value) {
		
		for (int i=0; i<this.index; i++) {
			if (this.list[i].equals(value)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public void trimToSize() {
		System.out.println("원래 배열길이: "+list.length);
		String[] temp = new String[size()];
		
		for (int i=0; i<temp.length; i++) {
			temp[i] = this.list[i];
		}
		
		this.list = temp;//교체				
		System.out.println("삭제 후 배열길이: "+list.length);
	}
	
	
	public boolean isEmpty() {
		
		return this.index == 0 ? true : false;
	}
	
//	//부분 집합 추출
//	public MyArrayList subList(int fromIndex, int toIndex) {
//		
//		MyArrayList temp = new MyArrayList(toIndex - fromIndex);
//		
//		for (int i=fromIndex; i<toIndex; i++) {
//			
//			//temp[i] = this.list[i];
//			//temp.list[i] = this.list[i];
//			temp.add(this.list[i]);
//		}
//		
//		return temp;		
//	}
//   
	
}//MyArrayList
