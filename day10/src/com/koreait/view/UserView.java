package com.koreait.view;

import java.util.Scanner;

//사용자와 직접 상호작용하는 역할(View)
//콘솔로 메뉴 출력, 사용자 입력, 결과 메시지 출력
public class UserView {
   private Scanner sc = new Scanner(System.in);

   //메뉴를 콘솔에 출력하는 메소드
   //Main에서 호출하여 사용자한테 선택지를 보여줌
   public void showMenu() {
      System.out.println("\n=======사용자 시스템======");
      System.out.println("1. 회원가입");
      System.out.println("2. 로그인");
      System.out.println("3. 종료");
      System.out.println("선택 : ");
   }

   //사용자로부터 아이디 입력받음(회원가입/로그인시 사용)
   public String inputUserId() {
      System.out.println("아이디를 입력하세요 : ");
      System.out.flush(); // 콘솔 버퍼 출력이 지연(flush)되지않을 때 사용
      String id = sc.nextLine();
      return id;
   }

   //사용자로부터 비밀번호 입력받음(회원가입/로그인시 사용)
   public String inputUserPw() {
      System.out.println("패스워드를 입력하세요 : ");
      System.out.flush();
      return sc.nextLine();
   }
   
   public String inputUserName() {
      System.out.println("이름을 입력하세요 : ");
      return sc.nextLine();
   }
   
   public int inputUserAge() {
      System.out.println("나이를 입력하세요 : ");
      return sc.nextInt();
   }


   //처리 결과를 콘솔에 출력하는 메소드
   //Controller에서 받은 결과를 사용자에게 보여주는 용도
   public void showResult(String msg) {
      System.out.println(msg);
   }
   
   //사용자가 값을 입력하는 메소드(메뉴에서 숫자 입력)
   public int menuChoice() {
      int choice = -1;
      
      try {
         choice = sc.nextInt();
         sc.nextLine(); // 버퍼비우기
      } catch (Exception e) {
         System.out.println("1, 2, 3 중 하나만 입력가능합니다");
      }
      return choice;
   }
}
















