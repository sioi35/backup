package com.test.jsp.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class Ex05_PreparedStatement {

	public static void main(String[] args) {

		// Ex05_PreparedStatement

		// Connection

		// insert 실행
		// insert into tblAddress (seq, name, age, gender, address ) values
		// (seqAddress.nextVal, '홍길동', 20, 'm', '서울시 강남구 역삼동');

		// Statement vs PreparedStatement
		// - 정적 쿼리(매개변수가 없는 쿼리): Statement or PreparedStatement 동일 > Statement 사용 권장(간단함)
		// - 동적 쿼리(매개변수가 있는 쿼리): PreparedStatement 사용 권장(안정성)

		//m1();
		//m2();
		m3();

	}// main

	private static void m3() {

		//정적 or 동적 ? > 정적 쿼리 > Statement
		//String sql = "select * from tblAddress";
		
		//정적 or 동적 ? > 동적 쿼리 > PreparedStatement
		String sql = "select * from tblAddress where name = ?";// 홍길동 <- 사용자 입력값
		
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.prepareStatement(sql);
			
			Scanner scan = new Scanner(System.in);
			System.out.print("이름: ");
			String name = scan.nextLine();
			
			stat.setString(1, name);
			
			rs = stat.executeQuery();
			
			while(rs.next()) {
				
				System.out.println(rs.getString("name")+ "," + rs.getString("address"));
				
			}
			
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}//m3

	private static void m2() {

		// 사용자 입력
		String name = "아'무개";
		int age = 23;
		String gender = "m";
		String address = "서울시 강남'구 대치동";

		Connection conn = null;
		PreparedStatement stat = null;

		try {

			// SQL > ? > 오라클 매개변수(오라클 문법) == String.format과 비슷한 역할
			String sql = "insert into tblAddress (seq, name, age, gender, address ) values (seqAddress.nextVal, ?, ?, ?, ?)";

			conn = DBUtil.open();
			stat = conn.prepareStatement(sql);

			// stat.setXXX()
			// - 오라클 매개변수의 자료형과 아무 관계가 없다.
			// -set 메소드의 2번쨰 인자값의 자료형과 관계가 있다.

			//매개변수를 대입하는 과정에서 유효하지 않은 문자를 예외처리를 한다. > 안정성 향상
			stat.setString(1, name); // 1번째 ?(매개변수)에 name 변수값을 넣어라!!
			stat.setInt(2, age); // 오라클 변수와 관련 X 자바 변수와 관련 있다.
			stat.setString(3, gender);
			stat.setString(4, address);

			System.out.println(stat.executeUpdate());

			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}//m2

	private static void m1() {
		// 사용자 입력
		String name = "홍길동";
		int age = 20;
		String gender = "m";
		String address = "서울시 강남구 역삼'동";
		
		name = name.replace("'", "''");
		address = address.replace("'", "''");

		Connection conn = null;
		Statement stat = null;

		try {

			conn = DBUtil.open();
			stat = conn.createStatement();

			String sql = String.format(
					"insert into tblAddress (seq, name, age, gender, address ) values (seqAddress.nextVal, '%s', %d, '%s', '%s')",
					name, age, gender, address);

			
			System.out.println(stat.executeUpdate(sql));

			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}//m2

}//Ex05_PreparedStatement