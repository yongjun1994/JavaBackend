package com.koreait.test;

import java.util.Scanner;

import com.koreait.userDAO.UserDAO;
import com.koreait.userDTO.UserDTO;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserDAO userDAO = new UserDAO();
		boolean run = true;

		while (run) {
			System.out.println("======회원관리 프로그램=====\n");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("0. 종료");
			System.out.println("메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				System.out.println("===회원가입 메뉴===");
				System.out.println("아이디 입력 : ");
				String id = sc.nextLine();
				if (userDAO.checkId(id)) {
					System.out.println("이미 사용중인 아이디입니다");
					break;
				}
				System.out.println("비밀번호 입력 : ");
				String pw = sc.nextLine();
				System.out.println("이름입력 : ");
				String name = sc.nextLine();
				System.out.println("나이 입력 : ");
				int age = sc.nextInt();
				sc.nextLine();
				System.out.println("성별(M/F) 입력 : ");
				String gender = sc.nextLine();

				UserDTO newUser = new UserDTO();
				newUser.setUserId(id);
				newUser.setUserPw(pw);
				newUser.setUserName(name);
				newUser.setUserAge(age);
				newUser.setUserGender(gender);

				userDAO.insertUser(newUser);
				System.out.println("회원가입 성공");
				break; // case문마다 break문 필수!!!
			case 2:
				System.out.println("=====로그인 메뉴=====");
				int count = 0;
				final int MAX_ATTEMPT = 3;
				UserDTO loginUser = null;
				boolean isLogin = false;

				while (count < MAX_ATTEMPT) {
					System.out.println("아이디 입력 : ");
					String loginId = sc.nextLine();

					System.out.println("비밀번호 입력 : ");
					String loginPw = sc.nextLine();

					String loginName = userDAO.login(loginId, loginPw);
					if (loginName != null) {
						System.out.println(loginName + "님 환영합니다!");

						// 로그인 한 유저 객체 가져오기
						for (UserDTO user : userDAO.selectAll()) {
							if (user.getUserId().equals(loginId)) {
								loginUser = user;
								break;
							}
						}

						// 로그인 성공 시 메뉴
						isLogin = true;

						boolean loginMenu = true;
						while (loginMenu) {
							System.out.println("===[로그인 메뉴]===");
							System.out.println("1. 회원정보 수정");
							System.out.println("2. 비밀번호 변경");
							System.out.println("3. 회원탈퇴");
							System.out.println("번호 선택 : ");
							int subMenu = sc.nextInt();
							sc.nextLine();

							switch (subMenu) {
							case 1:
								System.out.println("====[회원정보 수정 메뉴]====");
								System.out.println("이름 수정 : ");
								loginUser.setUserName(sc.nextLine());
								System.out.println("나이 수정 : ");
								loginUser.setUserAge(sc.nextInt());
								sc.nextLine();
								boolean updateUser = userDAO.updateUser(loginUser);
								System.out.println(updateUser ? "수정완료" : "수정실패");
								break;
							case 2:
								System.out.println("====[비밀번호 변경 메뉴]====");
								System.out.println("현재 비밀번호 입력 : ");
								String currentPw = sc.nextLine();
								System.out.println("새로운 비밀번호 입력 : ");
								String newPw = sc.nextLine();
								boolean pwChange = userDAO.changePw(loginUser.getUserId(), currentPw, newPw);
								System.out.println(pwChange ? "비밀번호 변경완료" : "비밀번호 변경실패");
								break;
							case 3:
								System.out.println("회원탈퇴를 진행합니다");
								System.out.println("비밀번호 확인 : ");
								String delPw = sc.nextLine();

								boolean deleteUser = userDAO.deleteUser(loginUser.getUserId(), delPw);
//								System.out.println(deleteUser ? "회원탈퇴 성공!!" : "회원탈퇴 실패!");
								if (deleteUser) {
									System.out.println("회원탈퇴 성공!!");
									loginMenu = false; // 로그인 메뉴 종료
									run = false; // 전체 프로그램 종료
								} else {
									System.out.println("회원탈퇴 실패!");
								}
								break;
							} //로그인 성공시 메뉴의 switch문 중괄호 끝

						} //로그인 성공시 메뉴의 반복문 while문 중괄호 끝

						break;

					} else {
						System.out.println("아이디나 비밀번호를 다시 확인하세요.");
					}
				}
				break;
			case 0:
				run = false;
				System.out.println("프로그램을 종료합니다.");
				break;
			} // switch 중괄호 끝
		} // while문 중괄호 끝
		System.out.println("반복문 종료");

		sc.close();
	}// main 메소드 중괄호 끝
} // class 중괄호 끝
