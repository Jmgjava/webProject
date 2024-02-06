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

	public Test_tb2Dao() {
		System.out.println("DAO");
	}

	private static class singletonClass {
		private static final Test_tb2Dao INSTANCE = new Test_tb2Dao();
	}

	public static Test_tb2Dao getInstnace() {
		return singletonClass.INSTANCE;
	}

	public int tbInsert(Test_tb2Dto board) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.DBConnection();
			query = "insert into test_tb2(no,userId,userPw,email)values(test_tb2_SEQ.nextval,?,?,?)";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, board.getUserId());
			pstm.setString(2, board.getUserPw());
			pstm.setString(3, board.getEmail());

			result = pstm.executeUpdate();
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

		return result;
	}

	public List<Test_tb2Dto> tbSelect() {
		List<Test_tb2Dto> member = new ArrayList<Test_tb2Dto>();

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		ResultSet rs = null;

		try {
			conn = DBConnect.DBConnection();
//			query = "select * from test_tb2 order by userId desc";  // 내림차순
//			query = "select * from test_tb2 order by userId asc"; // 오름차순
//			query = "select * from test_tb2 where userAge between 10 and 20 order by no desc";
			query = "select * from test_tb2";
			pstm = conn.prepareStatement(query);

			rs = pstm.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					member.add(new Test_tb2Dto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
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

		return member;
	}

	public List<Test_tb2Dto> tbSelectOne(int no) {
		List<Test_tb2Dto> member = new ArrayList<Test_tb2Dto>();

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		ResultSet rs = null;

		try {
			conn = DBConnect.DBConnection();
			query = "select * from test_tb2 where no=?";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, no);

			rs = pstm.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					member.add(new Test_tb2Dto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
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

		return member;
	}

	public int tbUpdate(Test_tb2Dto board) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.DBConnection();
			query = "update test_tb2 set userId=?, userPw=?, email=? where no=?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, board.getUserId());
			pstm.setString(2, board.getUserPw());
			pstm.setString(3, board.getEmail());
			pstm.setInt(4, board.getNo());

			result = pstm.executeUpdate();
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

		return result;
	}

	public int tbDelete(String userId) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.DBConnection();
			query = "delete from test_tb2 where userId=?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, userId);

			result = pstm.executeUpdate();
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

		return result;
	}

	public int tbcheck(String userId) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		ResultSet rs = null;

		try {
			conn = DBConnect.DBConnection();
			query = "select count(*) from test_tb2 where no=?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, userId);

			rs = pstm.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					result = rs.getInt(1);
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

		return result;
	}

}
