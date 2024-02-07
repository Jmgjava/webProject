package org.project.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.dao.MemberDao;
import org.project.dto.MemberDto;

public class MemberGradeService implements MemberService {

	@Override
	public void executeQueryService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("목록join조회(회원)");

		MemberDao dao = MemberDao.getInstance();

		List<MemberDto> members = dao.selectGradeALL();

		if (!members.isEmpty()) {

			for (MemberDto member : members) {
				System.out.println("이름: " + member.getCustname());
				System.out.println("등급: " + member.getGrade());
			}

		} else {
			System.out.println("조회 할 회원 X");
		}

		request.setAttribute("members", members);
		request.setAttribute("returnURL", "Grade.jsp");
	}
}
