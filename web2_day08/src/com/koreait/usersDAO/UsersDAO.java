package com.koreait.usersDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.koreait.usersDTO.UsersDTO;

public class UsersDAO {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	// 회원가입(insertUser)
	public void insertUser(UsersDTO user) {
		String query = "INSERT INTO TBL_USERS (USERS_ID, USERS_PW, USERS_NAME, USERS_EMAIL) VALUES(?, ?, ?, ?)";

		try {
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getUsersId());
			preparedStatement.setString(2, user.getUsersPw());
			preparedStatement.setString(3, user.getUsersName());
			preparedStatement.setString(4, user.getUsersEmail());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("insertUser() SQL 오류!");
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("insertUser() 연결종료 오류!!");
				e.printStackTrace();
			}
		}
	}

	// 로그인(login)
	public String login(String id, String pw) {
		String query = "SELECT USERS_NAME FROM TBL_USERS WHERE USERS_ID = ? AND USERS_PW = ?";
		String name = null;

		try {
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, pw);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				name = resultSet.getString("USERS_NAME");
			}
		} catch (SQLException e) {
			System.out.println("login() SQL 오류!!");
		} finally {
			close();
//         try {
//            if(resultSet != null) {
//               resultSet.close();
//            }
//            
//            if(preparedStatement != null) {
//               preparedStatement.close();
//            }
//            
//            if(connection != null) {
//               connection.close();
//            }
//            
//         } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//         }
//         
		}
		return name; // 로그인 성공시 이름 반환, 로그인 실패 시 null
	}

	// 아이디 중복확인(checkId)
	public boolean checkId(String id) {
		String query = "SELECT 1 FROM TBL_USERS WHERE USERS_ID = ?";
		try {
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return true; // 테이블에 이미 존재하는 id이므로 해당 아이디로 가입 불가
			}
		} catch (SQLException e) {
			System.out.println("checkId() sql 오류!");
		} finally {
			close();
		}

		return false;
	}

	// 전체조회(selectAll)
	// List<UserDTO> 객체명 = new ArrayList<>();

	// 공통 연결 종료 처리(close 메소드)
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println("DB 연결 해제 오류!");
		}
	}

}
