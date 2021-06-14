package com.test.question.q18;

public class Note2 {

	//크기 : 쓰기 전용, A3, A4, A5, B3, B4, B5
	private String size = "A5";
	
	//색상: 쓰기 전용, 흰색, 검정색, 노란색, 파란색
	private String color = "흰색";
	
	//페이지수: 쓰기전용, 10 ~ 200페이지 이내
	// (+) 10~50(얇다), 51~100(보통), 101~200(두껍다)
	private int page = 10; 
	
	//소유자이름: 쓰기 전용, 한글 2~5자 이내, 필수값
	private String owner;
	
	private int price; // 기본 가격
	
	//Setter, Getter
	public void setSize(String size) throws Exception {
		
		if(size.equals("A3") 
				|| size.equals("A4")
				|| size.equals("B3")
				|| size.equals("B4") 
				|| size.equals("B5")) {
			this.size = size;
		}else {
			System.out.println("잘못된 사이즈를 입력했습니다.");
		}
		
	} //setSize
	

	public void setColor(String color) {
		if(color.equals("검정색") 
				|| color.equals("흰색") 
				|| color.equals("노란색")
				|| color.equals("파란색")) {
			
		}else {
			System.out.println("잘못된 색상을 입력했습니다.");
		}
	}
	
	public void setPage(int page) {
		if(page >= 10 && page <=200) {
			this.page = page;
		}else {
			System.out.println("잘못된 페이지수를 입력했습니다.");
		}
	}
	
	public void setOwner(String owner) {
		
		if(checkLegnth(owner) && checkChar(owner)) {
			this.owner = owner;
		}else {
			System.out.println("잘못된 소유자 이름이니다.");
		}
		
	}

	private boolean checkChar(String owner) {
		for(int i=0; i<owner.length(); i++) {
			char c = owner.charAt(i);
			
			if(c < '가' || c > '힣') {
				return false;
			}
		}
		return true;
	}

	private boolean checkLegnth(String owner) {
		
		if(owner.length() >= 2 && owner.length() <=5) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public String info1() {
		
		//(+) 기본 노트 : A5 + 흰색 + 10페이지 = 가격(500)
		//(+) 크기 변경 : A3(+400), A4(+200), B3(+500), B4(+300), B5(+100)
		//(+) 색상 변경: 검정색(+100), 노란색(+200), 파란색(+200)
		//(+) 페이지 수 변경: 페이지당 X 10원 추가
		
		//기본 노트
		this.price = 500;
		
		if(this.size.equals("A3")){
			this.price += 400;
		}else if(this.size.equals("A4")){
			this.price += 200;
		}else if(this.size.equals("B3")){
			this.price += 500;
		}else if(this.size.equals("B4")){
			this.price += 300;
		}else if(this.size.equals("B5")){
			this.price += 100;
		} 
		
		if(this.color.endsWith("검정색")) {
			this.price += 100;
		}else if(this.color.endsWith("노란색")) {
			this.price += 200;
		}else if(this.color.endsWith("파란색")) {
			this.price += 200;
		} 
		
		this.price += (this.page - 10) * 10;
		
		String tempPage = "";
		if(this.page >=10 && this.page<=50) {
			tempPage = "얇은";
		}else if(this.page >=51 && this.page<=100) {
			tempPage = "보통";
		}else if(this.page >=101 && this.page<=200) {
			tempPage = "두꺼운";
		}
		
		// pirntf("형식문자열" , 인자) : 출력
		// String.format("형식문자열", 인자): 반환
		
		String temp ="";
		
		temp += "■ ■ ■ ■ ■ 노트 정보 ■ ■ ■ ■ ■\n";
		
		if(this.owner != null) {
//		temp += "소유자: " + this.owner;
//		temp += "특성: " + this.color + " " + tempPage + " " + this.size + "노트";
			temp += String.format("소유자: %s\n", this.owner);
			temp += String.format("특성: %s %s %s노트\n", this.color, tempPage, this.size);
			temp += String.format("가격: %,d원\n", this.price) + "원";
		}else {
			temp += "주인 없는 노트\n";
		}
		
		temp += "■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■\n";
		
		return temp;
		
	} 
	
	
	
}
