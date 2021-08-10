package com.afd.member.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.afd.member.MemberDAO;
import com.afd.member.MemberDTO;
import com.afd.member.qna.QnaDTO;

@WebServlet("/main/member/mypage/mypagemain.do")
public class MypageMain extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MyPageDAO dao = new MyPageDAO();
		MyPageDTO dto = new MyPageDTO();
		
		HttpSession session = req.getSession();
		String memberSeq = session.getAttribute("memberSeq").toString();
		
		dto.setId(session.getAttribute("id").toString());
		dto.setMemberSeq(session.getAttribute("memberSeq").toString());
		
		MyPageDTO list = dao.list(dto);
		MyPageDTO qnaScrapCount = dao.qnaScrapCount(dto);
		MyPageDTO studyScrapCount = dao.studyScrapCount(dto);
		MyPageDTO comScrapCount = dao.comScrapCount(dto);
		MyPageDTO jobPostScrapCount = dao.jobPostScrapCount(dto);
		MyPageDTO spaceScrapCount = dao.spaceScrapCount(dto);
		MyJobDAO jobdao = new MyJobDAO();
		ArrayList<MyJobDTO> joblist = jobdao.list(memberSeq);
	      
      	req.setAttribute("joblist", joblist);
		req.setAttribute("list", list);
		req.setAttribute("qnaScrapCount", qnaScrapCount);
		req.setAttribute("studyScrapCount", studyScrapCount);
		req.setAttribute("comScrapCount", comScrapCount);
		req.setAttribute("jobPostScrapCount", jobPostScrapCount);
		req.setAttribute("spaceScrapCount", spaceScrapCount);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/mypage/mypagemain.jsp");
		dispatcher.forward(req, resp);

	}

}
