package org.java.service;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.java.dao.Test_tb2Dao;

public class Test_tb2Delete implements Test_tb2Service {

	@Override
	public void excuteQueryService(HttpServletRequest request, HttpServletResponse respond)
			throws ServletException, IOException {
		System.out.println("삭제 서비스");

		Scanner input = new Scanner(System.in);

		System.out.println("삭제할 회원ID 입력: ");
		String userId = input.next();

		Test_tb2Dao dao = Test_tb2Dao.getInstnace();

		int exist = dao.tbcheck(userId);
		if (exist != 1) {
			System.out.println("회원삭제 실패");
			throw new IllegalArgumentException("삭제할 회원이 존재하지 않습니다.");
		}

		int result = dao.tbDelete(userId);
		
		if (result != 1) {
			System.out.println("회원삭제 실패");
		} else {
			System.out.println("회원삭제 성공");
		}
	}
}
