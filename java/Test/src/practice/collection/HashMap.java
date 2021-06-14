package practice.collection;

import java.util.Arrays;


public class HashMap {
	
	public static void main(String[] args) {
		
		MyHashMap map = new MyHashMap();
		
		//추가
		map.put("국어", "합격");
		map.put("영어", "불합격");
		map.put("수학", "보류");
		map.put("사회", "불합격");
		map.put("과학", "보류");

		//읽기
		System.out.println(map.get("국어"));
		System.out.println(map.get("영어"));
		System.out.println(map.get("수학"));
		
		//개수
		System.out.println(map.size());
		
		//수정
		map.put("영어", "합격");
		System.out.println("영어");
		
		//삭제
		map.remove("영어");
		System.out.println(map.get("영어"));
		System.out.println(map);

		//검색(key)
		if(map.containsKey("국어")) {
			System.out.println("국어 점수 있음");
		}else {
			System.out.println("국어 점수 없음");
		}
		
		//검색(value)
		if(map.containsValue("합격")) {
			System.out.println("합격 과목 있음");
		}else {
			System.out.println("합격 과목 없음");
		}
		
		//초기화
		map.clear();
		System.out.println(map.size());
		
	}//main
	
}//HashMap


class MyHashMap{
	
	private Entry[] list;
	private int index;
	
	public MyHashMap() {  //기본 생성자
	      this.list = new Entry[4];
	      this.index = 0;
	}


	public void put(String key, String value) {
		
		//1. 방 있는지
		doubling();
		
		
		//2. 값 넣기 - 추가 or 수정
		if(!containsKey(key)) {
			
			Entry e = new Entry();
			e.key = key;
			e.value = value;
			
			this.list[this.index] = e;
			this.index++;
			
		}else {
			// 항목 수정
			// 동일한 값이 들어있는 index 찾아서 수정
			this.list[getIndex(key)].value = value;
			
		}
		
	}//put
	
	
	public String get(String key) {
		int index = getIndex(key);
		return index > -1 ? this.list[index].value : null;
	}//get

	private int getIndex(String key) {
		for(int i=0; i<this.index; i++) {
			if(this.list[i].key.equals(key)) {
				return i;
			}
		}
		return -1;
	}//getIndex
	
	private void doubling() {  // 빈방 없을 때 방 크기 두배로

		if(this.index >= this.list.length) {
			
			Entry[] temp = new Entry[this.list.length * 2];
			
			//값 복사(깊은 복사)
			for(int i=0; i<this.list.length; i++) {
				temp[i] = this.list[i];
			}
			this.list = temp;
		}
	}//doubling

	public int size() {
		return this.index;
	}//size
	
	
	public void remove(String key) {
		if(getIndex(key) > -1) {
			this.list[getIndex(key)].value = null;
			this.index--;
		}
		
	}//remove
	
	public void clear() {
		this.index = 0;
	}
	
	public boolean containsKey(String key) {
		
		for(int i=0; i<this.index; i++) {
			if(this.list[i].key == key) {
				return true;
			}
		}
		return false;		
	}
	
	public boolean containsValue(String value) {
		
		for(int i=0; i<this.index; i++) {
			if(this.list[i].value == value) {
				return true;
			}
		}
		return false;		
	}
	
	
	@Override
	public String toString() {
		
		return String.format("lenth: %d\nindex: %d\n%s"
								, this.list.length
								, this.index
								, Arrays.toString(this.list));
	}//toString
	
	
}//MyHashMap

class Entry{
	
	public String key;
	public String value;
	
	@Override
	public String toString() {
		
		return String.format("(%s, %s)", this.key, this.value);
		
	}
	
}//Entry

