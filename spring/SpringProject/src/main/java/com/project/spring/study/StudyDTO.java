package com.project.spring.study;

import lombok.Data;

@Data
public class StudyDTO {
	
	private String studySeq;
	private String id;
	private String name;
	private String content;
	private String limitNumber;
	private String area;
	private String startDate;
	private String endDate;
	private String regdate;
	private String book;
	private String fieldSeq;
	
	private String fieldName; //분야명
	private String applySeq; //지원목록 seq - 지원여부 확인하기 위해 추가(null이면 지원x, 아니면 지원o)
	private String cnt; //스터디 신청 인원
	private String passcnt; //스터디 합격 인원
	
}
