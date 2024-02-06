package org.java.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Test_tb2Service {
							//클라이언트 요청 정보 request, 컨트롤러(View-> 클라언트) 응답 response
	void executeQueryService(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException;
}
