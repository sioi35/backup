package com.project.spring;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
		
		// 세션 체크 (로그인 체크)
		HttpSession session = req.getSession(); 
		String userid = (String) session.getAttribute("id");
		
		// Login false 
		if(userid == null) {
			
			//System.out.println("Interceptor : Session Check Fail");
			resp.setCharacterEncoding("utf-8");
			
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html>");
			writer.print("<head>");
			writer.print("<meta charset='utf-8'>");
			writer.print("</head>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('로그인 후 사용 가능합니다.');");
			writer.print("location.href='/spring/index.action';");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");
			
			writer.close();
			
			//resp.sendRedirect("/spring/index.action");
			
			return false;
			
		} else { // Login true
			return super.preHandle(req, resp, handler);
		}
	}

}
