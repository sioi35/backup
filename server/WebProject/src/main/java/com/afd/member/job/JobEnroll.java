package com.afd.member.job;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 원하는 채용공고의 등록하는 클래스
 * 서버는 채용공고 번호를 request변수에 담아 jobenroll.jsp에 넘겨준다.
 * @author 3조
 *
 */

@WebServlet("/main/member/job/jobenroll.do")
public class JobEnroll extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String jobPostSeq = req.getParameter("jobPostSeq");
		
		JobViewDAO dao = new JobViewDAO();
		
		JobDTO dto = dao.enrollView(jobPostSeq);
		
		req.setAttribute("dto", dto);
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/job/jobenroll.jsp");
		dispatcher.forward(req, resp);

	}

}
