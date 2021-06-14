package com.test.java.obj;


//해당 클래스를 사용하는 개발자들에게 알려주는 클래스 사용법
// -> 도움말 만든다. -> Documentation(기술 문서)

//문서 주석
//1. 작업 중 풍선 도움말에 보여진다. > 개인 작업 or 팀작업(******)
//2. 이 주석들만 모아서 별도의 도움말 파일을 생성할 수 있다. > javadoc.exe


/**
 * 
 * 유저 정보를 담는 클래스입니다.
 * @author sioi3
 *
 */
public class User{
	
	private String name;
	private String id;
	private String pw;
	
	/**
	 * 기본 생성자입니다.
	 * 모든 멤버를 빈 문자열로 초기화합니다.
	 */
	public User() {
		this.name = "";
		this.id = "";
		this.pw = "";
	}

	/**
	 * 매개변수를 가지는 생성자 입니다.
	 * @param name 유저명
	 * @param id 아디디
	 * @param pw 비밀번호
	 */
	public User(String name, String id, String pw) {
		this.name = name;
		this.id = id;
		this.pw = pw;
	}

	/**
	 * 유저명 Getter
	 * @return 유저명
	 */
	public String getName() {
		return name;
	}

	/**
	 * 유저명 Setter
	 * @param name 유저명
	 */
	public void setName(String name) {
		this.name = name;
	}

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

	
}
