package com.project.spring.skill;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SubjectDTO {

	private String subjectSeq;
	private String name;
	private String fieldSeq;
	
	private List<ProblemDTO> qlist = new ArrayList<ProblemDTO>();
	
}
