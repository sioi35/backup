package com.test.question.q21;

public class Box {
	
	//요구사항] 다량의 객체를 잘 제어할 수 있는지? 
	private Macaron[] list = new Macaron[10];

	public void cook() {
		//마카롱 만들기
		//1. 객체 생성
		//2. 각 값을 랜덤으로 배열
		//3. 상자에 담기
		list[0] = new Macaron(); //마카롱 만들기 + 상자에 담기
		
		
		for(int i=0; i< list.length; i++) {
			Macaron m = new Macaron();
			
			//생산 크기 무작위
			m.setSize((int)(Math.random() * 11) + 5);
			
			//생산 색상
			//1. 배열에 색상 넣기
			String color[] = new String[]{"red", "blue", "yellow", "white", "pink", "purple", "green", "black"}; //8가지
			m.setColor(color[(int)(Math.random() * color.length)]);

			//생산 두께
			m.setThickness((int)(Math.random() * 20) + 1);
			
			list[i] = m; //마카롱 상자에 담기
					
			}
		
		System.out.printf("마카롱을 %d개 만들었습니다.\n", list.length);
		System.out.println();
		
	}
	
	public void check() {
		// 합격, 불합격 개수
		int pass = 0;
		int fail = 0;
		
		for(int i = 0; i<this.list.length; i++) {
			
			if(list[i].getColor() == "black"
			|| list[i].getSize() <8 || list[i].getSize()>14 
			||list[i].getThickness() <3 || list[i].getThickness()>18 ) {
				fail++;
			}else {
				pass++;
			}
		
		}//for문
		
		System.out.printf("QC 합격 개수: %d\n",pass);
		System.out.printf("QC 불합격 개수: %d\n",fail );
		System.out.println();
	}
	
	 private String check(int i) {
		 if(list[i].getColor() == "black"
					|| list[i].getSize() <8 || list[i].getSize()>14 
					||list[i].getThickness() <3 || list[i].getThickness()>18 ) {
	         return "불합격";
	      } else  { 
	         return "합격";
	      }
	   }
	
	public void list() {
		//10개 마카롱 크기 색상 - 합 불//
		//현황 출력
		System.out.println("[마카롱 목록]");
		for(int i=0; i< this.list.length; i++) {
			System.out.printf("%2d번 마카롱 : %2dcm(%s, %dmm)	: %s  \n",
					i+1, list[i].getSize(), list[i].getColor(), list[i].getThickness(), check(i));
		}
	}
	
}
