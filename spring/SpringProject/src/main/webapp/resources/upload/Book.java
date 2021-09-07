package com.test.question.q17;

public class Book {
	
	private String name;
	private int price;
	private String author;
	private String publisher;
	private int pubyear = 2021;
	private String isbn;
	private int page;
	private String total="";
	
	//제목 Setter, Getter 
	public void setName(String name) throws Exception {
		//유효성 검사 해야함
		for(int i=0; i<name.length(); i++) {
			char c = name.charAt(i);
			
			 if((c >= 'a' && c <= 'z')	||
				(c >= 'A' && c <= 'Z')	||
				(c >= '가' && c <= '힣')	||
				(c >= '0' && c <= '9') 	&& 
				name.length() <50 ) 
			 {
			    if(i==name.length()-1) {
					this.name = name;					
				}
	         }else
	         {
	        	 System.out.println("한글 2~5자 이내 입력 필수");
	        	 break;
	         }
			
		}//for
	}//setName
	
	public String getName() {
		
		return this.name;
	}//getName

	//가격 Setter, Getter
	public void setPrice(int price) throws Exception {
		if(price >= 0 && price<1000000) {
			this.price= price;			
		}else {
			//break;
			//throw new Exception("잘못된 가격입니다.");
		}
	}
	public int getPrice() {
		return this.price;
	}
	
	
	//저자 Setter, Getter
	public void setAuthor(String author) {
		this.author= author;
	}
	public String getAuthor() {
		return this.author;
	}
	
	
	//출판사 Setter 쓰기 전용
	public void setPublisher(String publisher) {
		this.publisher= publisher;
	}

	
	//페이지 수 Setter, Getter
	public void setPage(int page) throws Exception {
		if(page >0) {
			this.page= page;			
		}else {
			throw new Exception("잘못된 페이지 수 입니다.");
		}
	}
	public int getPage() {
		return this.page;
	}
	
	
	//발행년도 Getter 읽기전용
	public int getPubyear() {
		return this.pubyear;
	}
	
	
	//isbn Setter, Getter
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIsbn() {
		return this.isbn;
	}
	
	//전체 출력해주는 메소드
	public String info() {
		
		total += "=====<책 소개>=====\n";
		total += "제목 : " + this.name + "\n";
		total += "발행년도 : " + this.pubyear+ "년 \n";
		total += "출판사 : " + this.publisher+ "\n";
		total += "저자 : " + this.author+ "\n";
		total += "ISBN : " + this.isbn+ "\n";
		total += "가격 : " + this.price+ "원\n";
		total += "총 페이지수 : " + this.page+ "page";
		
		return total;
		
	}
}

