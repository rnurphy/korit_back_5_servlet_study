package com.study.servlet_study.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getMethod());
		System.out.println(request.getRequestURL());	// 주소를 풀로 가져옴
		System.out.println(request.getRequestURI());	// 서버 주소(앞부분)는 제외
		
		System.out.println(response.getStatus());
		
		response.setContentType("text/plain");			// 응답을 해줄 때의 타입을 지정
//		response.setCharacterEncoding("UTF-8");			// 한글로 응답받을려면 UTF-8 지정
		System.out.println(response.getContentType());
		
		response.getWriter().println("hello");			
		
		System.out.println("요청이 들어옴!!!");		
		
	}

}
