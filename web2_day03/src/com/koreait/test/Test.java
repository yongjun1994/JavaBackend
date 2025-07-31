package com.koreait.test;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.koreait.userDAO.DBConnector;
import com.koreait.userDAO.UserDAO;
import com.koreait.userDTO.UserDTO;

public class Test {
	public static void main(String[] args) {
		// 연결 테스트
//		Connection connection = DBConnector.getConnection();
//		//자동 import 단축키 : ctrl + shift + o
//		try {
//			connection.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// DB 연결 객체 선언
		Connection connection = DBConnector.getConnection();
		// UserDAO 객체 생성(UserDAO 안에 있는 메소드 사용하기 위함)
		UserDAO userDAO = new UserDAO();

		// 전체 회원 조회 메소드 호출
		List<UserDTO> userList = userDAO.selectAll();
		// 결과출력
		System.out.println(userList);

		// 반복문 통해 한 명씩 꺼내올 수 있다
		for (UserDTO user : userList) {
			System.out.println(user);
		}

//		//회원가입하기 위한 DTO 객체 생성 및 값 설정
//		UserDTO newUser = new UserDTO();
//		newUser.setUserId("test");
//		newUser.setUserPw("test123");
//		newUser.setUserName("신짱구1");
//		newUser.setUserAge(5);
//		newUser.setUserGender("F");
//		
//		//회원가입 메소드 호출
//		userDAO.insertUser(newUser);
//		System.out.println("회원가입 성공");

		// id 중복 확인 메소드 호출
//		boolean idCheck = userDAO.checkId("test1");
//		if(idCheck) {
//			System.out.println("id는 이미 존재합니다");
//		}else {
//			System.out.println("사용 가능한 id입니다");
//		}

//		// 자동정렬 : ctrl + shift + f
//		// 상수 : 값을 변경할 수 없음(대문자로 쓰고 _로 연결)
//		// final 키워드가 온다
//		final int MAX_ATTEMPT = 3; //상수선언 3이라는 값으로 고정
//		int count = 0; //while문의 조건식에서 비교대상이 될 변수
//		boolean islogin = false; //플래그변수(상태를 확인하게 해줄 변수)
//
//		while (count < MAX_ATTEMPT) {
//			// 로그인 메소드 호출
//			Scanner sc = new Scanner(System.in);
//			System.out.println("아이디를 입력하세요 : ");
//			String userId = sc.nextLine();
//
//			System.out.println("패스워드를 입력하세요 : ");
//			String userPw = sc.nextLine();
//
//			// 로그인 시도
//			String name = userDAO.login(userId, userPw);
//
//			if (name != null) {
//				System.out.println(name + "님, 로그인 되었습니다!");
//				islogin = true; //플래그 변수 이용
//				break; //로그인 성공시 반복문(while) 종료
//			} else {
//				count++; //증감연산자, count 변수에 1씩 더함
//				System.out.println("로그인 실패! 아이디와 비밀번호를 확인하세요!"
//						+ "(" + count + "/" + MAX_ATTEMPT + ")");
//			}
//
//		} //while문 중괄호 끝
//
//		if(!islogin) {
//			System.out.println("로그인 3회 실패! 프로그램을 종료합니다");
//		}
//		
//		//회원정보 수정
//		//수정할 사용자 정보 생성
//		UserDTO newUser1 = new UserDTO();
//		newUser1.setUserId("newTest");
//		newUser1.setUserPw("newTest");
//		newUser1.setUserName("이름수정중");
//		newUser1.setUserAge(10);
//		newUser1.setUserGender("F");
//		newUser1.setUserNumber(2);
//		
//		boolean updateResult = userDAO.updateUser(newUser1);
//		if(updateResult) {
//			System.out.println("회원정보 수정 완료");
//		}else {
//			System.out.println("회원정보 수정 실패");
//		}

//		//비밀번호 변경 메소드 호출
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("아이디 입력 : ");
//		String userId = sc.nextLine();
//		
//		System.out.println("현재 비밀번호 입력 : ");
//		String currentPw = sc.nextLine();
//		
//		System.out.println("새 비밀번호 입력 : ");
//		String newPw = sc.nextLine();
//		
//		boolean chPw = userDAO.changePw(userId, currentPw, newPw);
//		if(chPw) {
//			System.out.println("비밀번호가 성공적으로 변경되었습니다");
//		}else {
//			System.out.println("비밀번호 변경 실패! 아이디 또는 현재 비밀번호가 일치하지 않습니다");
//		}

		// 회원탈퇴 메소드 호출
		boolean deleteResult = userDAO.deleteUser(1);
		if (deleteResult) {
			System.out.println("회원탈퇴 성공!");
		} else {
			System.out.println("회원탈퇴 실패!");
		}

	} // 메인메소드 끝
} // 클래스 끝
