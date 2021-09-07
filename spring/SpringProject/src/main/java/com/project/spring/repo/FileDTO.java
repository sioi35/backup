package com.project.spring.repo;

import lombok.Data;

@Data
public class FileDTO {
	
	private String fileSeq;
	private String repoSeq;
	private String regdate;
	private String content;
	private String beforedate;
	private String fileName;
	
	private String name;

}
