package com.koreait.test;

import java.util.Scanner;

import com.koreait.usersDAO.UsersDAO;
import com.koreait.usersDTO.UsersDTO;

public class Test {
	public static void main(String[] args) {
		// 연결테스트
//      Connection connection = DBConnector.getConnection();
//      
//      try {
//         connection.close();
//      } catch (SQLException e) {
//         e.printStackTrace();
//      }

		UsersDTO newUser = new UsersDTO();
		UsersDAO usersDAO = new UsersDAO();
		Scanner sc = new Scanner(System.in);

		// 회원가입 기능 테스트
		System.out.println("===[회원가입]===");

		// 아이디 입력 및 중복 확인
		while (true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();

			if (usersDAO.checkId(id)) {
				System.out.println("이미 사용중인 아이디입니다. 다시 입력하세요.");
			} else {
				newUser.setUsersId(id);
				break;
			}
			System.out.println(newUser);
		}

//      newUser.setUsersId(sc.nextLine());
//      String id = sc.nextLine();
//      newUser.setUsersId(id);

		System.out.print("비밀번호 : ");
		newUser.setUsersPw(sc.nextLine());
		System.out.println(newUser);
		System.out.print("이름 : ");
		newUser.setUsersName(sc.nextLine());
		System.out.println(newUser);
		System.out.print("이메일 : ");
		newUser.setUsersEmail(sc.nextLine());
		System.out.println(newUser);

		usersDAO.insertUser(newUser);
		System.out.println("회원가입 완료!!");

		// 로그인 메소드 호출
//      System.out.println("====[로그인]====");
//      System.out.print("아이디 : ");
//      String id = sc.nextLine();
//      System.out.print("비밀번호 : ");
//      String pw = sc.nextLine();
//
//      String name = usersDAO.login(id, pw);
//      if (name != null) {
//         System.out.println(name + "님 환영합니다!");
//      } else {
//         System.out.println("로그인 실패! 아이디나 패스워드를 확인하세요");
//      }
//      System.out.println("로그인 기능 실행 완료!!");

		// 아이디 중복 체크
//      System.out.println("====[아이디 중복체크]====");
//      System.out.print("중복 확인할 아이디 : ");
//      String id = sc.nextLine();
//      
//      boolean idCheck = usersDAO.checkId(id);
//      System.out.println(idCheck);
//      
//      if(idCheck) {
//         System.out.println(id + "는 이미 사용중인 아이디입니다");
//      }else {
//         System.out.println(id + "는 사용 가능한 아이디입니다");
//      }
//      

	}
}
