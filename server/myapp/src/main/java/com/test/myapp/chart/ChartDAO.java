package com.test.myapp.chart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.myapp.DBUtil;

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

	public ArrayList<ChartDTO> list1() {

		try {
			
			String sql = "select name, (select count(*) from tblBoard1 where id = tblUser1.id) as cnt from tblUser1";
			
			stat = conn.createStatement();
			rs= stat.executeQuery(sql);
			
			ArrayList<ChartDTO> list = new ArrayList<ChartDTO>();
			
			while(rs.next()) {
				
				ChartDTO dto = new ChartDTO();
				dto.setName(rs.getString("name"));
				dto.setCnt(rs.getString("cnt"));
				list.add(dto);
			}
			return list;
			
		} catch (Exception e) {
			System.out.println("ChartDAO.list1()");
			e.printStackTrace();
		}
		
		return null;
	}

	public ArrayList<ChartDTO> list2() {
		
		try {
			
			String sql = "select name, (select count(*) from tblComment where id = tblUser1.id) as cnt from tblUser1";		
			
					stat = conn.createStatement();
			rs= stat.executeQuery(sql);
			
			ArrayList<ChartDTO> list = new ArrayList<ChartDTO>();
			
			while(rs.next()) {
				
				ChartDTO dto = new ChartDTO();
				dto.setName(rs.getString("name"));
				dto.setCnt(rs.getString("cnt"));
				list.add(dto);
			}
			return list;
			
		} catch (Exception e) {
			System.out.println("ChartDAO.list2()");
			e.printStackTrace();
		}
		
		return null;
	}

}
