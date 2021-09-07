package com.project.spring;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@Autowired
	private MemberDAO dao;
	
	@RequestMapping(value = "/index.action", method = { RequestMethod.GET })
	public String index(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		return "index";
	}
	
	@RequestMapping(value = "/main.action", method = { RequestMethod.GET })
	public String main(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		
		return "main";
	}
	
	@RequestMapping(value = "/signin.action", method = { RequestMethod.GET })
	public void signin(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String loginId) {
		
		//로그인 성공 -> 회원의 정보 반환
		String id = dao.signin(loginId);
		
		if (id != null) {
			
			session.setAttribute("id", id); //인증 티켓
			
			try {
				resp.sendRedirect("/spring/main.action");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	@RequestMapping(value = "/signout.action", method = { RequestMethod.GET })
	public void signout (HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		
		session.removeAttribute("id"); //인증 티켓 제거(로그아웃)
		
		try {
			resp.sendRedirect("/spring/index.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
