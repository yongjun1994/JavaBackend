package com.koreait.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.userDAO.UserDAO;
import com.koreait.userDTO.UserDTO;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public JoinServlet() {
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
		System.out.println("post 메소드 실행!");

		// 0. 한글깨짐 방지!!! 인코딩 설정
		request.setCharacterEncoding("UTF-8");

		// 1. 사용자가 화면에서 입력한 값(파라미터) 수집
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");

		// 2. UserDTO 객체 생성
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(userId);
		userDTO.setUserPw(userPw);
		userDTO.setUserName(userName);
		userDTO.setUserEmail(userEmail);

		// 3. UserDAO 객체 생성 후 로직 실행
		UserDAO userDAO = new UserDAO();

		// 3-1. 아이디 중복검사 메소드 호출(실행)
		if (userDAO.checkId(userId)) {
			// 아이디가 이미 존재하면 다시 회원가입 페이지로 이동
			request.setAttribute("error", "이미 사용중인 아이디 입니다");
			request.getRequestDispatcher("join.jsp").forward(request, response);
			return;
		}

		// 3-2. 아이디가 중복되지 않았다면 회원가입 진행
		userDAO.insertUser(userDTO);

		// 4. 회원가입 후 로그인 페이지로 리다이렉트
		response.sendRedirect("login.jsp");

	}

}
