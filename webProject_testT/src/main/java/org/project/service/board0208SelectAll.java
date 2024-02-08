package org.project.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.dao.Board0208Dao;
import org.project.dto.Board0208Dto;

public class board0208SelectAll implements Board0208Service {

	@Override
	public void executeQueryService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("게시글 조회(전체)");

		Board0208Dao dao = Board0208Dao.getInstance();

		List<Board0208Dto> boardList = dao.selectAll();

		String returnURL = "";

		if (boardList.isEmpty()) {
			System.out.println("조회할 게시글 X");

			request.setAttribute("boardList", null);
		} else {
			System.out.println("조회할 게시글 O");

			request.setAttribute("boardList", boardList);

			for (Board0208Dto list : boardList) {
				System.out.print("번호: " + list.getNo() + " ");
				System.out.print("제목: " + list.getTitle() + " ");
				System.out.print("내용: " + list.getContent() + " ");
				System.out.print("글쓴이: " + list.getUserId() + " ");
			}
		}

		request.setAttribute("returnURL", "/boardListView.jsp");

	}

}
