package org.project.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.dao.Board0208Dao;
import org.project.dto.Board0208Dto;

public class Board0208SelectOneService implements Board0208Service {

	@Override
	public void executeQueryService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("게시글조회(하나)");
		// String -> Integer -> int(자동언박싱)
		int no = Integer.parseInt(request.getParameter("no"));

		Board0208Dao dao = Board0208Dao.getInstance();

		Board0208Dto board = dao.selectOne(no);

		String returnURL = "";

		if (board != null) {
			request.setAttribute("board", board);

			returnURL = "/boardOneVIewOk.jsp";

		} else {
			System.out.println("조회할 게시글 X");
			request.setAttribute("board", null);

			returnURL = "/index.do";
		}

		request.setAttribute("returnURL", returnURL);
	}

}
