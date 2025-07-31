package userLogin;

import java.util.ArrayList;
import java.util.Scanner;

//5번 : 회원가입, 로그인 시도, 아이디 중복검사, 로그인 검증 메소드(기능 분리)
public class LoginMain02 {

	Scanner sc = new Scanner(System.in);

	// 메인메소드(엔트리포인트, 시작점)
	public static void main(String[] args) {
		LoginMain02 l = new LoginMain02();
		
		// 1. 회원가입 메소드 호출(매개변수x, 리턴값o)
		ArrayList<User> users = l.signup();

		// 2. 로그인 시도 메소드 호출(매개변수o, 리턴값x)
		l.loginAttempt(users);
	}

	// 회원가입 메소드
	ArrayList<User> signup() {
		ArrayList<User> users = new ArrayList<>();

		System.out.println("[회원가입 시작]");
		System.out.println("몇 명을 가입하시겠습니까? ");
		int count = sc.nextInt(); // 정수형 입력메소드
		sc.nextLine(); // 버퍼 비우기

		for (int i = 1; i <= count; i++) {
			System.out.println("\n[" + i + "번째 회원가입]");
			System.out.println("이름 입력 : ");
			String name = sc.nextLine();
			System.out.println("나이 입력 : ");
			int age = sc.nextInt();
			sc.nextLine(); // 버퍼 비우기

			// 아이디입력(중복검사 포함)
			String id;
			while (true) {
				System.out.println("아이디 입력 : ");
				id = sc.nextLine();
				// 중복검사 메소드 호출
				if (idDuplicate(users, id)) {
					System.out.println("이미 존재하는 아이디 입니다. 다시 입력해주세요.");
				} else {
					System.out.println("가입 가능한 아이디입니다.");
					break;
				}
			}

			System.out.println("비밀번호 입력 : ");
			String pw = sc.nextLine();

			users.add(new User(name, age, id, pw));
			System.out.println(name + "님 가입 완료!!!");

		}
		System.out.println("\n총 " + users.size() + "명 회원가입 완료했습니다\n");
		return users;
	}

	// 아이디 중복 검사 메소드
	boolean idDuplicate(ArrayList<User> users, String id) {
		for (User u : users) {
			if (u.id.equals(id)) {
				return true;
			}
		}
		return false;
	}

	// 로그인 시도 메소드
	void loginAttempt(ArrayList<User> users) {
		int maxAttempt = 3;
		boolean loginSuccess = false;

		for (int i = 1; i <= maxAttempt; i++) {
			System.out.println("[" + i + "번째 로그인 시도]");

			System.out.println("아이디 입력 : ");
			String inputId = sc.nextLine();
			System.out.println("비밀번호 입력 : ");
			String inputPw = sc.nextLine();

			// 로그인 검증 메소드 호출
			int result = checkLogin(users, inputId, inputPw);

			if (result == 1) {
				loginSuccess = true;
				break;
			} else if (result == 0) {
				System.out.println("비밀번호가 틀렸습니다");
			} else {
				System.out.println("존재하지 않는 아이디 입니다");
			}
		}

		if (!loginSuccess) {
			System.out.println(maxAttempt + "이상 로그인 실패! 프로그램 종료됩니다.");
		}
	}

	// 로그인 검증 메소드
	// 리턴값 : 1(성공), 0(비밀번호 틀림), -1(아이디 없음)
	int checkLogin(ArrayList<User> users, String inputId, String inputPw) {
		for (User u : users) {
			if (u.id.equals(inputId)) {
				if (u.pw.equals(inputPw)) {
					System.out.println("로그인 성공!!");
					// 성공 시 사용자 정보 출력하는 메소드 호출
					u.printInfo();
					return 1;
				} else {
					return 0;
				}
			}
		}
		return -1;
	}

}
