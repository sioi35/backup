package com.test.question.q20;

import java.util.Calendar;

public class Bugles {

	private int size;
	private int price = 0;
	private Calendar creationTime ;
	private int expiration;
		
	public void setSize(int size) {
		if(size == 300 || size == 500 || size == 850) {
			this.size = size;
		}else {
			System.out.println("용량이 잘못되었습니다.");
		}
	}//setSize
	
	public Calendar setCreationTime(Calendar creationTime) {
		return this.creationTime = creationTime;
	}
	
	public int getPrice() {
		if(this.size == 300 ) {
			this.price = 850;
		}else if(this.size == 500 ) {
			this.price = 1200;
		}else if(this.size == 850){
			this.price = 1950;
		}
		return this.price;
	}
	
	public int getExpiration() {
		Calendar now = Calendar.getInstance();
	
		this.expiration = (int)( (creationTime.getTimeInMillis() - now.getTimeInMillis()) / 1000 / 60 / 60 / 24 );
		
		if(this.size == 300) {
				return this.expiration + 7;
		}else if(this.size == 500) {
				return this.expiration + 10;
		}else if(this.size == 850){
				return this.expiration + 15;
		}
		return 0;
	}
	
	public void eat() {
		if(getExpiration()>0) {
			System.out.println("과자를 맛있게 먹습니다");
		}else if(getExpiration()<0){
			System.out.println("유통기한이 지나 먹을 수 없습니다.");
		}else {
			System.out.println("유통기한을 알 수 없음");
		}
		System.out.println();
	}
	
}// Bugles
