package org.java.service;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.java.dao.Test_tb2Dao;


public class Test_tb2InsertService implements Test_tb2Service {

	@Override
	public void executeQueryService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			System.out.println("등록 서비스");
			
			Scanner input= new Scanner(System.in);	

			System.out.println("userId");
			String userId = input.next();

			System.out.println("userAge");
			int userAge = input.nextInt();

			System.out.println("userName");
			String userName = input.next();
			
			
			Test_tb2Dao dao = Test_tb2Dao.getInstance();

			
			// 아이디 있다(이미 회원등록이 되어있다)
			int result = dao.insert(userId, userAge, userName);

			if (result != 1) {
				System.out.println("회원가입 Fail!");
			} else {
				System.out.println("회원가입 Success!");
			}
			
		
	}
}
