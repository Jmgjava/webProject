package org.java.service;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.java.dao.Test_tb2Dao;
import org.java.dto.Test_tb2Dto;

public class Test_tb2Select implements Test_tb2Service {

	@Override
	public void excuteQueryService(HttpServletRequest request, HttpServletResponse respond)
			throws ServletException, IOException {
		System.out.println("조회 서비스");

		Scanner input = new Scanner(System.in);

		Test_tb2Dao dao = Test_tb2Dao.getInstnace();

		List<Test_tb2Dto> member = dao.tbSelect();

		if (member.isEmpty()) {
			System.out.println("조회할 회원이 없습니다.");
		} else {
			for (Test_tb2Dto members : member) {
				System.out.print("No: " + members.getNo() + " ");
				System.out.print("Id: " + members.getUserId() + " ");
				System.out.print("Pw: " + members.getUserPw() + " ");
				System.out.print("Email: " + members.getEmail() + " ");
				System.out.println();
			}

		}
	}
}
