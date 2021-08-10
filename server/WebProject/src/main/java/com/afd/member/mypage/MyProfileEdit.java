package com.afd.member.mypage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main/member/mypage/myprofileedit.do")
public class MyProfileEdit extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");

		String memberSeq = req.getParameter("memberSeq");
		String career = req.getParameter("career");
		String academicBackground = req.getParameter("academicBackground");
		String gender = req.getParameter("gender");
		String interestOccupation = req.getParameter("interestOccupation");
		String availableLanguage = req.getParameter("availableLanguage");
		String major = req.getParameter("major");
		
		System.out.println("memberSeq: " + memberSeq);
		System.out.println("career: " + career);
		System.out.println("academicBackground: " + academicBackground);
		System.out.println("gender: " + gender);
		System.out.println("interestOccupation: " + interestOccupation);
		System.out.println("availableLanguage: " + availableLanguage); 
		System.out.println("major: " + major);
		
		MyPageDAO dao = new MyPageDAO();
		MyPageDTO dto = new MyPageDTO();
		
		dto.setMemberSeq(memberSeq);
		dto.setCareer(career);
		dto.setAcademicBackground(academicBackground);
		dto.setGender(gender);
		dto.setInterestOccupation(interestOccupation);
		dto.setAvailableLanguage(availableLanguage);
		dto.setMajor(major);
		
		int result = dao.myProfileEdit(dto);
		
		System.out.println("result: " + result);
		
		if (result == 1) {
			resp.sendRedirect("/webproject/main/member/mypage/mypagemain.do");
		} else {
			resp.setCharacterEncoding("UTF-8");
			
			PrintWriter writer = resp.getWriter();			
			
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('프로필 수정 실패');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");
			
			writer.close();
		}

	}

}
