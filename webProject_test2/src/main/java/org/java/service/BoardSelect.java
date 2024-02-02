package org.java.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.java.dao.BoardDao;
import org.java.dao.MemberDao;
import org.java.dto.BoardDto;
import org.java.dto.MemberDto;

public class BoardSelect implements BoardService {

	@Override
	public void executeQueryService() throws IOException, SQLException {
		System.out.println("회원조회");

		Scanner input = new Scanner(System.in);

		BoardDao dao = BoardDao.getInstance();

		List<BoardDto> member = dao.bSelectAll();

		if (member.isEmpty()) {
			System.out.println("조회할 회원이 없습니다");
		} else {
			for (BoardDto members : member) {
				System.out.print("No: " + members.getNo());
				System.out.print("Title: " + members.gettitle());
				System.out.print("Content: " + members.getContent());
				System.out.print("Writer: " + members.getWriter());
				System.out.print("NickName: " + members.getNickName());
				System.out.println();
			}
		}

	}
}
