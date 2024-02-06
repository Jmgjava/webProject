package org.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.java.connect.DBConnect;
import org.java.dto.Test_tb2Dto;

public class Test_tb2Dao {

	/////////////////////////////////////////
	private Test_tb2Dao() {
		System.out.println("싱글톤 -> Test_tb2Dao");
	}
	private static class SingTonClass{
		private static final Test_tb2Dao INSTANCE=new Test_tb2Dao();
	}
	
	public static Test_tb2Dao getInstance() {
		return SingTonClass.INSTANCE;
	}
	/////////////////////////////////////////

	public int insert(String userId, int userAge, String userName) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "insert into test_tb2(no, userId,userage,username) values(test_tb2_SEQ.NEXTVAL,?,?,?)";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, userId);
			pstm.setInt(2, userAge);
			pstm.setString(3, userName);

			result = pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
	public List<Test_tb2Dto> selectAll() {
		List<Test_tb2Dto> tb2Dtos = new ArrayList<Test_tb2Dto>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
//			query = "select   depart,   sum(price) as 부서별합계  "
//					+ "from group1 "
//					+ "group by depart "
//					+ "having sum(price) >?"
//					+ "order by 부서별합계 desc"
//					+ "";
			query = "select * from  test_tb2 where  userAge between 10 and 20 order by no desc";
//			query = "select * from  test_tb2 where  userId like 'm%' and userAge>20 order by no desc";
//			query = "select * from  test_tb2 where  userId <> 'm1'  order by no desc";
//			query = "select * from  test_tb2 where  userId like '%1'  order by no desc";
//			query = "select * from  test_tb2 where  userId like 'm%'  order by no desc";
//			query = "select * from  test_tb2  ";
			pstm = conn.prepareStatement(query);

			rs = pstm.executeQuery(); // 조회

			if (rs != null) {
				while (rs.next()) {
					tb2Dtos.add(new Test_tb2Dto(rs.getInt(1), rs.getString(2), rs.getInt(3),
							rs.getString(4)));

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

		return tb2Dtos;
	}
}

