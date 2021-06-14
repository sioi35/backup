package com.test.java.obj;

public class Ex38_Static {

	public static void main(String[] args) {
		
		// 목적] 생산한 마우스의 갯수 세기
		
		// Case A.
//		int count = 0; //누적 변수
//		
//		Mouse m1 = new Mouse(); // 생산
//		count++; //카운팅
//		
//		Mouse m2 = new Mouse();
//		count++;
//		
//		Mouse m3 = new Mouse();
//		count++;
//		
//		System.out.printf("총 갯수: %d개\n", count);
		
		//Case B.
		
//		Mouse m1 = new Mouse();
//		//m1.setCount(m1.getCount()+1); // private int count로 했을떄.
//		
//		m1.count += 1;  // public int count로 했을때		
//		
//		Mouse m2 = new Mouse();
//		m2.count += 1;
//		
//		Mouse m3 = new Mouse();
//		m3.count += 1;
//		
//		System.out.printf("총 갯수: %d개\n", m1.count);
		
		
		//Case C.
		Mouse m1 = new Mouse();
		Mouse.count++;
		
		Mouse m2 = new Mouse();
		Mouse.count++;
		
		Mouse m3 = new Mouse();
		Mouse.count++;
		System.out.printf("총 갯수: %d개\n", Mouse.count);
		
	}//main
	
}//Ex38_Static

class Mouse{
	
	private String model; // 개인 정보(객체)
	
	//public int count; //누적 변수
	
	public static int count; //공용 정보(정적)

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}