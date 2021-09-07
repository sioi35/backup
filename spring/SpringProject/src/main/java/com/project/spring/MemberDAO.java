package com.project.spring;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate template;
	
	public String signin(String loginId) {
		
		return template.selectOne("main.signin", loginId);
	}
      
}
