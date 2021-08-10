package com.afd.member.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main/member/mypage/myprofile.do")
public class MyProfile extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MyPageDAO dao = new MyPageDAO();
		MyPageDTO dto = new MyPageDTO();
		
		HttpSession session = req.getSession();
		
		dto.setId(session.getAttribute("id").toString());
		dto.setMemberSeq(session.getAttribute("memberSeq").toString());
		
		MyPageDTO myProfileList = dao.myProfileList(dto);
		MyPageDTO qnaScrapCount = dao.qnaScrapCount(dto);
		MyPageDTO studyScrapCount = dao.studyScrapCount(dto);
		MyPageDTO comScrapCount = dao.comScrapCount(dto);
		MyPageDTO jobPostScrapCount = dao.jobPostScrapCount(dto);
		MyPageDTO spaceScrapCount = dao.spaceScrapCount(dto);
		
		req.setAttribute("myProfileList", myProfileList);
		req.setAttribute("qnaScrapCount", qnaScrapCount);
		req.setAttribute("studyScrapCount", studyScrapCount);
		req.setAttribute("comScrapCount", comScrapCount);
		req.setAttribute("jobPostScrapCount", jobPostScrapCount);
		req.setAttribute("spaceScrapCount", spaceScrapCount);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/mypage/myprofile.jsp");
		dispatcher.forward(req, resp);

	}

}