package com.afd.member.job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.catalina.core.ApplicationMappingImpl;

import com.afd.DBUtil;

/**
 * DB연결
 * 채용공고 리스트의 목록을 보여주는 클래스
 * 각종 검색&필터들의 조건을 확인하여 원하는 리스트의 목록을 불러옴
 * @author 3조
 *
 */
public class JobDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public JobDAO() {

		try {
			conn = DBUtil.open();
		} catch (Exception e) {
			System.out.println("JobDAO.JobDAO()");
			e.printStackTrace();
		}

	}
	
	
	
	/**
	 * 조건 여부를 검사하는 메소드를 통해 모든 조건들을 문자열 sql 변수에 담아 연결된
	 * DB에서 실행을 하여 결과값을 반환해주는 메소드
	 * @param map 검색 조건들이 담겨있는 HashMap을 받아옴
	 * @return 결과값을 ArrayList 배열로 담아 넘겨줌
	 */
	public ArrayList<JobDTO> list(HashMap<String, String> map) {

		try {
			String sql = "";
			String where = "";
			String order = "";
			
			where = findJobGroup(map, where);
			System.out.println("jobGroup: " + where);

			where = findCity(map, where);
			System.out.println("city: " + where);
			where = findCareer(map, where);
			System.out.println("career: " + where);
			where = findEducationLevel(map, where);
			System.out.println("edu: " + where);
			
			if (map.get("isFilter").equals("1")) {
				order = "order by endDate";
			}else {
				order = "order by regdate";
			}

			
			  sql = String.format("select s.* from (select v.*, rownum as unum from (select * from vwJobPost %s %s) v ) s where s.unum between %s and %s"
					  ,where, order, map.get("begin"), map.get("end"));
			 System.out.println(sql);
		
			pstat = conn.prepareStatement(sql);

			rs = pstat.executeQuery();

			ArrayList<JobDTO> list = new ArrayList<JobDTO>(); // 옮겨 담을 큰상자

			while (rs.next()) {

				JobDTO dto = new JobDTO();
				dto.setCompanySeq(rs.getString("companySeq"));
				dto.setJobPostSeq(rs.getString("jobPostSeq"));
				dto.setName(rs.getString("name"));
				dto.setPostName(rs.getString("postName"));
				dto.setCareer(rs.getString("career"));
				dto.setStartDate(rs.getString("startDate"));
				dto.setEndDate(rs.getString("endDate"));
				dto.setEducationLevel(rs.getString("educationLevel"));
				dto.setAttachedFile(rs.getString("attachedFile"));
				dto.setCity(rs.getString("city"));
				dto.setGu(rs.getString("gu"));

				list.add(dto);

			}
			return list;

		} catch (Exception e) {
			System.out.println("JobDAO.list()");
			e.printStackTrace();
		}

		return null;
	}

	
	/**
	 * 
	 * @param map 조건에 만족하는 공고의 총 갯수를 알아내기 위하여 매개변수로 조건들을 담은 HashMap을 받아옴
	 * @return 쿼리 실행 결과를 Integer로 넘겨줌
	 */
	public int getTotalCount(HashMap<String, String> map) {

		try {

			String where = "";

			
			where = findJobGroup(map, where);
			System.out.println("jobGroup: " + where);

			where = findCity(map, where);
			System.out.println("city: " + where);
			where = findCareer(map, where);
			System.out.println("career: " + where);
			where = findEducationLevel(map, where);
			System.out.println("edu: " + where);

			String sql = String.format("select count(*) as cnt from vwJobPost %s", where);

			pstat = conn.prepareStatement(sql);

			rs = pstat.executeQuery();

			if (rs.next()) {
				System.out.println("총 게시물 수: " + rs.getInt("cnt"));
				return rs.getInt("cnt");
			}

		} catch (Exception e) {
			System.out.println("JobDAO.getTotalCount()");
			e.printStackTrace();
		}

		return 0;

	}// getTotalCount

	
	/**
	 * 
	 * @param map 조건을 담은 HashMap
	 * @param 쿼리를 실행할 sql변수에 넣을 조건문에 where절 중복 방지를 위해 검사
	 * @return 조건에 맞는 where 변수를 넘겨준다.
	 */
	private String findJobGroup(HashMap<String, String> map, String where) {
		
		if (map.get("jobGroup") != null && !map.get("jobGroup").equals("all") && !map.get("jobGroup").equals("")) {
			if (where.contains("where")) {
				where = String.format("and jobGroup = '%s' ", map.get("jobGroup"));
			}else {
				where = String.format("where jobGroup = '%s' ", map.get("jobGroup"));
			}
		}
		return where;
		
	}

	private String findCity(HashMap<String, String> map, String where) {

		if (where.contains("where")) {
			if (map.get("city") != null && !map.get("city").equals("all")) {
				if (map.get("gu") != null && map.get("gu").equals("전체")) {
					where += String.format("and city = '%s' ", map.get("city"));
				} else if (map.get("gu") != null && !map.get("gu").equals("전체")) {
					where += String.format("and city = '%s' and gu = '%s' ", map.get("city"), map.get("gu"));
				}
			}

		} else {
			if (map.get("city") != null && !map.get("city").equals("all")) {
				if (map.get("gu") != null && map.get("gu").equals("전체")) {
					where += String.format("where city = '%s' ", map.get("city"));
				} else if (map.get("gu") != null && !map.get("gu").equals("전체")) {
					where += String.format("where city = '%s' and gu = '%s' ", map.get("city"), map.get("gu"));
				}
			}
		}

		return where;

	}// City 조건

	private String findCareer(HashMap<String, String> map, String where) {

		if (map.get("career") != null && !map.get("career").equals("all")) {
			if (where.contains("where")) {
				where += String.format("and career like '%%%s%%' ", map.get("career"));
			} else {
				where += String.format("where career like '%%%s%%' ", map.get("career"));
			}
		}

		return where;

	}// Career조건

	private String findEducationLevel(HashMap<String, String> map, String where) {
		if (map.get("educationLevel") != null && !map.get("educationLevel").equals("all")) {
			if (where.contains("where")) {
				where += String.format("and educationLevel = '%s' ", map.get("educationLevel"));
			} else {
				where += String.format("where educationLevel = '%s' ", map.get("educationLevel"));
			}
		}
		return where;
	}// educationlevel 조건

	

}
