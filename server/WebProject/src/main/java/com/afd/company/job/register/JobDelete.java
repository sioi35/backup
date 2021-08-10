package com.afd.company.job.register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 공고를 삭제하기위한 서블릿
 * 삭제를 원하는 공고 번호를 jsp에 넘겨준다.
 * @author 3조
 *
 */
@WebServlet("/main/company/job/register/jobdelete.do")
public class JobDelete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String jobPostSeq = req.getParameter("jobPostSeq");
		
		req.setAttribute("jobPostSeq", jobPostSeq);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/company/job/register/jobdelete.jsp");
		dispatcher.forward(req, resp);

	}

}