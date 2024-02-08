package org.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.service.Board0208InsertService;
import org.project.service.Board0208SelectOneService;
import org.project.service.Board0208Service;
import org.project.service.board0208SelectAll;

@WebServlet("*.bo")
public class Board0208Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("GET");
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("POST");
		request.setCharacterEncoding("UTF-8"); // 한글 깨짐 방지

		String uri = request.getRequestURI(); // 요청 URI
		String path = request.getContextPath(); // 기본 Path
		String url = uri.substring(path.length()); // 기본path/boardInsert.bo 분리하기 위해

		Board0208Service service = null;
		String returnURL = "";
		// 게시글 작성 테이블
		if (url.equals("/boardJoinView.bo")) {
			returnURL = "/boardJoinView.jsp";

		} else if (url.equals("/boardInsert.bo")) {
			service = new Board0208InsertService();
			service.executeQueryService(request, response);

			// service의 결과를 View 반환
			returnURL = (String) request.getAttribute("returnURL");
		} else if (url.equals("/boardListView.bo")) {
			service = new board0208SelectAll();
			service.executeQueryService(request, response);

			returnURL = (String) request.getAttribute("returnURL");
		} else if (url.equals("/boardOneView.bo")) {
			returnURL = "/boardOneView.jsp";
		} else if (url.equals("/boardOneOk.bo")) {
			service = new Board0208SelectOneService();
			service.executeQueryService(request, response);

			returnURL = (String) request.getAttribute("returnURL");
		}

		// Controller -> View
		RequestDispatcher dispatcher = request.getRequestDispatcher(returnURL);
		dispatcher.forward(request, response);

	}

}
