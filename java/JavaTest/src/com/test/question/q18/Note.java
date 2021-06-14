package com.test.question.q18;

public class Note {

	//크기 : 쓰기 전용, A3, A4, A5, B3, B4, B5
	private String size;
	private String color;
	private int page; 
	private String owner;
	private int price = 500; // 기본 가격
	private String thickness;
	
	//size 쓰기 전용
	public void setSize(String size) throws Exception {
		
		if(size.charAt(0) == 'A') {
			if(size.charAt(1) == '3') {
				price += 400;
				this.size = size;
			}else if(size.charAt(1) == '4') {
				price += 200;
				this.size = size;
			}else if(size.charAt(1) == '5'){
				this.size = size;
			}else {
				System.out.println("올바르지 않은 크기입니다.");
			}
		}else if (size.charAt(0) == 'B') {
			if(size.charAt(1) == '3') {
				price += 500;
				this.size = size;
			}else if(size.charAt(1) == '4') {
				price += 300;
				this.size = size;
			}else if(size.charAt(1) == '5'){
				price += 100;
				this.size = size;
			}else {
				System.out.println("올바르지 않은 크기입니다.");
			}
		}else {
			System.out.println("올바르지 않은 크기입니다.");
		}
				
	} //setSize
	
	public void setColor(String color) throws Exception {
		
		String[] noteColor = {"흰색", "검정색", "노란색", "파란색"};
		
		for(int i=0; i<noteColor.length; i++) {
			if(color.equals(noteColor[i])) {
				if(i==3) {
					price += (i-1)*100;
				}else {					
					price += i*100;					
				}
				this.color = noteColor[i];
				break;
			}
		}
	}
	
	public void setPage(int page) {
		if(page>10) {
			price += (page-10) * 10;
		}
		if(page >= 10 && page<=200) {
			if(page<=50) {
				thickness = "얇은";
			}else if(page <=100) {
				thickness = "보통";
			}else {
				thickness = "두꺼운";
			}
		}else {
			System.out.println("두께가 잘못됨");
		}
	}
	
	public void setName(String owner) throws Exception {
		//유효성 검사 해야함
		int i=0;
		while(i<owner.length()){
			char c = owner.charAt(i);
			if((c >= '가' && c <= '힣')&&
				 owner.length() >=2 &&
				 owner.length() <=5 ) 
			 {
				if(i==owner.length()-1) {
					this.owner = owner;					
				}
	         }else {
	        	 System.out.println("한글 2~5자 이내 입력 필수");
	        	 break;
	         }
			i++;
		}//while
		
		
//		for(int i=0; i<owner.length(); i++) {
//			char c = owner.charAt(i);
//			 if((c >= '가' && c <= '힣')	&&
//					 owner.length() >=2 &&
//					 owner.length() <=5 ) 
//			 {
//	            this.owner = owner;
//	         }
//			 else {
//				 //System.out.println("한글 2~5자 이내 입력 필수");
//	         }
//		}	
		
	}//setName	
	
	public void Info() {
		
		System.out.println("■ ■ ■ ■ ■ 노트 정보 ■ ■ ■ ■ ■");
		if(this.owner == null) {
			System.out.println("주인없는 노트");
		}else{
			System.out.printf("소유자 : %s\n", this.owner);
			System.out.printf("특성 : %s %s %s노트\n", color,thickness, size );						
			System.out.printf("가격 : %,3d원\n", this.price);
		}
		System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		System.out.println();
		
	}
	
}//Note
