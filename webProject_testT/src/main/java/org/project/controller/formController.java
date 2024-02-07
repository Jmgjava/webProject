package org.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.service.MemberGradeService;
import org.project.service.MemberInsertService;
import org.project.service.MemberJoinService;
import org.project.service.MemberService;

// 
@WebServlet("*.do") // 클라이언트 -> 요청 URI ->서버(Controller)
public class formController extends HttpServlet {

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
		request.setCharacterEncoding("UTF-8");
//		요청정보를 받아서 service에게 일을 시킴
//		service에서 결과를 반환받아 View를 통해서 사용자에서 반환
		String uri = request.getRequestURI(); // 사용자 요청 URI -> basicPath/index.do
		String basicPath = request.getContextPath(); // 서버의 기본경로(Path)
		String url = uri.substring(basicPath.length());

		System.out.println(uri + " << uri");
		System.out.println(basicPath + " << basicPath");
		System.out.println(url + " << url");

		MemberService service = null;
		String returnURL = "";

		if (url.equals("/index.do")) {
			System.out.println("index.jsp"); // 홈페이지(기본)
			returnURL = "/index.jsp";

		} else if (url.equals("/join.do")) {
			returnURL = "/join.jsp";

		} else if (url.equals("/selectALL.do")) {
			service = new MemberInsertService();
			service.executeQueryService(request, response);
			returnURL = (String) request.getAttribute("returnURL");

		} else if (url.equals("/update.do")) {
			returnURL = "/update.jsp";

		} else if (url.equals("/delete.do")) {
			returnURL = "/delete.jsp";

		} else if (url.equals("/selectJoinALL.do")) {
			service = new MemberJoinService();
			service.executeQueryService(request, response);
			returnURL = (String) request.getAttribute("returnURL");
		} else if (url.equals("/selectGrade.do")) {
			service = new MemberGradeService();
			service.executeQueryService(request, response);
			returnURL = (String) request.getAttribute("returnURL");
		}

		// Controller -> View -> JSP페이지로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(returnURL);
		dispatcher.forward(request, response);

	}

}
