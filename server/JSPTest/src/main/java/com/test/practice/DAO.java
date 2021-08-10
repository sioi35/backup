package com.test.practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.jsp.jdbc.DBUtil;

//Data Access Object
//데이터베이스에 접근하는 객체
//JDBC와 관련된 모든 코드!
public class DAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	//DB연결
	public DAO() {

		try {
			
			conn = DBUtil.open();
			
		} catch (Exception e) {
			System.out.println("DAO.DAO()");
			e.printStackTrace();
		}
	
	}
	
	//LoginOk id,pw > DB에서 회원등록 되어있는지 확인!
	public DTO login(DTO dto) {
		
		try {
			
			String sql = "select * from tblMember1 where id=? and pw=?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				
				//로그인 성공
				DTO resultDTO = new DTO();
				
				resultDTO.setId(rs.getString("id"));
				resultDTO.setName(rs.getString("name"));
				resultDTO.setTel(rs.getString("tel"));
				resultDTO.setBirth(rs.getString("birth"));
				
				return resultDTO;
			
			
			}
			
			
		} catch (Exception e) {
			System.out.println("DAO.login()");
			e.printStackTrace();
		}
		
		return null; //데이터 정보 불일치
		
	}

	public int join(DTO dto) {

		try {
			
			String sql = "insert into tblMember1(id, pw, name, tel, birth) values (?,?,?,?,?)";
			
			pstat= conn.prepareStatement(sql);
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			pstat.setString(4, dto.getTel());
			pstat.setString(5, dto.getBirth());
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				
				//회원가입 성공
				
				return 1;
				
			}
			
			
		} catch (Exception e) {
			System.out.println("DAO.join()");
			e.printStackTrace();
		}
		
		return 0;
	}

	public ArrayList<DTO> list(ArrayList<DTO> list) {

		//목록 띄우기
		
		try {
			
			
			stat = conn.createStatement();
			
			String sql = "select * from tblMember1 order by name asc";
			
			rs = stat.executeQuery(sql);

			
			while(rs.next()) {
				
				DTO dto = new DTO();
				
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setBirth(rs.getString("birth"));
				
				list.add(dto);
				
				
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("DAO.list()");
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	public DTO list_edit(String id) {

		try {
			
			
			String sql = "select * from tblMember1 where id=?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();

			
			if(rs.next()) {
				
				DTO dto = new DTO();
				
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setBirth(rs.getString("birth"));
				
				
				return dto;
				
			}
			
			
		} catch (Exception e) {
			System.out.println("DAO.edit()");
			e.printStackTrace();
		}
		
		
		
		return null;
		
		
	}
	


	public int update(String id, String name, String tel, String birth) {
		// TODO Auto-generated method stub
	try {
			
			String sql = "update tblMember1 set name = ?, tel = ?, birth = ? where id = ?";
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, name);
			pstat.setString(2, tel);
			pstat.setString(3, birth);
			pstat.setString(4, id);
			
			 int result = pstat.executeUpdate();
			 
			 return result;
			
		} catch (Exception e) {
			System.out.println("");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	
	
	
	
	
}
