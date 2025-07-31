package user;

import java.util.ArrayList;
import java.util.Scanner;

// 4번 : 로그인 기능 구현
public class LoginMain {
	public static void main(String[] args) {
		
		// 회원 목록에 회원 4명을 저장
		// 사용자로부터 아이디와 비밀번호를 입력받기		
		// for-each문을 사용해서 리스트에서 로그인 확인
		// 조건문 문자열 비교(.equals())
		// 결과 출력
		
		ArrayList<User> users = new ArrayList<>();
		// import 자동완성 : ctrl + shift + o
		
		// 회원 3명 목록
		// add : ArrayList 안에있는 추가 메소드
		users.add(new User("짱구", 5, "gu", "korea")); 
		System.out.println(users);
		users.add(new User("철수", 6, "chul", "1234"));
		System.out.println(users);
		users.add(new User("유리", 7, "yuri", "abcd"));
		System.out.println(users);
		
		// [user.User@2f92e0f4, user.User@28a418fc, user.User@5305068a]
		System.out.println(users);
		users.add(new User("홍길동", 20, "hgd", "korea"));
		System.out.println(users);
//		System.out.println(users.get(3).name);	// users.get(index) => 주소값
												// 주소값.필드명
//		
//		for(User u : users) {
//			System.out.println(u.name);
//		}
		
		Scanner sc = new Scanner(System.in);
		// 사용자 입력받기(아이디와 비밀번호)
		System.out.println("아이디 입력 : ");
		String inputId = sc.nextLine();	// 문자열로 입력받는 메소드
		System.out.println("비밀번호 입력 : ");
		String inputPw = sc.nextLine(); // 문자열로 입력받는 메소드
		
		System.out.println("입력한 아이디는 " + inputId + "이고 비밀번호는 " + inputPw + "입니다.");
		
		// 로그인 검사
		boolean isLogin = false;
		
		// for-each문
		for(User u : users) {
//			System.out.println(u.id);
//			System.out.println(u.pw);
//			System.out.println("아이디 : " + u.id.equals(inputPw));
//			System.out.println("비밀번호 : " + u.pw.equals(inputPw));
			// 문자열 비교는 .equals()메소드를 사용해야한다.
			
			System.out.println(u.id.equals(inputPw) && u.id.equals(inputPw));
			// a 도 참이고 b도 참이면 참이다.
			// a가 참이고 b가 거짓이면 거짓이다
			// true && true => true
			// true && false => false
			// false && true => false
			// false && false => false
			
			// a가 참이고 b가 참이면 참이다.
			// a가 참이고 b가 거짓이면 참이다.
			// true || true => true
			// true || false => false
			// false || true => true
			// false || false => false
			
			// 참의 반대는 거짓이다.
			// 거짓의 반대는 참이다.
			// !true => false
			// !false => true
			
			// 조건문 : if문 switch문
			if(u.id.equals(inputPw) && u.id.equals(inputPw)) {
				System.out.println(u.name + "님 환영합니다!");
				isLogin = true; 
				break; // 기타제어문 break문을 만나면 무조건 반복문을 탈출한다.
				// 로그인 성공했으면 더이상 다른 것을 확인할 필요가 없음
			}
		}
		
//		System.out.println(!isLogin);
		// 로그인 실패를 출력할 조건문
		if(!isLogin) {
			System.out.println("로그인 실패! 아이디나 비밀번호를 확인해주세요!");
		}
		
	}
}
