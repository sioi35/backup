package com.test.etc.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Ex03 {

	public static void main(String[] args) {
		
		//Ex03.java
		//람다식
		//- 1회성 메소드를 만드는 기법
		//- 익명 객체의 추상 메소드를 간편하게(간략하게)표기하는 기법
		
		
		//목적!
		//- 람다식(X) <- 목적(X), 도구(O)
		//- RedInterface를 구현 + 딱 1번만 > 그 안의 추상 메소드 color() 구현하는 것!!
		//- RedInterface를 구현 + N번만 > 실명 클래스 구현
		
		//익명 클래스
		RedInterface r1 = new RedInterface() {
			//추상 메소드 구현(오버라이드)
			@Override
			public void color() {
				System.out.println("익명 객체를 통한 추상 메소드 구현");
			}

			/*
			 * @Override public void test() { }
			 */
		};
		
		r1.color();
		
		//익명 클래스 -> 람다식 -> 코드 비용 절감 + 가독성 향상
		//The target type of this expression must be a functional interface
		
		RedInterface r2 = () -> {
			System.out.println("익명 객체를 통한 추상 메소드 구현");
		};
		r2.color();
		
		RedInterface r3 = () -> System.out.println("익명 객체를 통한 추상 메소드 구현");
		r3.color();
		
		YellowInterface y1 = (String c) -> System.out.println(c);
		y1.color("Yellow");
		
		YellowInterface y2 = c -> {
			if(c.equals("Yellow")) {
				System.out.println("노랑");
			}else if(c.equals("Red")){
				System.out.println("빨강");
			}
		};
		
		BlueInterface b1 = (c1, c2) -> { return c1 + c2; };
		BlueInterface b2 = (c1, c2) -> c1 + c2;
		
		System.out.println(b1.color("red", "blue"));
		System.out.println(b2.color("yellow", "blue"));
		
		//여태까지의 수업 내용에서 람다식을 사용할 만한 곳?
		//1. 배열의 정렬
		//2. 컬렉션의 정렬
		//3. 익명 객체 구현 시
		
		Integer[] nums = {10, 40, 20, 50, 30 };
		ArrayList<String> names= new ArrayList<String>();
		names.add("나나나");
		names.add("라라라");
		names.add("가가가");
		names.add("마마마");
		names.add("바바바");
		
		ArrayList<User> users = new ArrayList<User>();
		
		users.add(new User("김사장", 50));
		users.add(new User("홍과장", 38));
		users.add(new User("서대리", 33));
		users.add(new User("윤차장", 42));
		users.add(new User("정사원", 29));
		
		Arrays.sort(nums);
		
		Arrays.sort(nums, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		
		Arrays.sort(nums, (o1, o2) -> o1 - o2);
		
		System.out.println(Arrays.toString(nums));
		
		names.sort((n1, n2) -> n1.compareTo(n2));
		names.sort((n1, n2) -> n2.compareTo(n1));
		System.out.println(names);
		
		users.sort((u1, u2) -> u1.getAge() - u2.getAge());
		users.sort((u1, u2) -> u1.getName().compareTo(u2.getName()));
		System.out.println(users);

	
	}//main
	
}//Ex03

class User{
	private String name;
	private int age;
	
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return String.format("%s[%d] ", this.name, this.age);
	}
	
}//User


//람다식을 저장할 인터페이스
//- Target Type
//- Functional Interface = 물리적(추상 메소드 1개 보유) + 용도(람다식을 저장)
//- 반드시 추상 메소드를 딱 1개만 가질 수 있다.

@FunctionalInterface
interface RedInterface {
	void color();
	//void test();
}

@FunctionalInterface
interface YellowInterface {
	void color(String c);
}

@FunctionalInterface
interface BlueInterface {
	String color(String c1, String c2);
}

