package com.project.spring.skill;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.spring.FieldDTO;

@Repository
public class SkillDAO {

	@Autowired
	private SqlSessionTemplate template;
	
	public List<FieldDTO> flist() {
		
		return template.selectList("skill.flist");
	}

	public FieldDTO getUserField(String id) {
		
		return template.selectOne("skill.getUserField", id);
	}

	public List<LicenseDTO> llist(String fieldSeq) {
		
		return template.selectList("skill.llist", fieldSeq);
	}

	public FieldDTO getField(String seq) {
		
		return template.selectOne("skill.getField", seq);
	}

	public List<SubjectDTO> slist(String seq) {
		
		return template.selectList("skill.slist", seq);
	}

	public List<ProblemDTO> plist(String seq) {
		
		return template.selectList("skill.plist", seq);
	}

}
