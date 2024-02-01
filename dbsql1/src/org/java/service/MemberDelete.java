package org.java.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import org.java.dao.MemberDao;
import org.java.dto.MemberDto;

public class MemberDelete implements MemberService {

	@Override
	public void executeQueryService() throws IOException, SQLException {
		System.out.println("회원 삭제");

		Scanner input = new Scanner(System.in);

		System.out.println("삭제할 no 입력: ");
		int no = input.nextInt();

		MemberDao dao = MemberDao.getInstance();

		int result = dao.mDelete(no);

		if (result != 1) {
			System.out.println("회원삭제 성공");
		} else {
			System.out.println("회원삭제 실패");
		}

	}
}
