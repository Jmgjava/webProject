package org.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.project.connect.DBConnect;
import org.project.dto.MemberDto;

public class MemberDao {

	public MemberDao() {
		System.out.println("DAO");
	}

	private static class singleton {
		private static final MemberDao INSTANCE = new MemberDao();
	}

	public static MemberDao getInstance() {
		return singleton.INSTANCE;
	}

	public List<MemberDto> selectALL() {
		List<MemberDto> members = new ArrayList<MemberDto>();

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		ResultSet rs = null;

		try {
			conn = DBConnect.getConnection();
			query = "select*from member0207";
//			query = "select emp_depart from employee group by emp_depart order by emp_depart asc";
			pstm = conn.prepareStatement(query);

			rs = pstm.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					members.add(new MemberDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getDate(5), rs.getString(6), rs.getString(7)));
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

		return members;
	}

	public List<MemberDto> selectJoinALL() {
		List<MemberDto> members = new ArrayList<MemberDto>();

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		ResultSet rs = null;

		try {
			conn = DBConnect.getConnection();
			query = "select me.* \r\n" + "from member0207 me inner join money0207 mo\r\n" + "on me.custno=mo.custno";
			pstm = conn.prepareStatement(query);

			rs = pstm.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					members.add(new MemberDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getDate(5), rs.getString(6), rs.getString(7)));
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

		return members;
	}

	public List<MemberDto> selectGradeALL() {
		List<MemberDto> members = new ArrayList<MemberDto>();

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		ResultSet rs = null;

		try {
			conn = DBConnect.getConnection();
			query = "select me.custname , me.grade\r\n" + "from member0207 me inner join money0207 mo\r\n"
					+ "on me.custno=mo.custno";
			pstm = conn.prepareStatement(query);

			rs = pstm.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					members.add(new MemberDto(rs.getString(1), rs.getString(2)));
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

		return members;
	}

}
