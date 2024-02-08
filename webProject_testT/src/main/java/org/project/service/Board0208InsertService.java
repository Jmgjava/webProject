package org.project.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.dao.Board0208Dao;

public class Board0208InsertService implements Board0208Service {

	@Override
	public void executeQueryService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("게시글 작성(board0208 Table)");

		Board0208Dao dao = Board0208Dao.getInstance();
		// 사용자 입력정보를 컨트롤러 -> 서비스로 전달
		// 클라이언트 title -> form <inpt name=''>
		String title = request.getParameter("title");

		// 클라이언트 content -> form <inpt name=''>
		String content = request.getParameter("content");

		// 클라이언트 userId -> form <inpt name=''>
		String userId = request.getParameter("userId");

		int result = dao.write(title, content, userId);

		String returnURL = "";

		if (result != 1) {
			System.out.println("회원가입 실패");
			// 실패시 View (사용자. 브라우저)
			returnURL = "/board_fail.jsp";
		} else {
			System.out.println("회원가입 성공");
			// 성공시 View (사용자. 브라우저)
			returnURL = "/board_success.jsp";
		}
		// request.setAttribute("설정키", 값(Object));
		request.setAttribute("returnURL", returnURL);
	}

}
