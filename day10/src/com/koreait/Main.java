package com.koreait;

import java.util.Scanner;

import com.koreait.controller.UserController;
import com.koreait.view.UserView;

//프로그램의 시작점(main 메소드)
//MVC2 구조에서 모든 구성 요소를 연결해서 실행
public class Main {
   public static void main(String[] args) {
      UserController controller = new UserController();
      UserView view = new UserView();
      
      boolean running = true;
      while(running) {
         view.showMenu();
         int choice = view.menuChoice();
         
         switch(choice) {
         case 1:
            String id = view.inputUserId();
            String pw = view.inputUserPw();
            String name = view.inputUserName();
            int age = view.inputUserAge();
            boolean result = controller.signUp(name, age, id, pw);
            view.showResult(result ? "회원가입 성공!" : "이미 존재하는 아이디입니다!");
            break;
         case 2:
            String loginId = view.inputUserId();
            String loginPw = view.inputUserPw();
            boolean loginResult = controller.login(loginId, loginPw);
            view.showResult(loginResult? "로그인 성공!" : "로그인 실패!");
            break;
         case 3:
            running = false;
            view.showResult("프로그램을 종료합니다");
            break;
         default:
            view.showResult("올바른 번호를 선택하세요!");
            return;	// 해당 반복 탈출(while문, 메소드 종료시)
         }

      }
      
   }
}





















