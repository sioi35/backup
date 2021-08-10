package com.test.practice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/practice/admin.do")
public class Admin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		if(!session.getAttribute("id").equals("admin")) {
			
			resp.sendRedirect("/jsp/practice/login.do");
			return;
			
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/practice/admin.jsp");
		dispatcher.forward(req, resp);

	}

}
