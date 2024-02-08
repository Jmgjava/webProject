package org.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.project.connect.DBConnect;
import org.project.dto.Board0208Dto;

public class Board0208Dao {

	public Board0208Dao() {
		System.out.println("Dao");
	}

	private static class singleton {
		private static final Board0208Dao INSTANCE = new Board0208Dao();
	}

	public static Board0208Dao getInstance() {
		return singleton.INSTANCE;
	}

	public int write(String title, String content, String userId) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		ResultSet rs = null;

		try {
			conn = DBConnect.getConnection();
			query = "insert into board0208(no,title,content,userId) values (board0208_SEQ.nextval,?,?,?)";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, title);
			pstm.setString(2, content);
			pstm.setString(3, userId);

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

	public List<Board0208Dto> selectAll() {
		List<Board0208Dto> boards = new ArrayList<Board0208Dto>();

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		ResultSet rs = null;

		try {
			conn = DBConnect.getConnection();
			query = "select* from board0208";
			pstm = conn.prepareStatement(query);

			rs = pstm.executeQuery();
			if (rs != null) {

//				int no = rs.getInt(0);
//				String title = rs.getString(0);
//				String content = rs.getString(0);
//				String userId = rs.getString(0);
//				Board0208Dto board = new Board0208Dto(no, title, content, userId);
//				boards.add(board);
				while (rs.next()) {
					boards.add(new Board0208Dto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
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

		return boards;
	}

	public Board0208Dto selectOne(int no) {

		Board0208Dto board = null;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		ResultSet rs = null;

		try {
			conn = DBConnect.getConnection();
			query = "select* from board0208 where no=?";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, no);

			rs = pstm.executeQuery();

			if (rs != null) {
				if (rs.next()) {
					board = new Board0208Dto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return board;
	}
}
