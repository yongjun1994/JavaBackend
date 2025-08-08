package com.koreait.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.userDAO.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 0. 한글깨짐 방지!!! 인코딩 설정
		request.setCharacterEncoding("UTF-8");

		// 1. 사용자가 입력한 값을 받아와서 저장(파라미터 수집)
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");

		// 2. UserDAO 클래스안의 메소드 호출
		UserDAO userDAO = new UserDAO();
		String userName = userDAO.login(userId, userPw); // 이름 반환

		// 3. 로그인 성공 여부 판단
		if (userName != null) {
			request.setAttribute("userName", userName);

			request.getRequestDispatcher("main.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
