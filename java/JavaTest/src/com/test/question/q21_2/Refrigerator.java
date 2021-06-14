package com.test.question.q21_2;

public class Refrigerator {
	
	Item[] items = new Item[100];
	
	private int count = 0;
	
	//Item을 냉장고에 넣는다
	public void add(Item item) {
		items[count] = new Item();
		items[count].setName(item.getName()); //item이름 받아와서 item[] 인덱스 count에 저장.
		
		items[count].setExpiration(item.getExpiration());
		
		System.out.printf("'%s'를 냉장고에 넣었습니다.\n", item.getName());
		
		this.count++;
	}
	
	//Item 을 냉장고에서 꺼낸다.
	public Item get(String name) {
		Item item = new Item();
		
		for(int i = 0; i< count; i++) {
			if(items[i].getName().equals(name)) {
					item = items[i];
				for(int j = i; j <items.length; j++) {
					items[i] = items[i + 1]; // 삭제된값 위에 덮어씌우기 
				}
				this.count--;
			}
		}
		return item;
	}
	
	//냉장고에 있는 Item을 확인한다.
	public void listItem() {

		for (int i = 0; i < this.count; i++) {
			System.out.printf("%s(%s)\n", items[i].getName(), items[i].getExpiration());
		}
		
	}

	public int count() {
		return this.count;
	}
	
}//Refrigerator

