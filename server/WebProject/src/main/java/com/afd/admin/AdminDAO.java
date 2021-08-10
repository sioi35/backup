package com.afd.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.afd.DBUtil;

public class AdminDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public AdminDAO() {

		try {

			conn = DBUtil.open();

		} catch (Exception e) {
			System.out.println("AdminDAO.AdminDAO()");
			e.printStackTrace();
		}

	}

	public AdminDTO login(AdminDTO dto) {
		
		try {
			
			String sql = "select * from tblAdmin where id = ? and pw = ?";
			
			pstat = conn.prepareStatement(sql);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				AdminDTO result = new AdminDTO();
				
				result.setAdminSeq(rs.getString("adminSeq"));
				result.setId(rs.getString("id"));
				result.setPw(rs.getString("pw"));
				
				return result;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
