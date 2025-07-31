package com.koreait.controller;

import com.koreait.model.UserDAO;
import com.koreait.model.UserDTO;

//비즈니스 로직 처리
//view에서 전달받은 입력을 DAO에 넘기고 결과를 판단

//Model과 View 사이에서 중간다리 역할
//프로그램의 흐름을 제어함
//사용자의 요청을 처리하는 컨트롤러   (사용자의 요청 -> 컨트롤러가 판단하고 처리방향을 정함 -> 결과 반환)
public class UserController {

   UserDAO userDAO = new UserDAO();
   // 데이터 저장/조회 역할을 하는 UserDAO 생성
   // 이 DAO를 통해 Model 계층과 연결

   // 회원가입
   public boolean signUp(String name, int age, String userId, String userPw) {
      UserDTO userDTO = new UserDTO(name, age, userId, userPw);
      return userDAO.signUp(userDTO);
   }
   // 1) view에서 전달받은 회원가입 정보(이름, 나이, 아이디, 비밀번호)를 인자로 받음
   // 2) 전달받은 데이터를 UserDTO로 포장 (객체로 데이터 전달하기 위함함)
   // 3) UserDAO의 signUp() 메소드 호출(실제 데이터 저장 처리)
   // 4) 결과(true 또는 false)를 view에 반환
//   
//   [UserView] <- 사용자가 입력
//      |
//   [UserController.signUp(name, age, userId, userPw)]
//      |
//   [UserDAO.signUp(UserDTO)]
//      |
//   userList에 저장(아이디 중복여부 체크)
//      |
//    결과 반환(true, false)

   // 로그인
   public boolean login(String userId, String userPw) {
      return userDAO.login(userId, userPw);
   }
   // 1) View에서 입력받은 로그인정보(아이디, 비밀번호)를 전달받음
   // 2) userDAO.login() 호출하여 로그인 여부를 판단
   // 3) 결과(true : 성공, false : 실패)를 반환

}
