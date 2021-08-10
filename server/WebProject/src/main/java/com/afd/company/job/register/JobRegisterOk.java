package com.afd.company.job.register;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * get방식으로 넘어온 채용 공고의 내용들을 dto에 담아 db에 추가해주기위해
 * DAO를 통해 DB연결과 반환된 값을 (1or0)을 통해 등록이 잘 되었는지 확인할 수 있다. 
 * @author 3조
 *
 */
@WebServlet("/main/company/job/register/jobregisterok.do")
public class JobRegisterOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		
		String companySeq = session.getAttribute("companySeq").toString();

		String postName = null;
		String jobGroup = null;
		String career = null;
		String educationLevel = null;
		String jobType = null;
		String salary = null;
		//attachedFile = req.getParameter("attachedFile");
		String postContent = null;
		String startDate = null;
		String endDate = null;
		
		String city = null;
		String gu = null;
		String dong = null;
		String address = null;
		String latitude = null;
		String longitude = null;
		
		
		ServletContext application = getServletContext();

	    String path = application.getRealPath("/files");
	    // System.out.println(path);
	    
	    //2. 업로드 파일의 최대 크기 지정 
	    // - 최대한 작게 
	    // - 바이트 단위 
	    int size = 1024 * 1024 * 100; // 100MB
	    
	    //3. 변수 선언 

	    String filename = ""; //첨부파일명
	    String orgfilename = ""; // 첨부파일명
	    

	    
	    //서버가 보낸 한글 데이터를 안깨지도록 인코딩 
		req.setCharacterEncoding("UTF-8");

	    
	    try{
	       //파일 업로드 처리 -> 외부 입출력 -> try 필수 
	       
	       // request -> MultipartRequest
	       //com.oreilly.servlet.MultipartRequest();
	       //이 객체를 생성하는 순간 업로드된 파일은 처리를 마치고 첨부파일 폴더에 저장되어 있다.
	       MultipartRequest multi = new MultipartRequest(
			                             req, // 기존의 request Wrapping 클래스 
			                             path, //업로드 폴더 지정 
			                             size, // 업로드 크기 지정 
			                             "UTF-8", //인코딩 지정 
			                             new DefaultFileRenamePolicy()
	                            	);
	       

			postName = multi.getParameter("postName");
			jobGroup = multi.getParameter("jobGroup");
			career = multi.getParameter("career");
			educationLevel = multi.getParameter("educationLevel");
			jobType = multi.getParameter("jobType");
			salary = multi.getParameter("salary");
			//attachedFile = req.getParameter("attachedFile");
			postContent = multi.getParameter("postContent");
			startDate = multi.getParameter("startDate");
			endDate = multi.getParameter("endDate");
			
			city = multi.getParameter("city");
			gu = multi.getParameter("gu");
			dong = multi.getParameter("dong");
			address = multi.getParameter("address");
			latitude = multi.getParameter("latitude");
			longitude = multi.getParameter("longitude");

	       
	       //실제로 저장된 파일명(넘버링O)
	       filename = multi.getFilesystemName("attachedFile"); // <input type="file" name="attach">
	        
	       //사용자가 올린 파일명 (넘버링X)
	       orgfilename = multi.getOriginalFileName("attachedFile");

	    		   
	    } catch(Exception e){
	    	System.out.println("파일 올리기 실패");
	       System.out.println(e);
	    }
	    

       String attachedFile= orgfilename;
		
		
		//System.out.println("파일 이름2"+part.getName());
		System.out.println("파일 이름: "+attachedFile);
		
		

		PostDAO dao = new PostDAO();
		
		PostDTO dto = new PostDTO();
		
		dto.setCompanySeq(companySeq);
		dto.setPostName(postName);
		dto.setJobGroup(jobGroup);
		dto.setCareer(career);
		dto.setEducationLevel(educationLevel);
		dto.setJobType(jobType);
		dto.setSalary(salary);
		dto.setAttachedFile(attachedFile);
		dto.setPostContent(postContent);
		dto.setStartDate(startDate);
		dto.setEndDate(endDate);

		int result = dao.add(dto);
		PostDTO num = dao.findlastPost(); //제일 마지막에 insert된 공고 번호
		
		String jobPostSeq = num.getJobPostSeq();
		
		System.out.println("추가된 공고번호"+jobPostSeq);
		if (result > 0) {
			System.out.println("채용공고 인서트 성공");
		}else {
			System.out.println("채용공고 인서트 실패");
		}
		
		

		
		LocationDTO locdto = new LocationDTO();
		locdto.setJobPostSeq(jobPostSeq);
		locdto.setCity(city);
		locdto.setGu(gu);
		locdto.setDong(dong);
		locdto.setAddress(address);
		locdto.setLatitude(latitude);
		locdto.setLongitude(longitude);
		
		int locresult = dao.locAdd(locdto);
	
		
		if (locresult > 0) {
			System.out.println("위치 인서트 성공");
			resp.sendRedirect("/webproject/main/company/job/manage/companylist.do");
		}else {
			System.out.println("위치 인서트 실패");
			resp.sendRedirect("/webproject/main/company/job/register/jobregister.do");
		}
		

	}


}