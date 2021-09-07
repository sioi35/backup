package com.project.spring.repo;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.spring.MemberDTO;

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

	public List<FileDTO> fileview(String repoSeq) {

		return template.selectList("repo.fileview", repoSeq);
	}

	public FileDTO codeview(String fileSeq) {

		return template.selectOne("repo.codeview", fileSeq);
	}

	public int codeadd(FileDTO dto) {

		return template.insert("repo.codeadd", dto);
	}

	public MemberDTO minfo(String id) {

		return template.selectOne("repo.minfo", id);
	}

	
}
