package com.test.java.obj;

public class Ex36_Class {
	
	public static void main(String[] args) {
		
		// 1. 값형(원시형) 배열
		// 2. 참조형 배열
		
		int[] num = new int[3];
		num[0] = 10;
		num[1] = 20;
		num[2] = 30;
		
		for(int n : num) {
			System.out.println(n);
		}
		
		
		Item item1 = null;
		Item item2 = new Item();
		Item item3;
		
		//초기화하지 않은 지역변수는 사용이 불가능하다.
		//java.lang.NullPointerException or NullReferenceException or 널참조
		//item1.setColor("노랑");
		//System.out.println(item1.getColor());

		//Item 방을 만들려면
		// -> Item item;
		
		// Item 객체(붕어빵)을 만들려면
		// -> new Item()
		
		Item[] items = new Item[3]; //Item x 3개
		
		items[0] = new Item(); // Item item1 = new Item(); 동일
		items[1] = new Item();
		items[2] = new Item();
		
		//java.lang.NullPointerException 
		// - 모든 예외 Top 1.
		items[0].setName("키보드");
		items[0].setColor("검정");
		items[0].setPrice(50000);
		
		System.out.println(items[0].getName());
		System.out.println(items[0].getColor());
		System.out.println(items[0].getPrice());
		
	}//main

}//Ex36_Class


class Item{
	
	private String name;
	private String color;
	private int price;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}