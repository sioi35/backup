package com.afd.company;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 기업사용자가 보는 메인화면 클래스
 * id, pw를 입력하여 로그인 후 보게 되는 화면
 * 로그인 성공하면 session에 해당 사용자의 정보를 저장후
 * CompanyList 서블릿을 불러옴
 * @author 3조
 *
 */

@WebServlet("/main/company/companymain.do")
public class CompanyMain extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      String id = req.getParameter("id");
      String pw = req.getParameter("pw");
      
      CompanyDAO dao = new CompanyDAO();
      
      CompanyDTO dto = new CompanyDTO();
      dto.setId(id);
      dto.setPw(pw);
      
      CompanyDTO result = dao.login(dto);
      
      if(result != null) {
         //인증 > 티켓 발급
         HttpSession session = req.getSession();
         
         session.setAttribute("id", result.getId()); //인증 티켓
         
         //부가정보
         session.setAttribute("name", result.getName());
         session.setAttribute("companySeq", result.getCompanySeq());
         
         RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/company/companymain.jsp");
         dispatcher.forward(req, resp);
         
      }else {
         resp.sendRedirect("/webproject/main/login/login.do");
      }

      

   }

}