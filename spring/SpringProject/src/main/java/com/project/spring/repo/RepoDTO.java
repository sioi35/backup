package com.project.spring.repo;

import lombok.Data;

@Data
public class RepoDTO {
	
	private String repoSeq;
	private String id;
	private String name;
	private String description;
	private String lockflag;
	private String regdate;
	
}
