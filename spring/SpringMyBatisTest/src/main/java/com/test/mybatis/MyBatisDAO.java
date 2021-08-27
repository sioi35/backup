package com.test.mybatis;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//JDBC -> MyBatis
@Repository
public class MyBatisDAO {

	@Autowired
	private SqlSessionTemplate template; //Statement + ResultSet + Mapping
	
	public int add(MyBatisDTO dto) {

		//반환값 없는 쿼리 > insert
		
		//stat.executeUpdate()
		//- template.insert()
		//- template.update()
		//- template.delete()
		
		//stat.executeQuery()
		//- template.selectXXX()
		
		//- template.insert(""): 인자가 없는 쿼리
		//- teplate.insert("", obj): 인자가 있는 쿼리
		
		//MyBatis > SQL을 XML로 작성한다.
		
		//return template.insert("test.m1"); //executeUpdate(). 매개변수가 없는 반환값 없는 쿼리
		
		//return template.delete("test.m2", 5); //매개변수가 있는 반환값 없는 쿼리
		
		return template.update("test.m3", dto); //매개변수가 있는 반환값 없는 쿼리
		
	}

	public int m2(HashMap<String, String> map) {
		
		//매개변수 N개
		// -> 무조건 상자(DTO, HashMap)에 담아서 넘겨야 한다.
		return template.update("test.m4", map);
	}

	public int m3() {
		
		/*
		try {
			
			String sql = "select count(*) as cnt from tblMemo";
			
			stat = conn.createStatement(sql);
			rs = stat.execteQuery();
			
			if(rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println("MyBatisDAO.m3()");
			e.printStackTrace();
		}
		*/
		
		return template.selectOne("test.m5");
	}

	public String m4(String seq) {
		return template.selectOne("test.m6", seq);
	}

	public MyBatisDTO m5(String seq) {

		/*
		try {
			
			String sql = "select * from tblMemo where seq = ?";
			
			stat = conn.createStatement(sql);
			pstat.setString(1, seq);
			rs = stat.execteQuery();
			
			MyBatisDTO dto = new MyBatisDTO();
					
			
			if(rs.next()) {

				MyBatisDTO dto = new MyBatisDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setMemo(rs.getString("memo"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setCategory(rs.getString("category"));
				
				return dto;

			}
			
		} catch (Exception e) {
			System.out.println("MyBatisDAO.m5()");
			e.printStackTrace();
		}
		*/
		
		return template.selectOne("test.m7", seq);
	}

	public List<MyBatisDTO> m6() {

		/*
		try {
			
			String sql = "select * from tblMemo order by seq desc";
			
			stat = conn.createStatement(sql);
			rs = stat.execteQuery();
			
			List<MyBatisDTO> list = new ArrayList<MyBatisDTO>();
			
			if(rs.next()) {

				MyBatisDTO dto = new MyBatisDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setMemo(rs.getString("memo"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setCategory(rs.getString("category"));

				list.add(dto);
			}

				return list;
			
		} catch (Exception e) {
			System.out.println("MyBatisDAO.m5()");
			e.printStackTrace();
		}
		*/
		
		return template.selectList("test.m8");
	}
	
}

