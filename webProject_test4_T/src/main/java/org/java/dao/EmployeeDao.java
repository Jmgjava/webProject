package org.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.java.connect.DBConnect;
import org.java.dto.EmployeeDto;
import org.java.dto.Test_tb2Dto;

public class EmployeeDao {
	/////////////////////////////////////////
	private EmployeeDao() {
		System.out.println("싱글톤 -> EmployeeDao");
	}

	private static class SingTonClass {
		private static final EmployeeDao INSTANCE = new EmployeeDao();
	}

	public static EmployeeDao getInstance() {
		return SingTonClass.INSTANCE;
	}

	/////////////////////////////////////////
	// 조회(ALL)
	public List<EmployeeDto> selectAll() {
		List<EmployeeDto> employees = new ArrayList<EmployeeDto>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
//			query = "select emp_depart from employee group by emp_depart order by emp_depart asc ";
			query = "select * from employee order by emp_depart asc ";
			pstm = conn.prepareStatement(query);

			rs = pstm.executeQuery(); // 조회

			if (rs != null) {
				while (rs.next()) {

					int emp_id = rs.getInt(1);
					String emp_name = rs.getString(2);
					String emp_depart = rs.getString(3);
					String emp_email = rs.getString(4);
					Date date = rs.getDate(5);

					EmployeeDto emDto = new EmployeeDto(emp_id, emp_name, emp_depart, emp_email, date);
					employees.add(emDto);

//					employees.add(new EmployeeDto(
//							rs.getInt(1), 
//							rs.getString(2),
//							rs.getString(3),
//							rs.getString(4),
//							rs.getDate(5)));

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return employees;
	}

	// 부서별(ALL)
	public List<EmployeeDto> emp_depart() {
		List<EmployeeDto> lists = new ArrayList<EmployeeDto>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";

		try {
			
			conn = DBConnect.getConnection();
			query = "select emp_depart, count(*)  직원수 from employee group by emp_depart order by emp_depart asc ";
//			query = "select emp_depart from employee group by emp_depart order by emp_depart asc ";
			pstm = conn.prepareStatement(query);

			rs = pstm.executeQuery(); // 조회

			if (rs != null) {
				while (rs.next()) {

					String emp_depart=rs.getString(1);
					int count=rs.getInt(2);// 부서별 직원수
					//기본생성 이용
					EmployeeDto em=new EmployeeDto();
					em.setEmp_depart(emp_depart);
					em.setCount(count);/// 테이블에 X
					
					lists.add(em);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return lists;
	}

}
