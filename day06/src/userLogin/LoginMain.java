package userLogin;

import java.util.ArrayList;
import java.util.Scanner;

//4번 : 로그인 검증 메소드
public class LoginMain {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      LoginMain l = new LoginMain();
      
      //회원 목록 생성
      ArrayList<User> users = new ArrayList<>();
      users.add(new User("짱구", 5, "gu", "korea"));
      users.add(new User("철수", 10, "chul", "asdf"));
      users.add(new User("유리", 6, "yuri", "qwer123"));
      users.add(new User("맹구", 6, "mang", "qwer!!"));
      users.add(new User("훈이", 5, "hu", "pass1"));
      
      //로그인 시도 횟수
      int maxAttempt = 5;
      boolean loginSuccess = false;
      
      for(int i = 1; i <= maxAttempt; i++) {
         System.out.println("\n[" + i + "번째 시도]");
         
         System.out.println("아이디 입력 : ");
         String inputId = sc.nextLine();
         System.out.println("비밀번호 입력 : ");
         String inputPw = sc.nextLine();
         
         // 매개변수 o, 리턴값 o => syso(객체명.메소드명(인수1, 인수2, 인수3));
         //               자료형 변수명 = 객체명.메소드명(인수1, 인수2, 인수3);
         int result = l.checkLogin(users, inputId, inputPw);
//         System.out.println(result);
         
         if (result == 1) {
            loginSuccess = true;
            break;
         }else if(result == 0) {
            System.out.println("비밀번호가 틀렸습니다");
         }else {
            System.out.println("존재하지 않는 아이디입니다");
         }
         
         
      }
      
      if(!loginSuccess) {
         System.out.println("\n5회이상 실패하여 로그인 종료합니다");
      }
      
      
      
   }
   
   //로그인 검증 메소드
   // 메소드는 main 메소드 밖에 만듬
   // 매개변수 o, 리턴값 o 메소드 정의
   //리턴값 : 1(성공), 0(비밀번호 틀림), -1(아이디없음)
   int checkLogin(ArrayList<User> users, String inputId, String inputPw) {
      for(User u : users) {
         if(u.id.equals(inputId)) {
            if(u.pw.equals(inputPw)) {
               System.out.println("로그인 성공! " + u.name + "님 환영합니다!");
               return 1;
            }else {
               return 0;
            }
         }
      }
      return -1;
   }
}
