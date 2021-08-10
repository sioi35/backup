package com.afd.member.job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.afd.DBUtil;


/**
 * 공고에 지원하고자 하는 회원의 번호를 DB에 insert해주기 위한 SeekerDAO
 * @author 3조
 *
 */
public class SeekerDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public SeekerDAO() {

		try {
			conn = DBUtil.open();
		} catch (Exception e) {
			System.out.println("SeekerDAO.SeekerDAO()");
			e.printStackTrace();
		}

	}

	public int enroll(SeekerDTO dto) {

		try {
			
			String sql = "insert into tblJobSeekerInfo values( seekerSeq.nextVal, ?, ?, ?, default )";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getMemberSeq());
			pstat.setString(2, dto.getJobPostSeq());
			pstat.setString(3, dto.getAttachedFile());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	
}
