package com.afd.member.mypage.chart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.afd.DBUtil;

public class ChartDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public ChartDAO() {

		try {

			conn = DBUtil.open();

		} catch (Exception e) {
			System.out.println("ChartDAO.ChartDAO()");
			e.printStackTrace();
		}

	}

	public ChartDTO boardCount(ChartDTO dto) {
		
		try {
			
			String sql = "select name, (select count(*) from tblTechQna where memberSeq = ?) as qnaCount, (select count(*) from tblCommunity where memberSeq = ?) as communityCount, (select count(*) from tblStudyPost where memberSeq = ?) as studyCount from tblMember where memberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getMemberSeq());
			pstat.setString(2, dto.getMemberSeq());
			pstat.setString(3, dto.getMemberSeq());
			pstat.setString(4, dto.getMemberSeq());
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				dto.setName(rs.getString("name"));
				dto.setQnaCount(rs.getString("qnaCount"));
				dto.setCommunityCount(rs.getString("communityCount"));
				dto.setStudyCount(rs.getString("studyCount"));
				
				return dto;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public ChartDTO commentCount(ChartDTO dto) {
		
		try {
			
			String sql = "select name, (select count(*) from tblTechQnaComment where memberSeq = ?) as qnaCommentCount, (select count(*) from tblCommunityComment where memberSeq = ?) as communityCommentCount, (select count(*) from tblStudyComment where memberSeq = ?) as studyCommentCount from tblMember where memberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getMemberSeq());
			pstat.setString(2, dto.getMemberSeq());
			pstat.setString(3, dto.getMemberSeq());
			pstat.setString(4, dto.getMemberSeq());
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				dto.setName(rs.getString("name"));
				dto.setCommunityCommentCount(rs.getString("communityCommentCount"));
				dto.setQnaCommentCount(rs.getString("qnaCommentCount"));
				dto.setStudyCommentCount(rs.getString("studyCommentCount"));
				
				return dto;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
