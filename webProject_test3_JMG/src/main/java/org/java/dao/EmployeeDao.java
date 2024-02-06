package org.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.java.connect.DBConnect;
import org.java.dto.EmployeeDto;

public class EmployeeDao {

	public EmployeeDao() {
		System.out.println("DAO");
	}

	private static class singletonClass {
		private static final EmployeeDao INSTANCE = new EmployeeDao();
	}

	public static EmployeeDao getInstance() {
		return singletonClass.INSTANCE;
	}

	public List<EmployeeDto> eSelect() {
		List<EmployeeDto> employees = new ArrayList<EmployeeDto>();

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		ResultSet rs = null;

		try {
			conn = DBConnect.DBConnection();
			query = "select*from employee order by emp_depart asc";
//			query = "select emp_depart from employee group by emp_depart order by emp_depart asc";
			pstm = conn.prepareStatement(query);

			rs = pstm.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					employees.add(new EmployeeDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getDate(5)));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return employees;
	}

	// 부서별 ALL
	public List<EmployeeDto> selectDepart() {
		List<EmployeeDto> employees = new ArrayList<EmployeeDto>();

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		ResultSet rs = null;

		try {
			conn = DBConnect.DBConnection();
			query = "select emp_depart, count(*) as 직원수 from employee group by emp_depart order by emp_depart desc";
			pstm = conn.prepareStatement(query);

			rs = pstm.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					employees.add(new EmployeeDto());
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employees;
	}

}
