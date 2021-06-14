package com.test.question.q23;

public class Time {

	private int hour;
	private int minute;
	private int second;
	
	public Time() {
		this(0, 0, 0);
	}
	
	public Time(int minute, int second) {
		this(0, minute, second);
	}
	
	public Time(int second) {
		this(0,0,second);
	
	}
	
	//*** 생성자는 또 다른 생성자를 호출할 수 있다.
	// 모든 계산은 이 생성자에서 실행
	public Time(int hour, int minute, int second) {
		
		while(true) {
			if(hour<0 || minute<0 || second<0) {  // 시간이 음의 값이 될 수 없으므로 조건 추가
				System.out.println("시간을 잘못 입력하셨습니다.");
				break;
			}else if(hour>24) { 
				hour -= 24;
			}else if(second >= 60){  
				minute += second / 60;
				second = second % 60;
			}else if(minute >= 60) {
				hour += minute/60;
				minute = minute % 60;
			}else {
				this.hour = hour;
				this.minute = minute;
				this.second = second;					
				break;
			}
		}//while
	
	}
	
	public String info() {
		// 문자열 반환
		// 1. return this.hour+":"+this.minute+":"+this.second;
		return String.format("%d:%d:%d", hour, minute, second);  //2.
	}
	
}//Time
