package org.java.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import org.java.dao.MemberDao;
import org.java.dto.MemberDto;

public class MemberUpdate implements MemberService{
	
	@Override
	public void executeQueryService() throws IOException, SQLException {
		System.out.println("회원 수정");

		Scanner input = new Scanner(System.in);

		System.out.println("수정할 no 입력: ");
		int no = input.nextInt();
		System.out.println("수정할 ID 입력: ");
		String title = input.next();
		System.out.println("수정할 Pw 입력: ");
		String content = input.next();
		System.out.println("수정할 writer 입력:");
		String writer = input.next();
		System.out.println("수정할 nickName 입력: ");
		String nickname = input.next();

		MemberDto board = new MemberDto(no, title, content, writer, nickname);

		MemberDao dao = MemberDao.getInstance();

		int result = dao.mUpdate(board);

		if (result != 1) {
			System.out.println("회원수정 실패");
		} else {
			System.out.println("회원수정 성공");
		}
	}
	

}
