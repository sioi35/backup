package com.test.mvc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.jsp.jdbc.DBUtil;

public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//1.수정할 컬럼 번호 가져오기
		
		String seq = req.getParameter("seq");
		
		//2. DB -> select where seq = 수정할 번호
		//3. ResultSet -> 폼태그 기본값으로 설정
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
		
		
		String name ="";
		String age = "";
		String gender = "";
		String address = "";
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			String sql = "select * from tblAddress where seq = " + seq;
			
			rs = stat.executeQuery(sql);
			
			if(rs.next()){
				
				HashMap<String, String> map = new HashMap<String, String>();
				
				map.put("seq", rs.getString("seq"));
				map.put("name", rs.getString("name"));
				map.put("age", rs.getString("age"));
				map.put("gender", rs.getString("gender"));
				map.put("address", rs.getString("address"));
				
				list.add(map);
			}
			
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/address/edit.jsp");
		dispatcher.forward(req, resp);
	
	}
}//Edit.java
