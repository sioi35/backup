package com.afd.member.mypage.myscrap;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main/member/mypage/myscrap/qnalist.do")
public class QnaList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MyScrapDAO dao = new MyScrapDAO();
		MyScrapDTO dto = new MyScrapDTO();
		
		HttpSession session = req.getSession();

		dto.setId(session.getAttribute("id").toString());
		dto.setMemberSeq(session.getAttribute("memberSeq").toString());
		
//		System.out.println("memberSeq: " + dto.getMemberSeq());
		
		MyScrapDTO list = dao.list(dto);
		ArrayList<MyScrapDTO> scrapList = dao.scrapList(dto);
		MyScrapDTO scrapCount = dao.scrapCount(dto);
		
		req.setAttribute("list", list);
		req.setAttribute("scrapList", scrapList);
		req.setAttribute("scrapCount", scrapCount);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/mypage/myscrap/qnalist.jsp");
		dispatcher.forward(req, resp);
	}

}
;
