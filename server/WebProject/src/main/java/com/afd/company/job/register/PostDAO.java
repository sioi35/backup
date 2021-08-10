package com.afd.company.job.register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.afd.DBUtil;


/**
 * DB에 연결하여 채용공고를 insert해주는 DAO클래스
 * @author 3조
 *
 */
public class PostDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public PostDAO() {
		
		try {
			conn = DBUtil.open();
		} catch (Exception e) {
			System.out.println("PostDAO.PostDAO()");
			e.printStackTrace();
		}
		
	}

	/**
	 * 
	 * @param dto 채용 공고 내용가 담긴 dto를 매개변수로 받아와 sql문을 실행하여 dto 값들을 테이블에 추가해준다. 
	 * @return insert가 성공/실패했는지 보여주기 위해 integer값을  반환한다.
	 */
	public int add(PostDTO dto) {

		try {
			
			String sql = "INSERT INTO tblJobPost (jobPostSeq, companySeq, postName, regdate, jobGroup, career, educationLevel, jobType, salary, attachedFile, postContent, startDate, endDate) "
					+ "values (jobPostSeq.nextVal, ?, ?, default, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getCompanySeq());
			pstat.setString(2, dto.getPostName());
			pstat.setString(3, dto.getJobGroup());
			pstat.setString(4, dto.getCareer());
			pstat.setString(5, dto.getEducationLevel());
			pstat.setString(6, dto.getJobType());
			pstat.setString(7, dto.getSalary());
			pstat.setString(8, dto.getAttachedFile());
			pstat.setString(9, dto.getPostContent());
			pstat.setString(10, dto.getStartDate());
			pstat.setString(11, dto.getEndDate());
			

			return pstat.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("PostDAO.add()");
			e.printStackTrace();
		}
		
		
		return 0;
	}

	/**
	 * 
	 * @param locdto 채용공고의 위치(기업)가 담긴 dto를 테이블에 insert시켜준다.
	 * @return integer값을 반환함으로써 결과를 나타내어 준다.
	 */
	public int locAdd(LocationDTO locdto) {

		try {

			String sql = "insert into tblJobLocation VALUES "
					+ "(jobLocSeq.nextval, ?, ?, ?, ?, ?, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, locdto.getJobPostSeq());
			pstat.setString(2, locdto.getCity());
			pstat.setString(3, locdto.getGu());
			pstat.setString(4, locdto.getDong());
			pstat.setString(5, locdto.getAddress());
			pstat.setString(6, locdto.getLatitude());
			pstat.setString(7, locdto.getLongitude());

			return pstat.executeUpdate();

			
		} catch (Exception e) {
			System.out.println("PostDAO.locAdd()");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 제일 마지막에 insert된 채용 공고를 찾기 위한 메소드로 
	 * 찾은 메소드의 내용을 반환
	 * @return 채용공고 내용이 담긴 dto를 반환해준다.
	 */
	public PostDTO findlastPost() {

		try {
			
			String sql = "select max(jobPostSeq) as jobPostSeq from tblJobPost";
			
			pstat = conn.prepareStatement(sql);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				
				PostDTO dto = new PostDTO();
				
				dto.setJobPostSeq(rs.getString("jobPostSeq"));
				
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println("PostDAO.findlastPost()");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 
	 * @param jobPostSeq 채용공고번호를 매개변수로 받아 해당 공고의 내용을 select하여 반환해준다.
	 * @return 공고의 내용을 담은 dto를 반환한다.
	 */
	public PostDTO postInfo(String jobPostSeq) {

		try {
			
			String sql = "select * from vwJobView where jobPostSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, jobPostSeq);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				
				PostDTO dto = new PostDTO();
				
				dto.setJobPostSeq(rs.getString("jobPostSeq"));
				dto.setPostName(rs.getString("postName"));
				dto.setCareer(rs.getString("career"));
				dto.setEducationLevel(rs.getString("educationLevel"));
				dto.setJobGroup(rs.getString("jobGroup"));
				dto.setSalary(rs.getString("salary"));
				dto.setJobType(rs.getString("jobType"));
				dto.setAttachedFile(rs.getString("attachedFile"));
				dto.setPostContent(rs.getString("postContent"));
				dto.setPostName(rs.getString("postName"));
				dto.setStartDate(rs.getString("startDate"));
				dto.setEndDate(rs.getString("endDate"));
				
				dto.setJobLocSeq(rs.getString("jobLocSeq"));
				dto.setCity(rs.getString("city"));
				dto.setGu(rs.getString("gu"));
				dto.setDong(rs.getString("dong"));
				dto.setAddress(rs.getString("address"));
				dto.setLatitude(rs.getString("latitude"));
				dto.setLongitude(rs.getString("longitude"));
								
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println("PostDAO.postInfo()");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 채용공고의 내용을 수정하기 위한 메소드
	 * @param dto 채용 공고를 수정하기위해 수정 내용이 담긴 dto를 매개변수로 받는다.
	 * @return 수정이 완료되었는지는 integer값을 통해 반환해준다.
	 */
	public int edit(PostDTO dto) {

		try {
			String sql = "update tblJobPost set postName = ?, jobGroup=?, career=?, educationLevel=?, jobType=?,salary=?,attachedFile=?,postContent=?,startDate=?,endDate=? where jobPostSeq =?";
		
			pstat = conn.prepareStatement(sql);
						
			pstat.setString(1, dto.getPostName());
			pstat.setString(2, dto.getJobGroup());
			pstat.setString(3, dto.getCareer());
			pstat.setString(4, dto.getEducationLevel());
			pstat.setString(5, dto.getJobType());
			pstat.setString(6, dto.getSalary());
			pstat.setString(7, dto.getAttachedFile());
			pstat.setString(8, dto.getPostContent());
			pstat.setString(9, dto.getStartDate());
			pstat.setString(10, dto.getEndDate());
			pstat.setString(11, dto.getJobPostSeq());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("PostDAO.edit()");
			e.printStackTrace();
		}
		
		return 0;
	
	}

	/**
	 * 채용공고의 위치를수정하기 위한 메소드
	 * @param dto 위치를 수정하기위해 수정 내용이 담긴 dto를 매개변수로 받는다.
	 * @return 수정이 완료되었는지는 integer값을 통해 반환해준다.
	 */
	public int locedit(LocationDTO locdto) {


		try {
			String sql = "update tblJobLocation set city = ?, gu=?, dong=?, address=?, latitude=?, longitude=? where jobPostSeq =?";
		
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, locdto.getCity());
			pstat.setString(2, locdto.getGu());
			pstat.setString(3, locdto.getDong());
			pstat.setString(4, locdto.getAddress());
			pstat.setString(5, locdto.getLatitude());
			pstat.setString(6, locdto.getLongitude());
			pstat.setString(7, locdto.getJobPostSeq());

			return pstat.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("PostDAO.locedit()");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 채용 공고를 삭제하기 위해서는 채용 공고를 스크랩한 사람, 지원한 사람, 해당 공고에 위치를 담은 컬럼도 함께 삭제해주어야 한다.
	 * @param jobPostSeq 삭제할 공고 번호를 매개변수로 받는다
	 * @return 결과는 integer값으로 반환시켜준다.
	 */
	public int postDelete(String jobPostSeq) {

		try {
			
			postScrapDelete(jobPostSeq);
			postSeekerDelete(jobPostSeq);
			postLocDelete(jobPostSeq);
			
			String sql = "delete from tblJobPost where jobPostSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, jobPostSeq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("PostDAO.postDelete()");
			e.printStackTrace();
		}
		
		return 0;
	}

	private void postLocDelete(String jobPostSeq) {

		try {
			
			String sql = "delete from tblJobLocation where jobPostSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, jobPostSeq);
			
			pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("PostDAO.postDelete()");
			e.printStackTrace();
		}
		
	}

	private void postSeekerDelete(String jobPostSeq) {
		
		try {
			
			String sql = "delete from tblJobSeekerInfo where jobPostSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, jobPostSeq);
			
			pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("PostDAO.postDelete()");
			e.printStackTrace();
		}
		
	}

	private void postScrapDelete(String jobPostSeq) {
		
		try {
			
			String sql = "delete from tblJobPostScrap where jobPostSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, jobPostSeq);
			
			pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("PostDAO.postDelete()");
			e.printStackTrace();
		}
		
	}
	
}
