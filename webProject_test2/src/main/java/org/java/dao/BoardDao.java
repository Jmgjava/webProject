package org.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.java.connect.DBConnect;
import org.java.dto.BoardDto;
import org.java.dto.MemberDto;

public class BoardDao {

	public BoardDao() {
		System.out.println("싱글톤");
	}

	private static class singleton {
		private static final BoardDao INSTACE = new BoardDao();
	}

	public static BoardDao getInstance() {
		return singleton.INSTACE;
	}

//	회원가입
	public int bInsert(BoardDto board) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnetion();
			query = "insert into board0202(no,title,content,writer,nickname) values(board0202_seq.nextval,?,?,?,?)";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, board.gettitle());
			pstm.setString(2, board.getContent());
			pstm.setString(3, board.getWriter());
			pstm.setString(4, board.getNickName());

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

// 회원유무
	public int isBoard(String userId) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		ResultSet rs = null;

		try {
			conn = DBConnect.getConnetion();
			query = "select count(*) from member0202 where userId=?";
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

// 회원전체조회
	public List<BoardDto> bSelectAll() {
		List<BoardDto> member = new ArrayList<BoardDto>();

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		ResultSet rs = null;

		try {
			conn = DBConnect.getConnetion();
			query = "select*from board0202";
			pstm = conn.prepareStatement(query);

			rs = pstm.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					member.add(new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5)));
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

	public int bUpdate(BoardDto board) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnetion();
			query = "update board0202 set title=?,content=?,nickname=? where writer=?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, board.gettitle());
			pstm.setString(2, board.getContent());
			pstm.setString(3, board.getNickName());
			pstm.setString(4, board.getWriter());

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

	public int bDelete(int no) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnetion();
			query = "delete from board0202 where no=?";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, no);

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
}