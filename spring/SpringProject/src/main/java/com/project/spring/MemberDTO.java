package com.project.spring;

import lombok.Data;

@Data
public class MemberDTO {
	
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String birth;
	private String phone;
	private String email;
	private String image;
	private String languageSeq;
	private String filedSeq;
	
	private String languagename; //사용언어 이름
	
}