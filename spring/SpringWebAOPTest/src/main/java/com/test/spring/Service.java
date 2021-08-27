package com.test.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	private DAO dao;
	
	//주업무.A
	public List<DTO> list() {
		
		return dao.list();
	}

	//주업무.B
	public int add() {
		
		return dao.add();
	}

	//주업무.C
	public DTO get() {

		return dao.get();
	}

}
