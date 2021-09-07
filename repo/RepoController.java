package com.project.spring.repo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.spring.MemberDTO;

@Controller
public class RepoController {
	
	@Autowired
	private RepoDAO dao;
	
	//자신의 로컬 경로에 맞게 수정!!!
	private static final String FILE_PATH="C:\\class\\spring\\SpringProject\\src\\main\\webapp\\resources\\upload";
	//private static final String FILE_PATH="D:\\springProject\\SpringProject\\src\\main\\webapp\\resources\\upload";
	
	@RequestMapping(value = "/repo/repolist.action", method = { RequestMethod.GET })
	public String repolist(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		
		String id = session.getAttribute("id").toString();
		
		MemberDTO member = dao.minfo(id); 
		
		List<RepoDTO> list = dao.repolist(id);
		
		req.setAttribute("list", list);
		req.setAttribute("id", id);
		req.setAttribute("member", member);
		
		return "repo/repolist";
	}
	
	@RequestMapping(value = "/repo/repoadd.action", method = { RequestMethod.POST })
	@ResponseBody
	public int repoAdd(HttpServletRequest req, HttpServletResponse resp, HttpSession session, RepoDTO dto) {

		return dao.repoAdd(dto);
	}

	@RequestMapping(value = "/repo/repoview.action", method = { RequestMethod.GET })
	public String repoview(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String reposeq) {
		
		List<FileDTO> list = dao.fileview(reposeq);	
		req.setAttribute("list", list);
		req.setAttribute("reposeq", reposeq);

		return "repo/repoview";
	}
	
	@RequestMapping(value = "/repo/codeview.action", method = { RequestMethod.GET })
	public String codeview(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String fileseq) {
		
		
		FileDTO filedto = dao.codeview(fileseq);
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH + '\\' + filedto.getFileName()));
			String line = "";
			String content="";
			try {
				while ((line = reader.readLine()) != null) {

					line = line.replace("&", "&amp;");
					line = line.replace(" ", "&nbsp;");
					line = line.replace("<", "&lt;");
					line = line.replace(">", "&gt;");
					content += line + "\r\n";
					
				}
				
				req.setAttribute("content", content);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		req.setAttribute("filedto", filedto);
		
		return "repo/codeview";
	}
	
	@RequestMapping(value = "/repo/editcode.action", method = { RequestMethod.POST })
	@ResponseBody
	public int editcode(HttpServletRequest req, HttpServletResponse resp, HttpSession session, FileDTO dto, String content) {

		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH + '\\' + dto.getFileName()));
			
			writer.write(content);
			
			writer.close();
			
			return 1;
			
		} catch (IOException e) {
			e.printStackTrace();
			
			return 0;
		}
		
	}


	@RequestMapping(value = "/repo/upload.action")
	public void upload(@RequestParam("uploadFile") MultipartFile file, 
						 ModelAndView mv, Model model,
						 @RequestParam("content") String content,
						 @RequestParam("repoSeq") String repoSeq,
						 HttpServletResponse resp) throws IllegalStateException, IOException {
		
		if(!file.getOriginalFilename().isEmpty()) {
			file.transferTo(new File(FILE_PATH, file.getOriginalFilename()));
			model.addAttribute("msg", "File uploaded successfully.");
			
			String fileName = file.getOriginalFilename();
			
			FileDTO dto = new FileDTO();

			dto.setFileName(fileName);
			dto.setRepoSeq(repoSeq);
			dto.setContent(content);
			
			int result = dao.codeadd(dto);
			
			System.out.println(result);
			
			resp.sendRedirect("/spring/repo/repoview.action?reposeq="+repoSeq);
			
		}else {
			model.addAttribute("msg", "Please select a valid mediaFile..");
			resp.sendRedirect("/spring/repo/repoview.action");
		}
		
	}
	
	
}












