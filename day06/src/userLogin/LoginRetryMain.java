package userLogin;

import java.util.ArrayList;
import java.util.Scanner;

// 3번 로그인 시도 제한(3번)
public class LoginRetryMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<User> users = new ArrayList<>();
		// users라는 리스트에 4명의 회원을 저장
		users.add(new User("민수", 25, "minsu25", "pass123"));
		users.add(new User("지은", 22, "jieun22", "qwer!"));
		users.add(new User("태현", 29, "taehyun", "abcd1234"));
		users.add(new User("영선", 20, "sun12", "korea"));
		
//		System.out.println(users);
		
		boolean isLogin = false;
		
		// 3번 로그인 시도
		for(int i = 1; i <= 3; i++) {
			System.out.println("\n[" + i + "번째 로그인 시도]");
			
			System.out.print("아이디입력 : ");
			String inputId = sc.nextLine();
			System.out.print("비밀번호 입력 : ");
			String inputPw = sc.nextLine();
			
			for(User u : users) {
				if(u.id.equals(inputId) && u.pw.equals(inputPw)) {
					System.out.println("로그인 성공!" + u.name + "님 환영합니다!");
					isLogin = true;
					break;
				}
			}
			
			if(isLogin) {
				break;
			}else {
				System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
			}
			
		}
		if(!isLogin) {
			System.out.println("\n3회 이상 실패하여 로그인이 종료됩니다!");
		}

	}

}
