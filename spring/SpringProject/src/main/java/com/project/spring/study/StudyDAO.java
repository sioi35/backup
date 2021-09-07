package com.project.spring.study;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.spring.FieldDTO;
import com.project.spring.MemberDTO;

@Repository
public class StudyDAO {

	@Autowired
	private SqlSessionTemplate template;

	public List<StudyDTO> studyList(HashMap<String, String> smap) {

		return template.selectList("study.studyList", smap);
	}

	public int getStudyTotal(HashMap<String, String> smap) {
		
		return template.selectOne("study.getStudyTotal", smap);
	}

	public List<ApplyListDTO> Applylist(String seq) {

		return template.selectList("study.applylist", seq);
	}
	
	public MemberDTO get(String id) {

		return template.selectOne("study.get", id);
	}
	
	public StudyDTO getDetail(ApplyListDTO adto) {

		return template.selectOne("study.getDetail", adto);
	}

	public void studyRegist(ApplyListDTO adto) {
		
		template.insert("study.studyRegist", adto);
	}

	public void studyCancel(ApplyListDTO adto) {
		
		template.delete("study.studyCancel", adto);
	}

	public List<FieldDTO> getFieldList() {

		return template.selectList("study.getFieldList");
	}

	public int addStudy(StudyDTO dto) {
		
		return template.insert("study.addStudy", dto);
	}


}
