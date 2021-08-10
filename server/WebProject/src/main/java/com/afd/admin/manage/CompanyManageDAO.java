package com.afd.admin.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.afd.DBUtil;

public class CompanyManageDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public CompanyManageDAO() {

		try {

			conn = DBUtil.open();

		} catch (Exception e) {
			System.out.println("MyPageDAO.MyPageDAO()");
			e.printStackTrace();
		}

	}

	public ArrayList<CompanyManageDTO> list(HashMap<String, String> map) {

		try {

			String where = "";

			if (map.get("isSearch").equals("y")) {

				if (!(map.get("column").equals("all"))) {

					where = String.format("and %s like '%%%s%%'", map.get("column"), map.get("search"));

				}

			}

			String sql = String.format("select * from vwCompany where rnum between %s and %s %s", map.get("begin"), map.get("end"), where);

			pstat = conn.prepareStatement(sql);

			rs = pstat.executeQuery();

			ArrayList<CompanyManageDTO> list = new ArrayList<CompanyManageDTO>();
			
			System.out.println("SQL" + sql);

			while (rs.next()) {

				CompanyManageDTO dto = new CompanyManageDTO();

				dto.setCompanySeq(rs.getString("companySeq"));
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setRegistrationNumber(rs.getString("registrationNumber"));
				dto.setCompanyTel(rs.getString("companyTel"));
				dto.setManagerName(rs.getString("managerName"));
				dto.setManagerEmail(rs.getString("managerEmail"));
				dto.setCompanyURL(rs.getString("companyURL"));

				list.add(dto);

			}

//			System.out.println("list: " + list.toString());

			return list;

		} catch (Exception e) {
			System.out.println("list");
			e.printStackTrace();
		}

		return null;
	}

	public int getTotalCount(HashMap<String, String> map) {

		try {

			String where = "";

			if (map.get("isSearch").equals("y")) {

				if (!(map.get("column").equals("all"))) {

					where = String.format("where %s like '%%%s%%'", map.get("column"), map.get("search"));

				}

			}

			String sql = String.format("select count(*) as cnt from tblCompany %s", where);

			pstat = conn.prepareStatement(sql);

			rs = pstat.executeQuery();

			if (rs.next()) {
				return rs.getInt("cnt");
			}

		} catch (Exception e) {
			System.out.println("getTotalCount");
			e.printStackTrace();
		}

		return 0;
	}

}
