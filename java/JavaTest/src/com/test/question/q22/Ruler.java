package com.test.question.q22;

public class Ruler {

	private String shape;
	private int length;
	
	public void setLength(int length) {
		
		if(length == 30 || length == 50 || length ==100) {
			this.length = length;
		}
		
	}

	public void setShape(String shape) {

		if(shape.equals("줄자") || shape.equals("운형자") || shape.equals("삼각자")) {
			this.shape = shape;
		}
		
	}
	
	public String info() {
		return String.format("%dcm %s입니다.", this.length, this.shape);
	}
	
}
