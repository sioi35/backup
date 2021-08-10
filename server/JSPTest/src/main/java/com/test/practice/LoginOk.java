package com.test.practice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/practice/loginok.do") 
public class LoginOk extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 인코딩
		//-> 현재 페이지에서는 한글정보가 없으므로 인코딩 패스!
		//2. id, pw 가져오기
		//3. DB연결
		// 4. 회원이면 로그인 ok (정보 불일치시 로그인화면)


		//2. 데이터 가져오기
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		//3. DB연결
		DAO dao = new DAO();
		
		//객체와 객체간의 호출 > 인자값 전달
		DTO dto = new DTO();
		dto.setId(id);
		dto.setPw(pw);
		
		
		//4. 결과 (데이터 정보 일치한지)
		DTO resultDTO = dao.login(dto);
		
		if(resultDTO != null) {
			
			//로그인 성공
			
			HttpSession session = req.getSession();
			session.setAttribute("id", resultDTO.getId()); //인증 티켓
			
			// 회원의 모든 정보도 같이 session에 담기
			session.setAttribute("name", resultDTO.getName());
			session.setAttribute("tel", resultDTO.getTel());
			session.setAttribute("birth", resultDTO.getBirth());
			
		}
		
	
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/practice/loginok.jsp");
		dispatcher.forward(req, resp);
	
	}

}
