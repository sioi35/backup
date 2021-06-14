package com.test.question.q22_2;

public class Espresso {

	private int bean;

	public void setBean(int bean) {
		this.bean = bean;
	}


	public void drink() {
		System.out.printf("원두 %dg으로 만들어진 에스프레소를 마십니다.\n", bean);
	}
	
}//Espresso