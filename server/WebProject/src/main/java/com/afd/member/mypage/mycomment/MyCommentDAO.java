package com.afd.member.mypage.mycomment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.afd.DBUtil;

public class MyCommentDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public MyCommentDAO() {

		try {

			conn = DBUtil.open();

		} catch (Exception e) {
			System.out.println("MyCommentDAO.MyCommentDAO()");
			e.printStackTrace();
		}

	}

	public ArrayList<MyCommentDTO> qnaList(MyCommentDTO dto) {
		
		try {
			
			String sql = "select * from vwTechQna where memberSeq = ?";
			
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getMemberSeq());
			
			rs = pstat.executeQuery();
			
			//System.out.println("SQL: " + sql);
			
			ArrayList<MyCommentDTO> qnaList = new ArrayList<MyCommentDTO>();
			
			while (rs.next()) {
				
				MyCommentDTO result = new MyCommentDTO();
				
				result.setTechQnaSeq(rs.getString("techQnaSeq"));
				result.setMemberSeq(rs.getString("memberSeq"));
				result.setTitle(rs.getString("title"));
				result.setContent(rs.getString("content"));
				result.setRegdate(rs.getString("regdate"));
				result.setReadCount(rs.getString("readCount"));
				result.setImage(rs.getString("image"));
				result.setIsNew(rs.getString("isNew"));
				result.setNickName(rs.getString("nickName"));
				result.setId(rs.getString("id"));
				result.setCcnt(rs.getString("ccnt"));
				result.setRecommendCount(rs.getString("recommendCount"));
				result.setDecommendCount(rs.getString("decommendCount"));
				
				qnaList.add(result);
				
			}
			
			return qnaList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
