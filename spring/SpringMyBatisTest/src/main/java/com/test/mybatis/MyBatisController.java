package com.test.mybatis;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyBatisController {
	
	//MyBatisController -> (의존 주입) -> MyBatisDAO 객체 생성 
	//					-> (의존 주입) -> SqlSessionTemplate 객체 생성 
	//					-> (의존 주입) -> SqlSessionFactoryBean 객체 생성 
	//					-> (의존 주입) -> BasicDataSource 객체 생성
	
	
	@Autowired
	private MyBatisDAO dao;
	

	@RequestMapping(value = "/test.action", method = { RequestMethod.GET })
	public String test(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		
		return "result";
	}
	
	@RequestMapping(value = "/m1.action", method = { RequestMethod.GET })
	public String m1(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		
		MyBatisDTO dto = new MyBatisDTO();
		
		dto.setSeq("3");
		dto.setName("아무개");
		dto.setMemo("메모입니다");
		dto.setCategory("MyBatis");
		
		//반환값이 없는 쿼리
		int result = dao.add(dto);
		
		req.setAttribute("result", result);
		
		return "result";
	}
	
	
	@RequestMapping(value = "/m2.action", method = { RequestMethod.GET })
	public String m2(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		
		
		//상자 -> DTO, HashMap
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("category", "스프링");
		map.put("newcategory", "Spring");
		
		int result = dao.m2(map);
		
		req.setAttribute("result", result);
		
		return "result";
	}
	
	@RequestMapping(value = "/m3.action", method = { RequestMethod.GET })
	public String m3(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
	
		//반환값 없는 쿼리
		// - template.insert("id")
		// - template.insert("id", parameter)
		// - template.update("id")
		// - template.update("id", parameter)
		// - template.delete("id")
		// - template.delete("id", parameter)
		
		
		//반환값 있는 쿼리
		//	- 결과셋의 레코드가 1개
		//		- template.selectOne("id")
		//		- template.selectOne("id", parameter)
		//	- 결과셋의 레코드가 N개
		//		- template.selectList("id");
		//		- template.selectList("id", parameter);
		
		
		//단일 레코드 + 단일 컬럼 -> 반환
		
		int count = dao.m3();
		
		req.setAttribute("count", count);
		
		return "result";
	}
	
	@RequestMapping(value = "/m4.action", method = { RequestMethod.GET })
	public String m4(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		
		//단일값 매개변수 -> 단일값 반환(메모 내용)
		String seq = "1";
		
		String memo = dao.m4(seq);
		
		req.setAttribute("memo", memo);
		
		return "result";
	}
	
	@RequestMapping(value = "/m5.action", method = { RequestMethod.GET })
	public String m5(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		
		String seq = "1";
		
		MyBatisDTO dto = dao.m5(seq);
		
		req.setAttribute("dto", dto);
		
		return "result";
	}
	
	@RequestMapping(value = "/m6.action", method = { RequestMethod.GET })
	public String m6(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		
		//전체 메모 목록 가져오기
		
		List<MyBatisDTO> list = dao.m6();
		
		req.setAttribute("list", list);
		
		return "result";
	}
	
	
	
	
	
}
