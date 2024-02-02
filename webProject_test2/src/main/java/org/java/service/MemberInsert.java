package org.java.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import org.java.dao.MemberDao;
import org.java.dto.MemberDto;

public class MemberInsert implements MemberService {

	@Override
	public void executeQueryService() throws IOException, SQLException {
		System.out.println("회원가입");

		Scanner input = new Scanner(System.in);

		System.out.println("가입할 userId 입력: ");
		String userId = input.next();
		System.out.println("가입할 userPw 입력: ");
		String userPw = input.next();
		System.out.println("가입할 phone 입력:");
		String phone = input.next();

		MemberDao dao = MemberDao.getInstance();

		MemberDto board = new MemberDto(userId, userPw, phone);

// 		==========아이디 체크==========
		int exist = dao.isMember(userId);

		if (exist == 1) {
			System.out.println("이미 회원이 존재합니다.");
//			return;
			throw new IllegalArgumentException("이미 회원등록이 되어있음");
		}
//		 ==========아이디체크==========

		int result = dao.Insert(board);

		if (result != 1) {
			System.out.println("회원가입 실패");
		} else {
			System.out.println("회원가입 성공");
		}

	}

}
