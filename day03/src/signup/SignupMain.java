package signup;
//2번 : User클래스의 시작(User 클래스의 객체 만들기)
import java.util.Scanner;

public class SignupMain {
   public static void main(String[] args) {
      
     //자료형 변수명 대입연산자 값;
   // 클래스자료형 객체명 대입연산자 new 클래스명();
   //                       -------생성자   
      User user1 = new User("홍길동", 20, "korea", "k123");
      //매개변수가 있는 생성자를 사용하면 객체를 만들면서 값을 바로 초기화 해줄 수 있다
      
      System.out.println(user1); //기존 : signup.User@16진수해시코드
      //User클래스에 toString()메소드를 오버라이딩(재정의) 했기 때문에 해당 내용으로 출력
      
      System.out.println(user1.name); //user1객체에 저장된 name 필드의 값 출력
      System.out.println(user1.age); //user1객체에 저장된 age 필드의 값 출력
      System.out.println(user1.id);
      System.out.println(user1.pw);
      
      //user2 객체, 기본 생성자를 사용해서 만들었다
      User user2 = new User();
      System.out.println(user2.name); //user2.name 필드에 저장된 값이 없기 때문에 문자열의 기본값인 null 출력
      user2.name = "김영선"; //user2.name필드에 "김영선"이라는 값을 저장
      System.out.println(user2.name); //user2.name 필드에 저장된 "김영선"이라는 값 출력
      user2.age = 20;   //user2.age 필드에 저장된 20이라는 정수형 값 출력
      System.out.println(user2.age);
      
      System.out.println(user1); //signup.User@279f2327
      System.out.println(user2); //signup.User@2ff4acd0
      //signup.User@2ff4acd0
      //패키지명.클래스명@메모리주소값
   }
}