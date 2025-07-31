package com.koreait.model;
// 사용자 정보를 저장하는 데이터 객체(DTO)
// 필요한 이유 : 1) 객체 지향적으로 사용자 정보를 하나로 묶기 위함
// 2) UserDTO는 데이터만 가지고 있는 역할(Model 중 DTO)
// 3) ★ 계층 간 데이터 전달을 위해(Controller -> DAO 등)
// DTO(Data Transfer Object) : 데이터를 전달(전송)하기 위한 객체
// 보통 필드만 가지며 로직(비즈니스 처리)은 없음

public class UserDTO {
	// 필드
	// 이름, 나이, 아이디, 비밀번호 데이터만 보관
	private String name;
	private int age;
	private String userId;
	private String userPw;
	
	// alt + shift + a : 그리드 모드
	// 한번에 많은 양의 동일한 값을 입력할 때나 삭제해야할 때 사용하면 유용한 기능
	
	// 생성자 만들기 단축키 : alt + shift + s + o
	public UserDTO(String name, int age, String userId, String userPw) {
		super();
		this.name = name;
		this.age = age;
		this.userId = userId;
		this.userPw = userPw;
	}

	// getter, setter : private 접근 제한자가 붙은 필드에 값을 저장할 때 사용하는 메소드
	// 게터, 세터 만들기 단축키: alt + shift + s + r
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
	
	
	
	
}
