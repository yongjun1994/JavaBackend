package user;

import java.util.ArrayList;
//ArrayList는 자바에서 제공하는 리스트형 자료구조 클래스
//여러 데이터를 순서대로 저장하고, 필요할 때 꺼내쓸 수 있다

//3번 : 회원 여러명 저장할 클래스
public class UsersMain {
   public static void main(String[] args) {

      ArrayList<User> users = new ArrayList<>();
      System.out.println(users); // []
      User user1 = new User("짱구", 5, "gu", "korea");
      User user2 = new User("철수", 5, "chul", "1234");
      users.add(user1);
      users.add(user2);
      System.out.println(users);
      System.out.println(user1);
      System.out.println(user1.name);
      System.out.println(user2.name);
      users.add(new User("유리", 5, "yuri", "abcd"));
//      users.add(new User("맹구", 5, "mang", "123"));
      System.out.println(users);
      
      //반복문을 이용하여 users에 있는 모든 회원의 이름과 아이디 출력(for-each문)
//      for(User u : users) {
//         System.out.println("이름 : " + u.name + ", 아이디 : " + u.id);
//      }

      //일반 for문을 활용하여 users에 있는 모든 회원의 이름과 나이 출력
      //ArrayList는 인덱스기반으로 접근할 수 있다
//      User u = users.get(0);
//      System.out.println(u);
//      System.out.println(u.name);
//      User u1 = users.get(1);
//      System.out.println(u1);
//      System.out.println(u1.name);
//      User u2 = users.get(2);
//      System.out.println(u2);
//      System.out.println(u2.name);
      
//      user.User@279f2327
//      짱구
//      user.User@2ff4acd0
//      철수
//      user.User@54bedef2
//      유리
      System.out.println(users.size());
      //반복문을 사용하는 이유 : 중복되는 코드를 줄일 수 있다
      //일반 for(초기식; 조건식; 증감식){ 반복해서 실행할 코드; }
      for(int i = 0; i < users.size(); i++) {
         User u = users.get(i);
         System.out.println(u);
         System.out.println(u.name);
      }
      
      
      
      
      // 기본자료형 : int, long, double, float, boolean, char
      // 래퍼클래스 : Integer, Long, Double, Float, Boolean, Character
//      ArrayList<Integer> number = new ArrayList<>();
//      number.add(10);
//      number.add(5);
//      System.out.println(number);
   }

}
