package com.afd.company.job.manage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 지원자 정보를 확인하기 위한 클래스
 * 공고 상세히보기 jsp에서 버튼을 클릭하면 실행되는 서블릿
 * 넘어온 공고 번호를 가지고 테이블을 검사하여 해당 공고에 지원한 지원자들의 목록을 확인할 수 있다.
 * @author 3조
 *
 */
@WebServlet("/main/company/job/manage/jobseekerinfo.do")
public class JobSeekerInfo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String jobPostSeq = req.getParameter("jobPostSeq");
		
		SeekerInfoDAO dao = new SeekerInfoDAO();
		
		System.out.println("----------------");
		System.out.println("공고번호"+jobPostSeq);
		ArrayList<SeekerInfoDTO> list = dao.info(jobPostSeq);
		
		if(list == null) {
			System.out.println("지원자 정보 없음");
		}else {
			System.out.println("지원자 정보 있음");
			System.out.println(list.size());
		}


		req.setAttribute("list", list);
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/company/job/manage/jobseekerinfo.jsp");
		dispatcher.forward(req, resp);

	}

}