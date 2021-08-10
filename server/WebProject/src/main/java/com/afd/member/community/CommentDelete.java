package com.afd.member.community;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/main/member/community/commentdelete.do")
public class CommentDelete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		//할일
		//1. 데이터 가져오기(seq, pseq)
		//2. DB작업 > DAO 위임 > delete
		//3. 결과 처리
		
	
		
		//1.
		String pseq = req.getParameter("pseq"); //보고있던 글번호(= 작성중인 댓글의 부모 글번호)
		String seq = req.getParameter("seq"); //삭제할 댓글 번호
		
		
		//2.
		CommunityDAO dao = new CommunityDAO();
		
		
		int result = dao.delComment(seq);
		
		//3.
		if(result == 1) {
			resp.sendRedirect("/webproject/main/member/community/view.do?seq=" + pseq); //보고 있던 글번호로 가지고 돌아가기
		}else {
			resp.setCharacterEncoding("UTF-8");
			
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('댓글 삭제 실패');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");
			writer.close();
		}


	}

}

