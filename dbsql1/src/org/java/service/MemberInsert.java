package org.java.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import org.java.dao.MemberDao;
import org.java.dto.MemberDto;

public class MemberInsert implements MemberService {

	@Override
	public void executeQueryService() throws IOException, SQLException {
		System.out.println("회원 가입");

		Scanner input = new Scanner(System.in);

		System.out.println("가입할 no 입력: ");
		int no = input.nextInt();
		System.out.println("가입할 title 입력: ");
		String title = input.next();
		System.out.println("가입할 content 입력: ");
		String content = input.next();
		System.out.println("가입할 writer 입력:");
		String writer = input.next();
		System.out.println("가입할 nickName 입력: ");
		String nickname = input.next();

		MemberDto board = new MemberDto(no, title, content, writer, nickname);

		MemberDao dao = MemberDao.getInstance();

		int result = dao.mInsert(board);

		if (result != 1) {
			System.out.println("회원가입 성공");
		} else {
			System.out.println("회원가입 실패");
		}
	}

}
