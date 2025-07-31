package signup;

import java.util.ArrayList;
import java.util.Scanner;

//5번 : 여러명의 사용자 입력받아 저장(리스트, 반복문-for문 사용)
public class MultiUserSignup {
   public static void main(String[] args) {

      // 입력클래스 import
      // 입력메소드
      Scanner sc = new Scanner(System.in); // Scanner sc : 사용자로부터 문자열/숫자를 입력받을 수 있는 도구
      ArrayList<User> users = new ArrayList<>();
      // ArrayList<User> users : 여러명의 User 객체(회원)를 저장할 리스트

      System.out.println("3명이 회원가입을 진행합니다!");

      // 반복문 for(초기식; 조건식; 증감식){}
      // for문으로 3명 입력받기
      for (int i = 0; i < 2; i++) {
         // i++ => i = i + 1;
         System.out.println("\n[" + (i + 1) + "번째 회원]"); // 몇번째 회원정보를 입력하는지 확인하기위한 출력메소드
         System.out.println("이름입력 : ");
         String name = sc.nextLine();
         System.out.println("나이입력 : ");
         int age = sc.nextInt();
         sc.nextLine(); // 버퍼비우기
         System.out.println("아이디 입력 : ");
         String id = sc.nextLine();
         System.out.println("비밀번호 입력 : ");
         String pw = sc.nextLine();

         User user1 = new User(name, age, id, pw); 
         //user1 객체의 필드 이름, 나이, 아이디, 비밀번호 입력받은 값으로 저장
         users.add(user1); //입력받은 이름,나이,아이디,비밀번호로 객체 생성한 user1을 리스트에 추가
//         users.add(new User(name, age, id, pw));
      }
      System.out.println(users.size());  //users 리스트의 길이
      
//      users.add(new User("유리", 5, "ri", "pw"));
//      System.out.println(users.size());  //users 리스트의 길이
      
      
      System.out.println("\n가입된 회원 목록 확인");
      for (int i = 0; i < users.size(); i++) {
         // users.size() : 리스트의 총길이만큼을 저장하고 있는 메소드 => 3개
         User user = users.get(i); // .get(i) i번째 User 객체 가져오기
         System.out.println("▶" + user.name + ", " + user.age);
         System.out.println(user);
         System.out.println(user.toString());
         user.printInfo();
      }
      
      

//      int i = 0;
//      System.out.println(i);
//      i++; //i = 0 + 1;
//      System.out.println(i);
//      i++;
//      System.out.println(i);

   }
}