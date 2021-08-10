package com.test.practice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/practice/edit.do")
public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		
		DAO dao = new DAO();
		
		DTO result = dao.list_edit(id);
		
		if(result!= null) {
			req.setAttribute("result", result);
		}
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/practice/edit.jsp");
		dispatcher.forward(req, resp);

	}

}