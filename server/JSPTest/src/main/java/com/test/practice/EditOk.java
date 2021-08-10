package com.test.practice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/practice/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		
		
		//수정한 데이터 가져오기
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String birth = req.getParameter("birth");
		
		
		//DB연결 -> Update
		
		DAO dao = new DAO();
		
		int result = dao.update(id,name,tel,birth);
		
		if(result == 1) {
			req.setAttribute("result", result);
		}
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/practice/editok.jsp");
		dispatcher.forward(req, resp);

	}

}
