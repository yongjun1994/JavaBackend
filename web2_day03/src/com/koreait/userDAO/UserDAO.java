package com.koreait.userDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koreait.userDTO.UserDTO;

public class UserDAO {
	// 연결, 쿼리문실행, 결과받아올 수 있는 객체 선언
	public Connection connection;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet;
	// 자동 import 단축키 : ctrl + shift + o

	// 전체 회원 조회 메소드 작성
	public List<UserDTO> selectAll() {
		List<UserDTO> userList = new ArrayList<>();
		String query = "SELECT * FROM TBL_USER ORDER BY USER_NUMBER";

		try {
			// 연결하기 위한 connection 객체
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				UserDTO user = new UserDTO();
				user.setUserNumber(resultSet.getInt("USER_NUMBER"));
				user.setUserId(resultSet.getString("USER_ID"));
				user.setUserPw(resultSet.getString("USER_PW"));
				user.setUserName(resultSet.getString("USER_NAME"));
				user.setUserAge(resultSet.getInt("USER_AGE"));
				user.setUserGender(resultSet.getString("USER_GENDER"));
				userList.add(user);
			}

		} catch (SQLException e) {
			System.out.println("selectAll() 전체 회원 조회 SQL오류!");
			e.printStackTrace();
		} finally {
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
				System.out.println("연결 해제시 오류!");
				e.printStackTrace();
			}
		}

		return userList;
	} // selectAll 메소드 중괄호 끝

	// 회원가입 메소드
	public void insertUser(UserDTO userDTO) {
		String query = "INSERT INTO TBL_USER(USER_NUMBER, USER_ID, USER_PW, USER_NAME, USER_AGE, USER_GENDER) "
				+ "VALUES(SEQ_USER_NO.NEXTVAL, ?, ?, ?, ?, ?)";

		try {
			// 연결 성공 => 오라클로 쿼리문을 보낼 수 있다 => 쿼리실행 가능해진다
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(query);
			// 쿼리문이 미완성된 상태이므로 ?로 된 부분을 채워준다
			preparedStatement.setString(1, userDTO.getUserId());
			preparedStatement.setString(2, userDTO.getUserPw());
			preparedStatement.setString(3, userDTO.getUserName());
			preparedStatement.setInt(4, userDTO.getUserAge());
			preparedStatement.setString(5, userDTO.getUserGender());
			// INSERT 쿼리문 실행(executeUpdate() 메소드 사용) insert, delete, update 쓸 때 사용하는 메소드
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("insertUser() 회원가입 메소드 SQL오류!!");
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
				System.out.println("insertUser() 연결 종료 오류!");
				e.printStackTrace();
			}

		}

	} // insertUser() 메소드 중괄호 영역 끝

	// 아이디 중복확인 메소드
	public boolean checkId(String userId) {
		String query = "SELECT USER_NUMBER FROM TBL_USER WHERE USER_ID = ?";

		try {
			// db연결
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);

			// 쿼리실행
			resultSet = preparedStatement.executeQuery();

			// 결과가 있다면 해당 ID가 존재하는것
			if (resultSet.next()) {
				return true;
			}

		} catch (SQLException e) {
			System.out.println("checkId() ID 중복 확인 메소드 SQL오류!!");
			e.printStackTrace();
		} finally {
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
				System.out.println("checkId() 연결 종료 오류");
				e.printStackTrace();
			}
		}

		return false;

	} // checkId() 메소드 중괄호 끝

	// 로그인 메소드
	public String login(String userId, String userPw) {

		String query = "SELECT user_name FROM tbl_user "
				+ "WHERE user_id = ? AND user_pw = ?";
		String name = null;

		try {
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userPw);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				name = resultSet.getString("user_name");
			}

		} catch (SQLException e) {
			System.out.println("login() 로그인 메소드 SQL 오류");
			e.printStackTrace();
		} finally {
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
				System.out.println("login() 연결 종료 오류");
				e.printStackTrace();
			}
		}

		return name; // 로그인 성공시 이름 반환, 실패시 null

	} // login() 메소드 중괄호 끝

	// 회원정보 수정 메소드
	public boolean updateUser(UserDTO userDTO) {
		String query = "UPDATE tbl_user " + "SET user_id = ?, user_pw=?, user_name=?, user_age=?, user_gender=? "
				+ "WHERE user_number = ?";

		try {
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(query);

			// 물음표 채우기 set자료형(물음표순서, 어떤값으로 넣을지-지금은 userDTO의 게터이용)
			preparedStatement.setString(1, userDTO.getUserId());
			preparedStatement.setString(2, userDTO.getUserPw());
			preparedStatement.setString(3, userDTO.getUserName());
			preparedStatement.setInt(4, userDTO.getUserAge());
			preparedStatement.setString(5, userDTO.getUserGender());
			preparedStatement.setInt(6, userDTO.getUserNumber());

			int result = preparedStatement.executeUpdate();
			// executeUpdate() 0 : 수정된 행이 없음, 1 : 1개의 행이 성공적으로 수정됨, -1 : 보통은 안나옴(DDL 등)
			return result > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("updateUser() 메소드 sql 오류!!");
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
				System.out.println("updateUser() 연결종료 오류!");
			}
		}

		return false; // false 변경되지 않았음을 의미
	} // updateUser() 메소드 중괄호 끝

	// 비밀번호 변경 메소드
	public boolean changePw(String userId, String currentPw, String newPw) {
		String query = "UPDATE tbl_user " + "SET USER_PW = ? " + "WHERE USER_ID = ? AND USER_PW = ?";

		try {
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(query);
			// 물음표 완성 코드 작성
			preparedStatement.setString(1, newPw);
			preparedStatement.setString(2, userId);
			preparedStatement.setString(3, currentPw);

			int result = preparedStatement.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			System.out.println("changePw() 메소드 sql 오류!");
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("changePw() 연결 종료 오류!");
			}
		}

		return false;

	}// changePw() 메소드 끝

	// 회원탈퇴 메소드(Test 클래스에서 사용한 회원탈퇴메소드)
	public boolean deleteUser(int userNumber) {
		String query = "DELETE FROM TBL_USER " + "WHERE USER_number = ?";

		try {
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, userNumber);

			int result = preparedStatement.executeUpdate();
			System.out.println(result);
			return result > 0;
		} catch (SQLException e) {
			System.out.println("deleteUser() sql 오류!");
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	} // deleteUser 메소드 끝
	
	// 회원탈퇴 메소드(Main 클래스에서 사용할 회원탈퇴 메소드)
	public boolean deleteUser(String id, String pw) {
		String query = "DELETE FROM tbl_user WHERE user_id = ? AND user_pw = ?";
		int result = 0;
		
		try {
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, id);
			preparedStatement.setString(2, pw);
			result = preparedStatement.executeUpdate();
			System.out.println("삭제된 행 수 : " + result);
			return result > 0;
		}catch(SQLException e) {
			System.out.println("deleteUser(id, pw) 메소드 SQL 오류!");
		}finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("delete(id, pw) 메소드 연결종료 오류");
				e.printStackTrace();
			}
		}
		return false;
	}
	
	
	

} // 클래스 중괄호 끝





















