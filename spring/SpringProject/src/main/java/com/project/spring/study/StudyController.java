package com.project.spring.study;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.spring.FieldDTO;
import com.project.spring.MemberDTO;

@Controller
public class StudyController {
	
	@Autowired
	private StudyDAO dao;
	
	@RequestMapping(value = "/study/studylist.action", method = { RequestMethod.GET })
	public String studylist(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String page, String sword, String sfield) {
		
		//분야 리스트
		List<FieldDTO> flist = dao.getFieldList();
		
		HashMap<String, String> smap = new HashMap<String, String>();
		
		//검색
		smap.put("sword", sword);
		smap.put("sfield", sfield);
	
		// 페이징 처리
		int nowPage = 0;		//현재 페이지 번호		
		int totalCount = 0;		//총 게시물 	
		int pageSize = 8;		//한 페이지 당 출력할 게시물 수	 	
		int totalPage = 0;		//총 페이지 수	
		int begin = 0;			//가져올 게시물 시작 위치	
		int end = 0;			//가져올 게시물 끝 위치	
		int n = 0;				//페이지바 제작
		int loop = 0;			//페이지바 제작
		int blockSize = 5;		//페이지바 제작 (페이지바에서 보이는 페이지 개수)
		
		if(page == null || page.equals("")) {
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
		
		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;
		
		smap.put("begin", begin + ""); //begin은 문자열이므로 "" 플러스
		smap.put("end", end + "");
		
		List<StudyDTO> list = dao.studyList(smap);
		
		totalCount = dao.getStudyTotal(smap);

		totalPage = (int)Math.ceil((double)totalCount / pageSize);
		
		String pagebar = "<nav>\r\n"
				+ "				<ul class=\"pagination\">";

		
		loop = 1; //while 루프 변수
		n = ((nowPage - 1) / blockSize) * blockSize + 1; //출력되는 페이지 번호
		
		
		if(n == 1) {
			pagebar += String.format(" <li class='disabled'><a href='#!' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a></li> ");			
		} else {
			pagebar += String.format(" <li><a href='/spring/study/studylist.action?page=%d&sword=%s&sfield=%s' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a></li> ", n - 1, sword, sfield);			
		}
		

		if(totalPage == 0) {
			pagebar += " <li class='active'><a href='#!'>1</a></li> ";
		}
		
		if(sword == null) sword = "";
		if(sfield == null) sfield = "";
		
		while (!(loop > blockSize || n > totalPage)) {

			if (n == nowPage) {
				pagebar += String.format(" <li class='active'><a href='#!'>%d</a></li> ", n);
			} else {
				pagebar += String.format(" <li><a href='/spring/study/studylist.action?page=%d&sword=%s&sfield=%s'>%d</a></li> ", n, sword, sfield, n);
			}

			loop++;
			n++;
		}
		
	
		if(n > totalPage) {
			pagebar += String.format(" <li class='disabled'><a href='#!' aria-label='Next'> <span aria-hidden='true'>&raquo;</span></a></li> ");			
		} else {
			pagebar += String.format(" <li><a href='/spring/study/studylist.action?page=%d&sword=%s&sfield=%s' aria-label='Next'> <span aria-hidden='true'>&raquo;</span></a></li> ", n, sword, sfield);			
		}
		
		pagebar += "</ul>\r\n"
				+ "			</nav>";
		
		
		for (StudyDTO dto : list) {
			
			String content = dto.getContent();

		    //내용이 길면 자르기
			if(content.length() > 37) {
				content = content.substring(0, 37) + "..";
				dto.setContent(content);
			}
			//내용 개행 처리
			dto.setContent(content.replace("\n", "<br>"));
		      
		    //시작날짜, 종료날짜 시간 제외하고 날짜까지만 출력
		    dto.setStartDate(dto.getStartDate().substring(0, 11));
		    dto.setEndDate(dto.getEndDate().substring(0, 11));
		}
		
		req.setAttribute("list", list);
		req.setAttribute("flist", flist);
		req.setAttribute("smap", smap);
		req.setAttribute("pagebar", pagebar);
		req.setAttribute("page", page);

		return "study/studylist";
	}
	
	@RequestMapping(value = "/study/applylist.action", method = { RequestMethod.GET })
	public String applylist(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String seq) {
		
		List<ApplyListDTO> list = dao.Applylist(seq);
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		// -> 보고 싶은 페이지를 정하기 위한 처리
				int nowPage = 0;		//현재 페이지 번호		
				int totalCount = 0;		//총 게시물 	
				int pageSize = 10;		//한 페이지 당 출력할 게시물 수	 	
				int totalPage = 0;		//총 페이지 수	
				int begin = 0;			//가져올 게시물 시작 위치	
				int end = 0;			//가져올 게시물 끝 위치	
				int n = 0;				//페이지바 제작
				int loop = 0;			//페이지바 제작
				int blockSize = 10;		//페이지바 제작 (페이지바에서 보이는 페이지 개수)
				
				//list.do > list.do?page=1
				//list.do?page=3
				
				String page = req.getParameter("page");
				
				if(page == null || page.equals("")) {
					nowPage = 1;
				} else {
					nowPage = Integer.parseInt(page);
				}
				
				//nowPage > 지금 보게될 페이지 번호
				//1page -> where rnum between 1 and 10
				//2page -> where rnum between 11 and 20
				//3page -> where rnum between 21 and 30
				
				begin = ((nowPage - 1) * pageSize) + 1;
				end = begin + pageSize - 1;
				
				map.put("begin", begin + ""); //begin은 문자열이므로 "" 플러스
				map.put("end", end + "");
				
				
				//총 게시물 수 알아내기
				//totalCount = dao.getTotalCount(map);
				//System.out.println(totalCount); 399개
				
				//총 페이지 수 알아내기
				//399 / 10 = 39.9 > 40
				totalPage = (int)Math.ceil((double)totalCount / pageSize);
				//System.out.println(totalPage); 40페이지
				
				
				
				String pagebar = "<nav>\r\n"
						+ "				<ul class=\"pagination\">";
	
				
				loop = 1; //while 루프 변수
				n = ((nowPage - 1) / blockSize) * blockSize + 1; //출력되는 페이지 번호
				
				
				if(n == 1) {
					pagebar += String.format(" <li class='disabled'><a href='#!' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a></li> ");			
				} else {
					pagebar += String.format(" <li><a href='/myapp/board/list.do?page=%d' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a></li> ", n-1);			
				}
				
				
				
		
				
				if(totalPage ==0) {
					pagebar += " <li class='active'><a href='#!'>1</a></li> ";
				}
				
				while (!(loop > blockSize || n > totalPage)) {

					if (n == nowPage) {
						pagebar += String.format(" <li class='active'><a href='#!'>%d</a></li> ", n);
					} else {
						pagebar += String.format(" <li><a href='/myapp/board/list.do?page=%d'>%d</a></li> ", n, n);
					}

					loop++;
					n++;

				}
				
			
				
				if(n > totalPage) {
					pagebar += String.format(" <li class='disabled'><a href='#!' aria-label='Next'> <span aria-hidden='true'>&raquo;</span></a></li> ");			
				} else {
					pagebar += String.format(" <li><a href='/myapp/board/list.do?page=%d' aria-label='Next'> <span aria-hidden='true'>&raquo;</span></a></li> ", n);			
				}
				
				
				pagebar += "</ul>\r\n"
						+ "			</nav>";
		
		
		for (ApplyListDTO dto : list) {
		      
		    //시작날짜, 종료날짜 시간 제외하고 날짜까지만 출력
		    dto.setRegdate(dto.getRegdate().substring(0, 11));
		}
		
		req.setAttribute("list", list);
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("nowPage", nowPage);
		
		req.setAttribute("pagebar", pagebar);
		
		return "study/applylist";
	}
	


	@RequestMapping(value = "/study/applypopup.action", method = { RequestMethod.GET })
	public String studypopup(HttpServletRequest req, 
							 HttpServletResponse resp, 
							 HttpSession session,
							 String id) {
  
	
		 MemberDTO mdto = dao.get(id); 
		// MemberDTO mdto = dao.
								 
		
																			 
														
   
		
//		for (MemberDTO dto : list) {
//		      
//		    //시작날짜, 종료날짜 시간 제외하고 날짜까지만 출력
//		    dto.setRegdate(dto.getRegdate().substring(0, 11));
//		}
		 
		 mdto.setBirth(mdto.getBirth().substring(0,11));

		//req.setAttribute("list", list);
		req.setAttribute("mdto", mdto);
		
		return "study/applypopup";
	}
	
	@RequestMapping(value = "/study/studyview.action", method = { RequestMethod.GET })
	public String studyview(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String seq, String page, String sword, String sfield) {
		
		ApplyListDTO adto = new ApplyListDTO();
		adto.setStudySeq(seq);
		adto.setId(session.getAttribute("id").toString());
		
		StudyDTO dto = dao.getDetail(adto);
		
		//내용 개행 처리
		dto.setContent(dto.getContent().replace("\n", "<br>"));
		
		//시작날짜, 종료날짜 시간 제외하고 날짜까지만 출력
		dto.setStartDate(dto.getStartDate().substring(0, 11));
		dto.setEndDate(dto.getEndDate().substring(0, 11));
				
		
		req.setAttribute("dto", dto);
		req.setAttribute("page", page);
		req.setAttribute("sword", sword);
		req.setAttribute("sfield", sfield);
		
		return "study/studyview";
	}
	
	@RequestMapping(value = "/study/studyRegist.action", method = { RequestMethod.GET })
	public void studyRegist(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String seq) {
		
		ApplyListDTO adto = new ApplyListDTO();
		adto.setStudySeq(seq);
		adto.setId(session.getAttribute("id").toString());
		
		dao.studyRegist(adto); //스터디 신청(insert)

		try {
			resp.sendRedirect("/spring/study/studyview.action?seq=" + seq);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/study/studyCancel.action", method = { RequestMethod.GET })
	public void studyCancel(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String seq) {
		
		ApplyListDTO adto = new ApplyListDTO();
		adto.setStudySeq(seq);
		adto.setId(session.getAttribute("id").toString());
		
		dao.studyCancel(adto); //스터디 취소(delete)
		
		try {
			resp.sendRedirect("/spring/study/studyview.action?seq=" + seq);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/study/studyAdd.action", method = { RequestMethod.POST })
	@ResponseBody
	public int studyAdd(HttpServletRequest req, HttpServletResponse resp, HttpSession session, StudyDTO dto) {
		
		dto.setId(session.getAttribute("id").toString());
		
		int result = dao.addStudy(dto); //스터디 등록
		
		return result;
   }

}







