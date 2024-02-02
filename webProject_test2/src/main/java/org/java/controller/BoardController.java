package org.java.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import org.java.service.BoardDelete;
import org.java.service.BoardInsert;
import org.java.service.BoardSelect;
import org.java.service.BoardService;
import org.java.service.BoardUpdate;
import org.java.service.MemberInsert;
import org.java.service.MemberService;

public class BoardController {

	public static void main(String[] args) throws IOException, SQLException {
		System.out.println("컨트롤러");

		BoardService service = null;
		Scanner input = new Scanner(System.in);
		boolean bool = true;

		while (bool) {
			System.out.println("쿼리문 입력");
			String query = input.next();

			if (query.equals("insert")) {
				service = new BoardInsert();
				service.executeQueryService();
			} else if (query.equals("select")) {
				service = new BoardSelect();
				service.executeQueryService();
			} else if (query.equals("update")) {
				service = new BoardUpdate();
				service.executeQueryService();
			} else if (query.equals("delete")) {
				service = new BoardDelete();
				service.executeQueryService();
			} else if (query.equals("exit")) {
				System.out.println("포르그램 종료");
				bool = false;
			} else {
				System.out.println("쿼리문 입력 오류");
			}
		}
	}
}
