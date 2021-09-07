package com.project.spring.skill;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.spring.FieldDTO;

@Controller
public class SkillController {
	
	@Autowired
	private SkillDAO dao;
	
	@RequestMapping(value = "/skill/skilltree.action", method = { RequestMethod.GET })
	public String skilltree(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		//TODO 로그인 유무 확인
		
		//분야 리스트
		List<FieldDTO> flist = dao.flist();
		
		//사용자 관심분야
		String id = session.getAttribute("id").toString();
		FieldDTO userFdto = dao.getUserField(id);
		
		//관심분야 자격증 리스트
		List<LicenseDTO> llist = dao.llist(userFdto.getFieldSeq());
		
		
		req.setAttribute("flist", flist);
		req.setAttribute("userFdto", userFdto);
		req.setAttribute("llist", llist);
		
		return "skill/skilltree";
	}
	
	@RequestMapping(value = "/skill/changeField.action", method = { RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> changeField(@RequestParam("seq") String seq, HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		Map<String, Object> map = new HashMap<String, Object>();
		
		FieldDTO fdto = dao.getField(seq);
		List<LicenseDTO> llist = dao.llist(seq);
		
		map.put("fdto", fdto);
		map.put("llist", llist);

		return map;
	}
	
	@RequestMapping(value = "/skill/skillcheck.action", method = { RequestMethod.GET })
	public String skillcheck(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String seq) {

		//TODO 로그인 유무 확인
		
		FieldDTO fdto = dao.getField(seq);
		
		List<SubjectDTO> slist = dao.slist(seq);
		
		for (SubjectDTO sdto : slist) {
			List<ProblemDTO> plist = dao.plist(sdto.getSubjectSeq());
			Random random = new Random();
			int[] rnum = new int[5];

			for (int i=0; i<5; i++) {
				rnum[i] = random.nextInt(plist.size());
				System.out.println(plist.size());
				boolean isDup = false; //중복여부
				
				for (int j=0; j<i; j++) {
					if (rnum[i] == rnum[j]) {
						isDup = true;
						break;
					}
				}
				
				if (!isDup) {
					sdto.getQlist().add(plist.get(rnum[i]));
				} else {
					i--;
				}
			}
		}
		
		req.setAttribute("fdto", fdto);
		req.setAttribute("slist", slist);
		
		return "skill/skillcheck";
	}

}
