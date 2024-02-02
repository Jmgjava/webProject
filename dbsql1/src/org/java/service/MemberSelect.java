package org.java.service;

import java.io.IOException;
import java.lang.reflect.Member;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.java.dao.MemberDao;
import org.java.dto.MemberDto;

public class MemberSelect implements MemberService {

	@Override
	public void executeQueryService() throws IOException, SQLException {
		System.out.println("회원 조회");

		Scanner input = new Scanner(System.in);

		MemberDao dao = MemberDao.getInstance();
		List<MemberDto> member = dao.mSelect();

		if (member.isEmpty()) {
			System.out.println("조회할 회원이 없습니다.");
		} else {
			for (MemberDto members : member) {
				System.out.print("No: " + members.getNo() + " ");
				System.out.print("Title: " + members.getTitle() + " ");
				System.out.print("Content: " + members.getContent() + " ");
				System.out.print("Writer: " + members.getWriter() + " ");
				System.out.print("NickName: " + members.getNickname() + " ");
				System.out.println();
			}
		}
	}

}
