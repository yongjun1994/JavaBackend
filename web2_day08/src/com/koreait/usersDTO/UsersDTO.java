package com.koreait.usersDTO;

public class UsersDTO {
//   -- 회원 테이블(TBL_USERS)
//   create table TBL_USERS(
//      users_number INT auto_increment primary key,
//      users_id varchar(20) not null unique, -- 로그인 아이디(중복 불가, null 허용하지않음)
//      users_pw varchar(20) not null, -- 비밀번호(null 허용하지 않음)
//      users_name varchar(50) not null, -- 이름
//      users_email varchar(100) unique -- 이메일(중복 불가)
//   );

	// 필드(접근제한자 private)
	private int usersNumber;
	private String usersId;
	private String usersPw;
	private String usersName;
	private String usersEmail;
	
	// 게터, 세터 메소드 추가
	// alt + shift + s + r => alt + a(전체선택) => alt + g
	public int getUsersNumber() {
		return usersNumber;
	}
	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}
	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}
	public String getUsersPw() {
		return usersPw;
	}
	public void setUsersPw(String usersPw) {
		this.usersPw = usersPw;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public String getUsersEmail() {
		return usersEmail;
	}
	public void setUsersEmail(String usersEmail) {
		this.usersEmail = usersEmail;
	}
	
	// toString  오버라이딩 => alt + shift + s + s
	@Override
	public String toString() {
		return "UsersDTO [usersNumber=" + usersNumber + ", usersId=" + usersId + ", usersPw=" + usersPw + ", usersName="
				+ usersName + ", usersEmail=" + usersEmail + "]";
	}
	
	
}