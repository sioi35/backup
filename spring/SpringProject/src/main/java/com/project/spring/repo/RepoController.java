package com.project.spring.repo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RepoController {
	
	@Autowired
	private RepoDAO dao;
	
	@RequestMapping(value = "/repo/repolist.action", method = { RequestMethod.GET })
	public String repolist(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		
		String id = session.getAttribute("id").toString();
		
		List<RepoDTO> list = dao.repolist(id);
		
		req.setAttribute("list", list);
		req.setAttribute("id", id);
		
		return "repo/repolist";
	}
	
	@RequestMapping(value = "/repo/repoadd.action", method = { RequestMethod.POST })
	@ResponseBody
	public int repoAdd(HttpServletRequest req, HttpServletResponse resp, HttpSession session, RepoDTO dto) {

		return dao.repoAdd(dto);
	}

	@RequestMapping(value = "/repo/repoview.action", method = { RequestMethod.GET })
	public String repoview(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String repoSeq) {
		
			

		return "repo/repoview";
	}
	
}
