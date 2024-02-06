package org.java.controller;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.java.dao.Test_tb2Dao;
import org.java.service.Test_tb2DeleteService;
import org.java.service.Test_tb2InsertService;
import org.java.service.Test_tb2SelectService;
import org.java.service.Test_tb2Service;
import org.java.service.Test_tb2UpdateService;

public class Test_tb2Controller{

	public static void main(String[] args) throws ServletException,IOException {
		
		Test_tb2Service service=null;
		
		Scanner input= new Scanner(System.in);
		
		while(true) {
			System.out.println("쿼리문 입력");
			
			String query=input.next();
			
			if(query.equals("insert")) {				
				service=new Test_tb2InsertService();
				service.executeQueryService(null, null);
			}else if(query.equals("update")) {
				service=new Test_tb2UpdateService();
				service.executeQueryService(null, null);
			}else if(query.equals("delete")) {
				service=new Test_tb2DeleteService();
				service.executeQueryService(null, null);
			}else if(query.equals("update")) {
				service=new Test_tb2UpdateService();
				service.executeQueryService(null, null);
			}else if(query.equals("select")) {
				service=new Test_tb2SelectService();
				service.executeQueryService(null, null);
			}else if(query.equals("exit")) {
				System.out.println("종료");
				break;
			}else {
				System.out.println("입력오류 -> 다시");
			}
		}
		
		
	}
}
