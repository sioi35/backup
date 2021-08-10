package com.afd.company.job.register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 기업 사용자가 새 공고를 등록하기 위한 서블릿으로
 * 다른 일 하지 않고 바로 jsp를 불러온다.
 * @author 3조
 *
 */

@WebServlet("/main/company/job/register/jobregister.do")
public class JobRegister extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/company/job/register/jobregister.jsp");
		dispatcher.forward(req, resp);

	}

}
