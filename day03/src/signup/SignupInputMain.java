package signup;

import java.util.Scanner;

//4번 : User 클래스의 객체에 입력한 값으로 저장하기
public class SignupInputMain {
	public static void main(String[] args) {
		// 입력 => Scanner 클래스 사용
		Scanner sc = new Scanner(System.in);

		// 입력 받기
		System.out.print("이름 : ");
		String name = sc.nextLine();
//      System.out.println(name);

		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine(); // 버퍼 비워주기

		System.out.print("아이디 : ");
		String id = sc.nextLine();

		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();

		// User 클래스 객체 만들기
		// 클래스의 객체 만들기 => 클래스명 객체명 대입연산자 new 생성자;
		User user1 = new User(name, age, id, pw); // 매개변수 4개를 받는 생성자

		// 필드에 저장된 값 확인 => 객체명.필드명
//      System.out.println(user1.name);
//      System.out.println(user1.age);
//      System.out.println(user1.id);
//      System.out.println(user1.pw);

		// 객체 1개 생성
		// 객체명 user2
		// 입력받기
//      System.out.println("두번째 유저의 이름 : ");
//      String name1 = sc.nextLine();
//
//      System.out.println("두번째 유저의 나이 : ");
//      int age1 = sc.nextInt();
//
//      sc.nextLine(); // 버퍼 비우기
//
//      System.out.println("두번째 유저의 아이디 : ");
//      String id1 = sc.nextLine();
//
//      System.out.println("두번째 유저의 비밀번호 : ");
//      String pw1 = sc.nextLine();
//      User user2 = new User(name1, age1, id1, pw1);
//      //생성자에 값이나 변수를 저장할 때는 해당 클래스의 생성자 매개변수 순서, 타입대로 작성해야 한다
//            String name, int age, String id, String pw
//
//      System.out.println("가입된 회원 정보 : ");
//      System.out.println("두번째 유저의 이름 : " + user2.name);
//      System.out.println("두번째 유저의 나이 : " + user2.age);
//      System.out.println("두번째 유저의 아이디 : " + user2.id);
//      System.out.println("두번째 유저의 비밀번호 : " + user2.pw);
//   

		// toString()는 객체를 출력하면 자동으로 실행된다
		// 객체명 출력한것과 객체명.toString() 사용한것은 동일하게 출력된다
		System.out.println(user1.toString()); // 첫번째 유저, 객체의 주소값
		System.out.println(user1); // 두번째 유저, 객체의 주소값
	}
}
