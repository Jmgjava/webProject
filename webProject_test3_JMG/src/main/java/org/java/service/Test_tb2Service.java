package org.java.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Test_tb2Service {
//						 	클라이언트 요청 정보(사용자 정보) , Controller(View -> 클라이언트)응답
	void excuteQueryService(HttpServletRequest request, HttpServletResponse respond)
			throws ServletException, IOException;

}
