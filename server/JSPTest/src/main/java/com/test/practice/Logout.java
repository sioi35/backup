package com.test.practice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/practice/logout.do")
public class Logout extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//인증티켓 제거(로그아웃)
		
		HttpSession session = req.getSession();
		
		
		session.removeAttribute("id"); //인증 티켓 삭제 == 로그아웃
		session.removeAttribute("name");
		session.removeAttribute("tel");
		session.removeAttribute("birth");
		
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/practice/logout.jsp");
		dispatcher.forward(req, resp);

	}

}
