package com.afd.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/main/admin/adminmain.do")
public class AdminMain extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		AdminDAO dao = new AdminDAO();
		AdminDTO dto = new AdminDTO();
		
		dto.setId(id);
		dto.setPw(pw);
		
		
		AdminDTO result = dao.login(dto);
		
		if (result != null) {
			//인증 > 티켓 발급
			HttpSession session = req.getSession();
			
			session.setAttribute("id", result.getId()); //인증 티켓
			
			//부가정보
			session.setAttribute("adminSeq", result.getAdminSeq());
			
		
		} else {
			System.out.println("null");
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/admin/adminmain.jsp");
		dispatcher.forward(req, resp);

	}

}
