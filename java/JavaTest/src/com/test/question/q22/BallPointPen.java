package com.test.question.q22;

public class BallPointPen {

	private double thickness;
	private String color;
	
	public void setColor(String color) {
		
		if(color.equals("red") || color.equals("blue") || color.equals("green") || color.equals("black")) {
			this.color = color;
		}else{
			System.out.println("올바르지 않은 색상입니다.");
		}

	}

	public void setThickness(double thickness) {
		
		if(thickness == 0.3 || thickness == 0.5 || thickness == 0.7 || thickness == 1 || thickness == 1.5) {
			this.thickness = thickness;
		}
		
	}
	
	public String info() {
		
		return String.format("%s 색상 %.1fmm 볼펜입니다.", this.color, this.thickness);
		
	}
	
}
