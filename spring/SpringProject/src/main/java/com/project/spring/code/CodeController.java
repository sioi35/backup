package com.project.spring.code;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CodeController {
	
	@RequestMapping(value = "/code/codelist.action", method = { RequestMethod.GET })
	public String codelist(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		

		return "code/codelist";
	}

}
