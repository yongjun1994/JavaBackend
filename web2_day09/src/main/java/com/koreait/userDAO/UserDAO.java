package com.koreait.userDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.koreait.userDTO.UserDTO;

public class UserDAO {
	// insertUser() : 회원가입 메소드
	// checkId() : 아이디 중복검사 메소드
	// join.jsp 실행 -> 사용자 입력
	// 입력된 값을 JoinServlet.java(서블릿)에서 받아서
	// checkId() 먼저 실행 -> 중복여부 확인
	// 중복이 없으면 insertUser() 실행
	// 이후 login.jsp로 이동

//   Connection connection;
//   PreparedStatement preparedStatement;
//   ResultSet resultSet;

	// 회원가입 메소드(insertUser)
	public void insertUser(UserDTO user) {
		String query = "INSERT INTO TBL_USER " + "VALUES(seq_user.nextval, ?, ?, ?, ?)";

		try (Connection connection = DBConnector.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			// ?에 값 세팅
			preparedStatement.setString(1, user.getUserId());
			preparedStatement.setString(2, user.getUserPw());
			preparedStatement.setString(3, user.getUserName());
			preparedStatement.setString(4, user.getUserEmail());

			// 쿼리 실행
			int result = preparedStatement.executeUpdate();

			if (result > 0) {
				System.out.println("회원가입 성공!");
			} else {
				System.out.println("회원가입 실패!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//      } finally {
//         // 공통 자원 정리하는 메소드 close() 호출
//         
//      }
	} // insertUser() 메소드 중괄호 끝

	// 아이디 중복검사 메소드(checkId())
	public boolean checkId(String userId) {
		String query = "SELECT 1 " + "FROM TBL_USER " + "WHERE USER_ID = ?";
		boolean isDuplicate = false;

		try (Connection connection = DBConnector.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			// ? 완성시키기
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				isDuplicate = true; // 중복된 아이디가 존재함
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isDuplicate;

	} // checkId() 중괄호 끝
	
	//login() 메소드 추가
	public String login(String userId, String userPw) {
		String query = "SELECT USER_NAME "
				+ "FROM TBL_USER "
				+ "WHERE USER_ID =? AND USER_PW = ?";
		String userName = null;
		
		try (Connection connnection = DBConnector.getConnection();
				PreparedStatement preparedStatement = connnection.prepareStatement(query)) {
			
			// 물음표 완성하기
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userPw);
			// 물음표 채워서 쿼리문 실행하기
			ResultSet resultSet = preparedStatement.executeQuery();
			
			// 행이 있는지 확인하고 있으면 USER_NAME 가져오기
			if(resultSet.next()) {
				userName = resultSet.getString("USER_NAME");
			}
			
			resultSet.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userName;	// 로그인 성공 시 이름반환, 실패시 null 반환
	}

//   private void close() {
//      try {
//         if (resultSet != null) {
//            resultSet.close();
//         }
//         if (preparedStatement != null) {
//            preparedStatement.close();
//         }
//         if (connection != null) {
//            connection.close();
//         }
//      } catch (SQLException e) {
//         System.out.println("DB 자원 해제 오류!!");
//         e.printStackTrace();
//      }
//   }

} // 클래스 중괄호 끝
