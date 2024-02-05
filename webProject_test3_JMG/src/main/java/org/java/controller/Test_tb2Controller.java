package org.java.controller;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.java.service.Test_tb2Delete;
import org.java.service.Test_tb2Insert;
import org.java.service.Test_tb2Select;
import org.java.service.Test_tb2SelectOne;
import org.java.service.Test_tb2Service;
import org.java.service.Test_tb2Update;

public class Test_tb2Controller {

	public static void main(String[] args) throws ServletException, IOException {
		System.out.println("컨트롤러");

		Scanner input = new Scanner(System.in);
		boolean bool = true;

		Test_tb2Service service = null;

		while (bool) {
			System.out.println("쿼리문 입력");

			String query = input.next();

			if (query.equals("insert")) {
				service = new Test_tb2Insert();
				service.excuteQueryService(null, null);
			} else if (query.equals("select")) {
				service = new Test_tb2Select();
				service.excuteQueryService(null, null);
			} else if (query.equals("selectone")) {
				service = new Test_tb2SelectOne();
				service.excuteQueryService(null, null);
			} else if (query.equals("update")) {
				service = new Test_tb2Update();
				service.excuteQueryService(null, null);
			} else if (query.equals("delete")) {
				service = new Test_tb2Delete();
				service.excuteQueryService(null, null);
			} else if (query.equals("exit")) {
				System.out.println("프로그램 종료");
				bool = false;
			} else {
				System.out.println("쿼리문 입력 오류");
			}
		}

	}

}
