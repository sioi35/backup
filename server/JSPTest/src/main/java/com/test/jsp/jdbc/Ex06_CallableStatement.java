package com.test.jsp.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import oracle.jdbc.internal.OracleTypes;


public class Ex06_CallableStatement {

	public static void main(String[] args) {
		
		//1. Statement: 정적 쿼리 실행
		//2. PreparedStatement: 동적 쿼리 실행
		//3. CollableStatement: 프로시저 실행. PreparedStatement 유사
		
		
		//m1();
		//m2();
		//m3();
		//m4();
		m5();
		
	}//main

	private static void m5() {

		//프로시저
		// - select -> 다중 레코드 반환(= 커서 반환)
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {

			String sql = "{ call proc_m5(?,?) }";
			
			conn = DBUtil.open();
			stat = conn.prepareCall(sql);
			
			//in
			stat.setString(1, "m");
			
			//out
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			//**** 프로시저에서 반환한 커서는 자바에서 ResultSet으로 받는다.
			rs = (ResultSet)stat.getObject(2);
			
			while(rs.next()) {
				System.out.println(rs.getString("name") + ", " + rs.getString("gender"));
			}
			
			
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}//m5

	private static void m4() {
		
		//프로시저 out 매개변수
		//- insert, update, delete -> 매개변수, 결과(성공 유무)
		//- select -> 단일 레크드 반환
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {

			//select문 실행 -> 단일 레코드
			String sql = "{ call proc_m4(?,?,?,?,?) }";
			
			conn = DBUtil.open();
			stat = conn.prepareCall(sql);
			
			//in
			stat.setString(1, "30");
			
			//out
			stat.registerOutParameter(2, OracleTypes.VARCHAR);
			stat.registerOutParameter(3, OracleTypes.NUMBER);
			stat.registerOutParameter(4, OracleTypes.VARCHAR);
			stat.registerOutParameter(5, OracleTypes.VARCHAR);
			
			stat.executeQuery();
			
			//out 값 접근
			String name = stat.getString(2);
			int age = stat.getInt(3);
			String gender = stat.getString(4);
			String address = stat.getString(5);
			
			System.out.println(name);
			System.out.println(age);
			System.out.println(gender);
			System.out.println(address);
			
			//rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//m4

	private static void m3() {
		
		Connection conn = null;
		CallableStatement stat = null;
		
		try {

			String sql = "{ call proc_m3(?,?,?,?,?) }";
			
			conn = DBUtil.open();
			stat = conn.prepareCall(sql);
			
			// in 매개변수 x 4개
			stat.setString(1, "홍길동"); 
			stat.setString(2, "23");
			stat.setString(3, "m");
			stat.setString(4, "서울시 강남구 역삼동");
			
			// out 매개변수 x 1개
			stat.registerOutParameter(5, OracleTypes.NUMBER); //**************
			
			stat.executeUpdate();
			
			int result = stat.getInt(5); //**************
			
			System.out.println("결과: " + result);
			
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//m3

	private static void m2() {

		Connection conn = null;
		CallableStatement stat = null;
		
		try {

			//String sql = "{ call proc_m2('홍길동', 20, 'm', '서울시')}";
			String sql = "{ call proc_m2(?,?,?,?)}";
			
			conn = DBUtil.open();
			stat = conn.prepareCall(sql);
			
			stat.setString(1, "홍길동"); 
			stat.setString(2, "23");
			stat.setString(3, "m");
			stat.setString(4, "서울시 강남구 역삼동");
			
			stat.executeUpdate();
			
			System.out.println("완료");
			
			
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//m2

	private static void m1() {

		Connection conn = null;
		CallableStatement stat = null;
		
		try {

			String sql = "{ call proc_m1 }";
			
			conn = DBUtil.open();
			stat = conn.prepareCall(sql);
			
			System.out.println(stat.executeUpdate());
			
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}//m1
	
	public static void template() {
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {

			String sql = "{ call }";
			
			conn = DBUtil.open();
			stat = conn.prepareCall(sql);
			
			//rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}//Ex06_CallableStatement
