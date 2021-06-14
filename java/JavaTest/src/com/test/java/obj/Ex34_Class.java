package com.test.java.obj;

import java.util.Calendar;

public class Ex34_Class {

	public static void main(String[] args) {
		
		//Setter, Getter의 목적
		//1. 유효성 검사
		//2. 읽기 전용, 쓰기 전용 멤버 구현
		
		Baby b1 = new Baby();
		
		//읽기/쓰기
		b1.setName("홍길동");
		System.out.println(b1.getName());
		
		//쓰기 전용
		b1.setHeignt(50);
		//System.out.println(b1.getHeight());
		
		//읽기 전용 멤버
		System.out.println(b1.getWeight());
		
		
		//1.
		//부모 -> 엄마, 아빠 따로 작업
		b1.setFather("홍아빠");
		b1.setMother("김엄마");
		System.out.println(b1.getFather());
		System.out.println(b1.getMother());
		
		//2.
		// 부모-> 엄마, 아빠 같이 작업
		String[] parent = new String[] {"홍파더", "김마더"};
		b1.setParent(parent);
		
		b1.setParent(new String[] {"홍파더", "김마더"});		

		
		String[] temp = b1.getParent();
		System.out.println(temp[0] + "," + temp[1]);
		System.out.println(b1.getParent()[0]);
		System.out.println(b1.getParent()[1]);
		
		//3. 
		b1.setFather2("홍가가");
		b1.setMother2("김나나");
		
		System.out.println(b1.getFather2());
		System.out.println(b1.getMother2());
		
		
		//생년월일
		Calendar c = Calendar.getInstance();
		c.set(2021, 0, 14);	
		
		b1.setBirthday(c);
		System.out.printf("%tF\n", b1.getBirthday());
		
		b1.setBirthday2(2021, 1, 20);
		
		System.out.println("나이: "+ b1.getAge());

		// b1.getName() 	-> private String name 반환
		// b1.getWeight() 	-> private int weight 반환
		// b1.getAge()		-> private int age반환 -> 계산된 멤버(가상의 멤버)
		
		
	}//main
	
}//Ex34_Class


class Baby{
	
	// 이름, 키, 몸무게, 부모(아빠, 엄마), 생일
	
	private String name;
	private int height;
	private int weight = 5;
	
	//부모
	private String father;
	private String mother;
	
	private String[] parent = new String[2];
	
	//생일
	private Calendar birthday;
	
	
	//Setter, Getter
	public void setName(String name) {
		//유효성 검사(한글, 글자수 기타 등등..)
		this.name = name;		
	}
	
	public String getName() {
		return this.name;
	}
	
	//Setter, Getter(X)
	public void setHeignt(int height) {
		this.height= height;
	}
	
	//Setter(x), Getter
	public int getWeight() {
		return this.weight;
	}
	
	//Getter
	public int getAge() {
		
		Calendar now = Calendar.getInstance();
		long gap = now.getTimeInMillis() - this.birthday.getTimeInMillis();
		gap =gap/1000/60/60/24/365;
		
		return (int)gap;
	}
	
	public void setFather(String father) {
		this.father = father;
	}
	
	public String getFather() {
		return this.father;
	}
	
	public void setMother(String mother) {
		this.mother = mother;
	}
	
	public String getMother() {
		return this.mother;
	}
	
	public void setParent(String parent[]) {
		//
		this.parent=parent;
	}
	
	public String[] getParent() {
		return this.parent;
	}
	
	public void setFather2(String father) {
		this.parent[0] = father;
	}
	
	public void setMother2(String mother) {
		this.parent[1] = mother;
	}
	
	public String getFather2(){
		return this.parent[0];
	}	
	
	public String getMother2(){
		return this.parent[1];
	}	
	
	
	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}
	
	public Calendar getBirthday(){
		return this.birthday;
	}	
	
	public void setBirthday2(int year, int month, int date) {
		Calendar c = Calendar.getInstance();
		
		c.set(year, month-1, date);
		
		this.birthday = c;
	}
	
}

