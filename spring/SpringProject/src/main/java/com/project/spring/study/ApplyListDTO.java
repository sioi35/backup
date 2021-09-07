package com.project.spring.study;

import lombok.Data;

@Data
public class ApplyListDTO {
	
	private String applySeq;
	private String studySeq;
	private String id;
	private String field; //합격여부
	
	private String name; //이름
	private String languagename; //사용언어
	private String phone; //전화번호
	private String regdate; //신청날짜
	
	private String fieldName; //분야명
	
	private String gender;
	private String birth;
	private String email;
	private String image;

}
