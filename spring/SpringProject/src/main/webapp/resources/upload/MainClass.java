package com.test.question.q17;

public class MainClass {
	public static void main(String[] args) throws Exception {
		
		Book b1 = new Book();
		
		//제목
		b1.setName("자바의 정석");
		System.out.println(b1.getName());
		
		//가격
		b1.setPrice(30000);
		System.out.println(b1.getPrice());
		
		b1.setAuthor("남궁 성");
		System.out.println(b1.getAuthor());
		
		b1.setPublisher("도우 출판");

		System.out.println(b1.getPubyear()); //출판사 쓰기전용
		
		b1.setPage(1000);
		System.out.println(b1.getPage());
		
		b1.setIsbn("java2021");
		System.out.println(b1.getIsbn());
		
		System.out.println(b1.info());
		
	}//main
	
}//MainClass
