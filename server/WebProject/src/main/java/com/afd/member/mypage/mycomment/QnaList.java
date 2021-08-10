package com.afd.member.mypage.mycomment;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.afd.member.mypage.MyPageDAO;
import com.afd.member.mypage.MyPageDTO;

@WebServlet("/main/member/mypage/mycomment/qnalist.do")
public class QnaList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MyCommentDAO dao = new MyCommentDAO();
		MyCommentDTO dto = new MyCommentDTO();
		
		HttpSession session = req.getSession();
		
		dto.setMemberSeq(session.getAttribute("memberSeq").toString());
		
		//System.out.println("memberSeq: " + session.getAttribute("memberSeq").toString());
		
		ArrayList<MyCommentDTO> qnaList = dao.qnaList(dto);
		
		for (MyCommentDTO qlist : qnaList) {
			
			String regdate = qlist.getRegdate();
			regdate = regdate.substring(0, 10);
			qlist.setRegdate(regdate);
			
			String title = qlist.getTitle();
			
			title = title.replace("<script", "&lt;script").replace("</script>", "&lt;/script&gt;");
			qlist.setTitle(title);
			
			if (title.length() > 50) {
				title = title.substring(0, 50) + "...";
				qlist.setTitle(title);
			}
			
		}
		
		//System.out.println("qnaList: " + qnaList.toString());
		
		req.setAttribute("qnaList", qnaList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/mypage/mycomment/qnalist.jsp");
		dispatcher.forward(req, resp);

	}

}
