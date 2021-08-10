package com.test.jsp.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex04_select {
	
	public static void main(String[] args) {
		
		//Ex04_select.java
		
		//반환값이 있는 쿼리 -> select문
		
		template();
		//m1();
		//m2();
		//m3();
		//m4();
		m5();
		
		
	}//main

	private static void m5() {
		//N개 레코드 + N개 컬럼
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			String sql = "select * from tblAddress order by seq asc";
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				String seq = rs.getString("seq");
				String name = rs.getString("name");
				String age = rs.getString("age");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				
				System.out.println(seq);
				System.out.println(name);
				System.out.println(age);
				System.out.println(gender);
				System.out.println(address);
				System.out.println();
				
			}
			
			
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m4() {
		//N개 레코드 + 1개 컬럼
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			String sql = "select name from tblAddress order by name asc";
			
			rs = stat.executeQuery(sql);
			
			//rs.next(); //몇번?
			while(rs.next()) {
				
				String name = rs.getString("name");
				System.out.println(name);
				
			}
			
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private static void m3() {
		//1개 레코드 + N개 컬럼

		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			String sql = "select * from tblAddress where seq = 10";
			
			rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				
				String seq = rs.getString("seq");
				String name = rs.getString("name");
				String age = rs.getString("age");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				
				System.out.println(seq);
				System.out.println(name);
				System.out.println(age);
				System.out.println(gender);
				System.out.println(address);
				
			}
			
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}//m3

	private static void m2() {
		//단일값 select

		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			String sql = "select name as nick from tblAddress where seq = 10";
			
			rs = stat.executeQuery(sql); //실행
			
			if(rs.next()) {
				
				//String name = rs.getString(1);
				//String name = rs.getString("name");
				String name = rs.getString("nick"); //alias 별칭
				
				System.out.println("이름: " + name);
				
			}else {
				System.out.println("10번 레코드가 없습니다.");
			}
			
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	private static void m1() {
		
		//단일값 변환 select
		// -> select -> 1행 1열
		// -> select -> N행 N열
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			String sql = "select count(*) from tblAddress";
			
			rs = stat.executeQuery(sql);
			
			//rs??? -> 결과 테이블
			
			//커서를 다음 레코드를 전진시킨다.
			rs.next();
			
			//커서가 가리키고 있는 레코드의 특정 컬럼값을 가져온다.
			//rs.getXXX();
			int count = rs.getInt(1);
			System.out.println("인원수: " + count);

			
			String strCount = rs.getString(1);
			System.out.println("인원수: " + strCount);
			
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
	}//m1
	

	private static void template() {
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			String sql = "";
			
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}//template
	
}//Ex04_select

















