package com.koreait.userDTO;

public class UserDTO {
//   CREATE TABLE tbl_user(
//         user_number NUMBER PRIMARY KEY,
//         user_id varchar2(50) NOT NULL UNIQUE,
//         user_pw varchar2(100) NOT NULL,
//         user_name varchar2(100) NOT NULL,
//         user_email varchar2(100)
//      );
	// 필드
	private int userNumber;
	private String userId;
	private String userPw;
	private String userName;
	private String userEmail;

	// 게터, 세터(alt + shift + s + r)
	// alt + a 진행 후 alt + r
	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	// toString 오버라이딩(alt + shift + s + s)
	// 필드 다 체크된 상태 확인 후 alt + g
	@Override
	public String toString() {
		return "UserDTO [userNumber=" + userNumber + ", userId=" + userId + ", userPw=" + userPw + ", userName="
				+ userName + ", userEmail=" + userEmail + "]";
	}

}
