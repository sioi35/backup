package com.afd.company.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.afd.company.CompanyDAO;
import com.afd.company.CompanyDTO;

/** 
 * 기업회원의 프로필을 확인하기 위한 서블릿
 * 세션에 저장되어있는 회사 고유번호를 가져와 dao를 통해 해당 기업의 프로필을 불러온다.
 * @author 3조
 *
 */
@WebServlet("/main/company/mypage/profile.do")
public class Profile extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		HttpSession session = req.getSession();
		
		String companySeq = session.getAttribute("companySeq").toString();
		System.out.println(companySeq);
		
		CompanyDAO dao = new CompanyDAO();
		
		CompanyDTO dto = dao.profile(companySeq);
		
		req.setAttribute("dto", dto);
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/company/mypage/profile.jsp");
		dispatcher.forward(req, resp);

	}

}
