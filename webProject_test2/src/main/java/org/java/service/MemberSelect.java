package org.java.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.java.dao.MemberDao;
import org.java.dto.MemberDto;

public class MemberSelect implements MemberService {

	@Override
	public void executeQueryService() throws IOException, SQLException {
		System.out.println("회원조회");

		Scanner input = new Scanner(System.in);

		MemberDao dao = MemberDao.getInstance();

		List<MemberDto> member = dao.selectAll();

		if (member.isEmpty()) {
			System.out.println("조회할 회원이 없습니다.");
		} else {
			for (MemberDto members : member) {
				System.out.println("회원번호: " + members.getNo());
				System.out.println("회원아이디: " + members.getUserId());
				System.out.println("회원비밀번호: " + members.getUserPw());
				System.out.println("회원핸드폰: " + members.getPhone());
			}
		}

	}

}
