package userLogin;
//2번 로그인 성공, 아이디/비밀번호 틀렸을때 확인하기
// import 단축키 : Ctrl + Shift + O
import java.util.ArrayList;
import java.util.Scanner;

public class LoginFailMain {
	public static void main(String[] args) {
		// User 클래스의 객체를 만들고
		// ArrayList<User>에 회원 여러명 저장
		// ArrayList : 순서가 있는 리스트
		// 사용자로부터 아이디/비밀번호 입력받기
		// 로그인 성공/ 실패여부를 구분해서 메시지 출력
		
//		사용할 문법
		// Scanner 클래스 import
		// ArrayList<User>
		// .add() 추가메소드
		// .nextLine() 입력메소드
		// boolean 타입의 변수
		// for-each문 반복문
		// if~else문 조건문
		// .equals() 문자열 비교
		// 각 분기마다 출력 메소드를 사용
		
		Scanner sc = new Scanner(System.in);
		ArrayList<User> users = new ArrayList<>();
		
		User user1 = new User("짱구", 5, "gu", "korea");
		User user2 = new User("철수", 6, "chul", "abcd");
		users.add(user1);
		users.add(user2);
		users.add(new User("유리", 6, "yuri", "qwer"));
		
		// 사용자 입력
		System.out.print("아이디를 입력하세요 : ");
		String inputId = sc.nextLine();
		System.out.println("비밀번호를 입력하세요 : ");
		String inputPw = sc.nextLine();
		
		// 아이디가 틀린 경우 => 존재하지 않는 아이디입니다.
		// 아이디는 맞지만 비밀번호가 틀린경우 => 비밀번호가 틀렸습니다.
		// 로그인 성공한 경우 => 로그인 성공! 000님 환영합니다!
		
		boolean idFound = false;	// 아이디가 있는지 여부
		boolean pwFound = false;	// 비밀번호가 맞는지 여부
		String userName = "";	// 이름 저장용(로그인 성공시 출력)
		
		for(User u : users) {
//			System.out.println(u);
//			System.out.println(u.name);
			
			if(u.id.equals(inputId)) {
				idFound = true;	// 아이디가 존재한다.
				if(u.pw.equals(inputPw)) {
					pwFound = true;	// 아이디와 비밀번호가 같음
					userName = u.name; // u.name을 저장
				}
				break;	// 아이디를 찾았을 경우 반복문 종료
			}
		}
		
		// 조건별 결과 출력
		if(!idFound) {
			System.out.println("존재하지 않는 아이디입니다");
		} else if(!pwFound) {
			System.out.println("비밀번호가 틀렸습니다");
		} else {
			System.out.println("로그인 성공! " + userName + "님 환영합니다!");
		}
	}
}
