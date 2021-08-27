package com.test.spring;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemoController {

	@Autowired
	private MemoDAO dao; //여러 업무에서 공통으로 사용할 자원
	
	// 템플릿
	@RequestMapping(value = "/template.memo", method = { RequestMethod.GET })
	public String template(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		System.out.println("테스트");

		return "template";
	}

	// 메모 목록
	@RequestMapping(value = "/list.memo", method = { RequestMethod.GET })
	public String list(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String category) {

		//1. DB 작업 > DAO 위임 > select
		//2. JSP 호출하기 + 결과 전달
		
		//null or ""
		//System.out.println("category: " + category);
		
		ArrayList<MemoDTO> list = dao.list(category);
		
		req.setAttribute("list", list);
		
		return "list";
	}

	// 메모 쓰기(폼)
	@RequestMapping(value = "/add.memo", method = { RequestMethod.GET })
	public String add(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		return "add";
	}

	// 메모 쓰기(처리)
	@RequestMapping(value = "/addok.memo", method = { RequestMethod.POST })
	public String addok(HttpServletRequest req, HttpServletResponse resp, HttpSession session, MemoDTO dto) {

		//1. 데이터 가져오기
		//2. DB작엽 > DAO 위임
		//3. JSP 호출하기 + 결과 처리
		
		
		//1. 데이터 매개변수로 받기
		
		//2. (DAO 멤버변수로 지정)
		int result = dao.add(dto); //업무위임
		
		//3.
		req.setAttribute("result", result);
		
		return "addok";
	}
	
	// 메모 삭제(처리)
	@RequestMapping(value = "/delok.memo", method = { RequestMethod.GET })
	public void delok(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String seq) {
		
		//1. 데이터 가져오기(seq)
		//2. DB 작업 > DAO 위임 > delete
		//3. 결과 처리
		
		//1. 
		
		//2. 
		int result = dao.del(seq);
		
		//3.
		try {
			resp.sendRedirect("/spring/list.memo");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
