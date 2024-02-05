package org.java.service;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.java.dao.Test_tb2Dao;
import org.java.dto.Test_tb2Dto;

public class Test_tb2Update implements Test_tb2Service {

	@Override
	public void excuteQueryService(HttpServletRequest request, HttpServletResponse respond)
			throws ServletException, IOException {
		System.out.println("수정 서비스");

		Scanner input = new Scanner(System.in);

		System.out.println("수정하고 싶은 회원 번호 입력:");
		int no = input.nextInt();
		System.out.println("수정할 ID 입력:");
		String userId = input.next();
		System.out.println("수정할 Pw 입력:");
		String userPw = input.next();
		System.out.println("수정할 email 입력:");
		String email = input.next();

		Test_tb2Dao dao = Test_tb2Dao.getInstnace();

		Test_tb2Dto board = new Test_tb2Dto(no, userId, userPw, email);

		int exist = dao.tbcheck(userId);
		if (exist != 1) {
			System.out.println("회원수정 실패");
			throw new IllegalArgumentException("수정할 회원이 존재하지 않습니다.");
		}

		int result = dao.tbUpdate(board);
		
		if (result != 1) {
			System.out.println("회원수정 실패");
		} else {
			System.out.println("회원수정 성공");
		}
	}
}
