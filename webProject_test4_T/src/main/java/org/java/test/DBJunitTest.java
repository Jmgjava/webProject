package org.java.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Scanner;

import org.java.connect.DBConnect;
import org.java.dao.Test_tb2Dao;
import org.java.dto.Test_tb2Dto;
import org.junit.jupiter.api.Test;

class DBJunitTest {

	@Test
	void testInsert() {

		Test_tb2Dao dao = Test_tb2Dao.getInstance();

		Scanner input = new Scanner(System.in);

		System.out.println("userId");
		String userId = input.next();

		System.out.println("userAge");
		int userAge = input.nextInt();

		System.out.println("userName");
		String userName = input.next();

		// 아이디 있다(이미 회원등록이 되어있다)
		int result = dao.insert(userId, userAge, userName);

		if (result != 1) {
			System.out.println("회원가입 Fail!");
		} else {
			System.out.println("회원가입 Success!");
		}
	}

	@Test
	void selectTest() {

		Test_tb2Dao dao = Test_tb2Dao.getInstance();
		List<Test_tb2Dto> tb2Dtos = dao.selectAll();

		if (tb2Dtos.isEmpty()) {
			System.out.println("조회할 회원이 없습니다.");
		} else {
			for (Test_tb2Dto tb2Dto : tb2Dtos) {
				System.out.print("회원번호: " + tb2Dto.getNo());
				System.out.print(" 아이디: " + tb2Dto.getUserId());
				System.out.print(" 나이: " + tb2Dto.getUserAge());
				System.out.println(" 이름: " + tb2Dto.getUserName());
			}
		}
	}

}
