package org.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.java.connect.DBConnect;
import org.java.dto.MemberDto;

public class MemberDao {

	public MemberDao() {
		System.out.println("싱글톤");
	}

	private static class singleton {
		private static final MemberDao INSTACE = new MemberDao();
	}

	public static MemberDao getInstance() {
		return singleton.INSTACE;
	}

	public int mInsert(MemberDto board) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnetion();
			query = "insert into board0201(no,title,content,writer,nickname) VALUES(?,?,?,?,?)";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, board.getNo());
			pstm.setString(2, board.getTitle());
			pstm.setString(3, board.getContent());
			pstm.setString(4, board.getWriter());
			pstm.setString(5, board.getNickname());

			pstm.executeUpdate();
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

	public int mUpdate(MemberDto board) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnetion();
			query = "update board0201 set title=?,content=?,writer=?,nickname=? where no=?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, board.getTitle());
			pstm.setString(2, board.getContent());
			pstm.setString(3, board.getWriter());
			pstm.setString(4, board.getNickname());
			pstm.setInt(5, board.getNo());

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

	public int mDelete(int no) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnetion();
			query = "delete from board0201 where no=?";
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

	public List<MemberDto> mSelect() {

		List<MemberDto> member = new ArrayList<MemberDto>();

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		ResultSet rs = null;

		try {
			conn = DBConnect.getConnetion();
			query = "select*from board0201";
			pstm = conn.prepareStatement(query);

			rs = pstm.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					member.add(new MemberDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
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

}
