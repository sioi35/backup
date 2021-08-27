package com.project.spring.repo;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepoDAO {
	
	@Autowired
	private SqlSessionTemplate template;

	public List<RepoDTO> repolist(String id) {

		return template.selectList("repo.repolist", id);
	}

	public int repoAdd(RepoDTO dto) {

		return template.insert("repo.repoAdd", dto);
	}
	
	
	
}
