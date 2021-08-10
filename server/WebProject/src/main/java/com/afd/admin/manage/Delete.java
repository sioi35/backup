package com.afd.admin.manage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main/admin/manage/delete.do")
public class Delete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memberSeq = req.getParameter("memberSeq");
		
		MemberManageDAO dao = new MemberManageDAO();
		
		int result = dao.deleteMember(memberSeq);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/admin/manage/delete.jsp");
		dispatcher.forward(req, resp);
	}

}
;
