package com.test.java.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class Ex78_TreeSet {

	public static void main(String[] args) {
		
		/*
		
		Map
		- TreeSet
		
		
		
		*/
		
		TreeSet<Integer> set= new TreeSet<Integer>();
		
		set.add(10);
		set.add(20);
		set.add(30);
		set.add(40);
		set.add(50);
		
		System.out.println(set.size());
		System.out.println();
		
		Iterator<Integer> iter = set.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		ArrayList<Score> list = new ArrayList<Score>();
		list.add(new Score("홍길동", 100, 90));
		
		
		
		
	}//main
	
	
}
class Score{
	
	String name;
	int kor;
	int math;
	
	public Score(String name, int kor, int math) {
		this.name = name;
		this.kor = kor;
		this.math = math;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
}
