package com.test.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/auth/member.do")
public class Member extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//인증받지 못한 사용자를 쫓아내기!!
		HttpSession session = req.getSession();
		
		if(session.getAttribute("id") == null) {
			//로그인 안한 사람!
			resp.sendRedirect("/jsp/auth/login.do");
			return;
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/auth/member.jsp");
		dispatcher.forward(req, resp);

	}

}
