package com.project.spring.skill;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SkillController {
	
	@RequestMapping(value = "/skill/skilltree.action", method = { RequestMethod.GET })
	public String skilltree(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		

		return "skill/skilltree";
	}

}
