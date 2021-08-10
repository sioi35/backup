package com.test.practice;


//Data Transfer Object
//일반 클래스가 DTO 역할을 하기 위한 규칙!!
//1. 데이터를 담기 위한 멤버 변수를 private으로 선언한다.
//2. getter, setter를 구현한다.
//3. 그 외의 작업은 안한다.
public class DTO {

	private String id;
	private String pw;
	private String name;
	private String tel;
	private String birth;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	
	
}
