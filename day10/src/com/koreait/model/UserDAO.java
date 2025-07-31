package com.koreait.model;

import java.util.ArrayList;
import java.util.List;

// 사용자 데이터를 메모리에 저장하고 조회하는 기능
// List<UserDTO> 사용해서 정보를 저장

// UserDAO는 메모리에 사용자 정보를 저장하고 회원가입/로그인 시 조회
public class UserDAO {
	//ArrayList 객체 userList 생성
	private List<UserDTO> userList = new ArrayList<>();
	
	// 회원 가입 메소드
	public boolean signUp(UserDTO user) {
		// for-each문 for(자료형 변수명 : 배열or리스트)
		for(UserDTO u : userList) {
			// 아이디(리스트에 저장된)가 입력한 아이디와 같다면
			if(u.getUserId().equals(user.getUserId())) {
				// 리스트에 저장된 아이디와 지금 작성한 아이디가 같다
				return false;	// 중복된 아이디
			}
		}
		userList.add(user);
		return true;
	}
	
	// 로그인 메소드
	public boolean login(String userId, String userPw) {
		for(UserDTO u : userList) {
			if(u.getUserId().equals(userId) && u.getUserPw().equals(userPw)) {
				return true;
			}
		}
		return false;
	}
	
	// 비밀번호 찾기
	
	// 아이디로 사용자 검색 메소드
}
