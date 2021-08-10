package com.test.practice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/practice/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//DB연결
		//회원정보 가져오기
		
		//1. DB 연결
		DAO dao = new DAO();
		
		ArrayList<DTO> list = new ArrayList<DTO>();
		
		dao.list(list);
		
		if(list != null) {
			req.setAttribute("list", list);
			
		}
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/practice/list.jsp");
		dispatcher.forward(req, resp);

	}

}
