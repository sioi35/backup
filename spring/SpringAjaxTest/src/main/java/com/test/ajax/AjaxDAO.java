package com.test.ajax;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AjaxDAO {
	
	@Autowired
	private SqlSessionTemplate template;

	public int getUserCount() {

		return template.selectOne("ajax.getUserCount");
	}

	public String getUserName() {

		return template.selectOne("ajax.getUserName");
	}

	public UserDTO getUser() {

		return template.selectOne("ajax.getUser");
	}

	public List<UserDTO> getList() {

		return template.selectList("ajax.getList");
	}

	public void removeUser(String seq) {
		
		template.delete("ajax.removeUser", seq);
	}
	
	public UserDTO getSeqUser(String seq){
		
		return template.selectOne("ajax.getSeqUser", seq);
	}

	public int add(UserDTO dto) {

		return template.insert("ajax.add", dto);
	}

	public int idcheck(String id) {
		
		return template.selectOne("ajax.idcheck", id);
	}

	
	
	//CRUD
	// 1. 유저 목록 보기
	public List<UserDTO> list() {
		
		return template.selectList("ajax.list");
	}
	
	
	// 2. 유저 등록하기
//	public int add(UserDTO dto) {
//		
//		return template.insert("ajax.add", dto);
//	}
	

	// 3. 특정 유저 가져오기
	public UserDTO get(String seq) {
		
		return template.selectOne("ajax.get", seq);
	}


	// 4. 유저 수정하기
	public int edit(UserDTO dto) {
		
		return template.update("ajax.edit", dto);
	}
	

	// 5. 유저 삭제
	public int del(String seq) {
		
		return template.delete("ajax.del", seq);
	}
	

	// 6. 유저 검색하기(주소)
	public List<UserDTO> search(String word){
		
		return template.selectList("ajax.search", word);
	}
	
	public String getSeq() {
		
		return template.selectOne("ajax.getSeq");
	}

	public int addMemo(MemoDTO dto) {
	
		return template.insert("ajax.addMemo", dto);
	}

	public int getMaxNo() {

		return template.selectOne("ajax.getMaxNo");
	}
	
	public int getMaxBack() {
		
		return template.selectOne("ajax.getMaxBack");
	}
	
	public int getMaxZIndex() {
		
		return template.selectOne("ajax.getMaxZIndex");
	}

	public List<MemoDTO> listMemo() {

		return template.selectList("ajax.listMemo");
	}
	
	
}
