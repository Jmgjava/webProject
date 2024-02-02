package org.java.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import org.java.dao.BoardDao;
import org.java.dao.MemberDao;
import org.java.dto.BoardDto;
import org.java.dto.MemberDto;

public class BoardDelete implements BoardService {

	@Override
	public void executeQueryService() throws IOException, SQLException {
		System.out.println("회원가입");

		Scanner input = new Scanner(System.in);

		System.out.println("삭제할 no 입력:");
		int no = input.nextInt();

		BoardDao dao = BoardDao.getInstance();

		int result = dao.bDelete(no);

		if (result != 1) {
			System.out.println("회원가입 실패");
		} else {
			System.out.println("회원가입 성공");
		}

	}
}
