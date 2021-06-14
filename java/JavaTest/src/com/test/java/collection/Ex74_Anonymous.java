package com.test.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;

public class Ex74_Anonymous {

	public static void main(String[] args) {
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		// ------------ 사용자가 직접 구현
		
		
		// ------------ 제공하는 기능을 사용(완전 자동 + 반자동)
		//m7();
		//m8();
		//m9();
		//m10();
		m11();
		
		// 자바의 sort메소드
		// -> 퀵 정렬 구현
		
		
	}//main

	private static void m11() {

		ArrayList<User> list = new ArrayList<User>();
		
		Calendar c1 = Calendar.getInstance();
		c1.set(1995, 2, 5);
		list.add(new User("홍길동", c1));
		
		Calendar c2 = Calendar.getInstance();
		c2.set(1996, 3, 11);
		list.add(new User("아무개", c2));
		
		Calendar c3 = Calendar.getInstance();
		c3.set(1993, 7, 15);
		list.add(new User("하하하", c3));

		list.sort(new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				
				//return (int)(o1.birthday.getTimeInMillis() - o2.birthday.getTimeInMillis());
				return o1.birthday.compareTo(o2.birthday);
			}
			
		});
		System.out.println(list);
	}

	private static void m10() {

		ArrayList<Product> list = new ArrayList<Product>();
		
		list.add(new Product("마우스", 1000));
		list.add(new Product("키보드", 1500));
		list.add(new Product("모니터", 3000));
		list.add(new Product("USB", 1200));
		list.add(new Product("랩탑", 1100));
		
		list.sort(new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				
				return o1.price - o2.price;
			}
		});
				
		System.out.println(list);
	}//m10

	private static void m9() {

		ArrayList<String> name = new ArrayList<String>();
		
		name.add("홍길동");
		name.add("아무개");
		name.add("하하하하");
		name.add("호호호");
		name.add("후후");
		
		name.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				//return o1.compareTo(o2);
				//return o2.compareTo(o1);
				
				//return o1.length() - o2.length();
				
				//1차 정렬
				if(o1.length() > o2.length()) {
					return 1; 
				}else if(o1.length() < o2.length()){
					return -1;
				}else {
					//1차 정렬
					return o1.compareTo(o2);
				}
				
			}
			
		});
		
		System.out.println(name);
	}//m9

	private static void m8() {

		ArrayList<Integer> num = new ArrayList<Integer>();
		
		num.add(10);
		num.add(50);
		num.add(30);
		num.add(40);
		num.add(20);
		
		num.sort(new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
			
		});
		
		System.out.println(num);
		
	}

	private static void m7() {

		Integer[] num = {5,3,1,4,2};
		
		//Arrays.sort(num);  // 정렬(오름차순)
		
		//System.out.println(Arrays.toString(num));
		
		// 순수 배열 -> 내림 차순 정렬 기능 없음
		
		//Arrays.sort(num, 1, 4); //부분 정렬
		//System.out.println(Arrays.toString(num));
		
		//Comparator<? super T> c
		Arrays.sort(num, new MySort());
		System.out.println(Arrays.toString(num));
		
		Arrays.sort(num, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
			
		});
		System.out.println(Arrays.toString(num));
		
	}//m7

	private static void m6() {

		User[] list = new User[5];
		
		Calendar c1 = Calendar.getInstance();
		c1.set(1995, 2, 5);
		list[0]  = new User("홍길동", c1);
		
		Calendar c2 = Calendar.getInstance();
		c2.set(1996, 3, 11);
		list[1]  = new User("아무개", c2);
		
		Calendar c3 = Calendar.getInstance();
		c3.set(1993, 7, 15);
		list[2]  = new User("하하하", c3);
		
		Calendar c4 = Calendar.getInstance();
		c4.set(1998, 9, 3);
		list[3]  = new User("호호호", c4);
		
		Calendar c5 = Calendar.getInstance();
		c5.set(1992, 7, 11);
		list[4]  = new User("후후후", c5);
		
		//System.out.println(Arrays.toString(list));
		
		
		for(int i=0; i<list.length-1; i++) {
			
			for(int j=0; j<list.length-1-i; j++) {

				// 객체간의 우위 비교
				// -> 생일 비교
				if(list[j].birthday.getTimeInMillis() > list[j+1].birthday.getTimeInMillis()) {
					
					User temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
					
				}
				
			}
		
		}
		System.out.println(Arrays.toString(list));
		
		
	}//m6

	private static void m5() {
		
		// 가장 현실적인 사례
		Product[] list = new Product[5];
		
		list[0] = new Product("모니터", 350000);
		list[1] = new Product("키보드", 110000);
		list[2] = new Product("마우스", 50000);
		list[3] = new Product("랩탑", 150000);
		list[4] = new Product("외장메모리", 15000);
		
		
		// 제품을 정렬하시오.
		// -> 기준? 
		for(int i=0; i<list.length-1; i++) {
			
			for(int j=0; j<list.length-1-i; j++) {
				
				//우위 비교?
				// - 객체간의 비교(X) -> 객체가 가지는 단일값의 비교(O)
				//if(list[j].price > list[j+1].price) {
				if(list[j].name.compareTo(list[j+1].name)> 0) {
					// 비교는 객체의 속성을 가지고 했지만
					// 실제 교환은 객체간 이뤄져야한다.(*****)
//					int temp = list[j].price;
//					list[j].price = list[j+1].price;
//					list[j+1].price = temp;
					
					//제품간의 교환
					Product temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}
				
			}//j for
			
		}//i for
		
	}//m5

	private static void m4() {

		String[] name = {"홍길동", "아무개", "호호호", "가가가", "홍길순"};
		
		for(int i=0; i<name.length-1; i++) {
			
			for(int j=0; j<name.length-1-i; j++) {
				
				// 두 방의 이름을 비교 -> 우위 비교
				// "홍길동" > "아무개"
				if(name[j].compareTo(name[j+1]) > 0) {  
					String temp ="";
					temp = name[j];
					name[j] = name[j+1];
					name[j+1] = temp;
				}
				
			}//j for
			
		}//i for
		System.out.println(Arrays.toString(name));
		
	}//m4

	private static void m3() {
	
		// 버블 정렬
		int[] num = {5,3,4,1,2};
		
		for(int i=0; i<num.length-1; i++) {
			
			System.out.printf("%d사이클 \n", i+1);
			
			for(int j=0; j<num.length-1-i; j++) {
				//j: 엑셀의 빨간 숫자
				System.out.printf("\t%d 작은 사이클 \n", j+1);
				if(num[j]>num[j+1]) {
					// 두 방의 값을 서로 바꾸기(Swap)
					int temp = num[j];
					num[j] = num[j+1];
					num[j+1] = temp;
				}
				System.out.println("\t" + Arrays.toString(num));
				
			}//j for
			
		}//i for
		System.out.println(Arrays.toString(num));
		
	}//m3

	private static void m2() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(100);
		list.add(500);
		list.add(300);
		list.add(400);
		list.add(200);
		
		// 대부분의 컬렉션은 toString() 오버라이드 되어있다.
		// -> 본인의 상태(데이터)를 문자열로 반환
		// -> 개발자 확인 용이
		
		System.out.println(list);
		System.out.println(list.toString());  //***
		
		int[] num = {10, 30, 20, 50, 40};
		
		System.out.println(num);
		System.out.println(num.toString());
		System.out.println(Arrays.toString(num));  //***
		
		// 정렬
		// - 값의 우위 비교를 통해 순서를 바꾸는 행동
		// - 오름차순 정렬, 내림차순 정렬
		// 1. 사용자 정렬
		//	- 버블 정렬(가장 쉬움)
		// 	- 삽입 정렬
		//	- 선택 정렬
		//	- 퀵 정렬
		//	- 병합 정렬
		//	- 힙 정렬
		//	- 셸 정렬
		
		// 2. 해당 클래스 정렬 기능
	}

	private static void m1() {
		/*
		
		익명 객체, Anonymous Object
		- 익명 클래스, Anonymous Class
		- 이름이 없는 클래스(객체)
		- 붕어빵틀에 이름이 없다.
		- 이름이 없는 이유? - 해당 클래스를 호출할 일이 없다.(반복해서 사용할 일이 없는 붕어빵 틀)
		
		
		a. 데이터 집합
			1. 클래스: 같은 형식을 가지는 집합 x N개 + 클래스 선언 비용 
			2. HashMap: 데이터 집합 x 1개 + 클래스 선언 비용(X)
		
		b. 행동 집합
			1. 실명 클래스: 객체화 횟수 x N개 + 클래스 선언 비용O 
			2. 익명 클래스: 객체화 횟수 x 1개 + 클래스 선언 비용X

		*/

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("kor", 100); //멤버 변수 역할(클래스)
		map.put("eng", 90); 
		map.put("math", 80); 
		
		HashMap<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put("kor", 100); //멤버 변수 역할(클래스)
		map2.put("eng", 90); 
		map2.put("math", 80); 
		
		CCC c = new CCC();
		c.test();
		
		//인터페이스를 상속한 클래스의 객체는 되도록 인터페이스 변수를 만들어서 담아라
		AAA c5 = new CCC(); //업캐스팅
		c5.test();
		
		//Cannot instantiate the type AAA 
		// -> 추상메소드 때문에..
		//인터페이스/추상메소드는 객체를 만들 수 없음.
		//AAA c3 = new AAA();
		
		AAA c3 = new AAA(){

			@Override
			public void test() {
				System.out.println("인터페이스를 구현한 메소드");
			}
		};
		
		AAA c4 = new AAA() {
			@Override
			public void test() {
				
			}
		};
		
		//AAA c5 = new CCC();
		AAA c6 = new CCC(); //test(); 같은 클래스로 객체만 생성하면 가능.
		
		AAA c7 = new AAA() {

			@Override
			public void test() {
				System.out.println("하하하");
			}
		};

		AAA c8 = new AAA() {

			@Override
			public void test() {
				
			}
			
		};
	}
	
}//Ex74_Anonymous

//class ??{
	
	
//}

interface AAA{
	//public abstract void test();
	void test();  //interface 내부에서는 추상메서드 밖에 못 오므로 생략 가능
}

//프로젝트 > 클래스 개수 > 관리 힘들다...(개수, 이름 짓기..)

class CCC implements AAA{
	@Override
	public void test() {
		System.out.println("인터페이스 구현 메소드");
	}
}

class DDD implements AAA{
	@Override
	public void test() {
		// TODO Auto-generated method stub
	}
}

abstract class BBB{
	public abstract void test();
	private int a;
	public void aaa() {
		
	}
}

class Product{
	public String name;
	public int price;
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return String.format("(%s,%,d원)", this.name, this.price);
	}
	
}

class User{
	
	public String name;
	public Calendar birthday;
	
	public User(String name, Calendar birthday) {
		this.name = name;
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return String.format("(%s, %tF)", this.name, this.birthday);
	}
}

class MySort implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		
		// 인자값 두개를 우위 비교
		// -> 양수 or 0 or 음수 -> 반환
		return o2 - o1;
	}

}










