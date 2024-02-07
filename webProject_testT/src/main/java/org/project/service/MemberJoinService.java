package org.project.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.dao.MemberDao;
import org.project.dto.MemberDto;

public class MemberJoinService implements MemberService {

	@Override
	public void executeQueryService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("목록join조회(회원)");

		MemberDao dao = MemberDao.getInstance();

		List<MemberDto> members = dao.selectJoinALL();

		if (!members.isEmpty()) {

			for (MemberDto member : members) {
				System.out.println("번호: " + member.getCustno());
				System.out.println("이름: " + member.getCustname());
				System.out.println("핸드폰: " + member.getPhone());
				System.out.println("주소: " + member.getAddress());
				System.out.println("날짜: " + member.getJoindate());
				System.out.println("등급: " + member.getGrade());
				System.out.println("지역: " + member.getCity());
			}

		} else {
			System.out.println("조회 할 회원 X");
		}

		request.setAttribute("members", members);
		request.setAttribute("returnURL", "memberList.jsp");
	}
}
