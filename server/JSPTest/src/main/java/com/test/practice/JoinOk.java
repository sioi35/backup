package com.test.practice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/practice/joinok.do")
public class JoinOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		//회원가입 정보 가져오기		
		String id = req.getParameter("id"); 
		String pw = req.getParameter("pw"); 
		String name = req.getParameter("name"); 
		String tel = req.getParameter("tel"); 
		String birth = req.getParameter("birth"); 
		
		//DB 연결
		DAO dao = new DAO();
		
		
		//객체 호출 > 인자값 넘겨주기
		DTO dto = new DTO();
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		dto.setTel(tel);
		dto.setBirth(birth);
		
		int result = dao.join(dto);
		
		req.setAttribute("result", result);
		System.out.println(result);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/practice/joinok.jsp");
		dispatcher.forward(req, resp);

	}

}