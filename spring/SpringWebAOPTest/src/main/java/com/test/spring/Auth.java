package com.test.spring;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Auth {
	
	//주업무 지정
	@Pointcut("execution(public String com.test.spring.AOPController.member*(..))")
	public void member() {}

	//보조업무
	@Before("member()")
	public void check(JoinPoint joinPoint) {
		//System.out.println("로그인 유무를 검사합니다.");
		
		//글쓰기에 접속한 사람이 로그인을 했는지 유무??
		// -> session 필요
		
		Object[] args = joinPoint.getArgs();
		
		//org.apache.catalina.connector.RequestFacade@71ab10a4 > Request
		//org.apache.catalina.connector.ResponseFacade@6d358a91 > Response
		//org.apache.catalina.session.StandardSessionFacade@47f57d94 > Session
		//for(Object obj : args) {
		//	System.out.println(obj);
		//}
		
		//보조업무 객체내에서 request, response, session 등을 얻어오는 방법!!
		HttpSession session = (HttpSession)joinPoint.getArgs()[2];
		HttpServletResponse resp = (HttpServletResponse)joinPoint.getArgs()[1];
		
		//미인증 사용자
		if(session.getAttribute("id") == null) {
			
			try {
				
				resp.setCharacterEncoding("UTF-8");
				PrintWriter writer = resp.getWriter();
				
				writer.println("<html>");
				writer.println("<head>");
				writer.println("<meta charset='UTF-8'>");
				writer.println("</head>");
				writer.println("<body>");
				writer.println("<script>");
				writer.println("alert('회원 전용 기능입니다.');");
				writer.println("location.href='/spring/list.action';");
				writer.println("</script>");
				writer.println("</body>");
				writer.println("</html>");
				
				writer.close();
				
			} catch (Exception e) {
				System.out.println("Auth.check()");
				e.printStackTrace();
			}
			
		}
		
		
		
	}

}
