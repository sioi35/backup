package com.test.question.q22;

public class Eraser {

	private String size;
	
	public void setSize(String size) {
		if(size.equals("Large") || size.equals("Medium") || size.equals("Small")) {
			this.size = size;
		}
	}

	public String info() {
		return String.format("%s 크기 지우개입니다.", this.size);
	}
	
}
