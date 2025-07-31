package signup;

import java.util.Scanner;

// day04 - 로그인 기능 확인
public class LoginTest {
	public static void main(String[] args) {
		
		// 회원 1명의 정보 저장
		String userName = "짱구";
		int userAge = 5;
		String userId = "gu";
		String userPw = "korea";
		
		// 로그인
		// 사용자로부터 아이디와 비밀번호를 입력받기
		Scanner sc = new Scanner(System.in);
		
		System.out.println("아이디를 입력하세요 : ");
		String inputId = sc.nextLine();
		
		System.out.println("비밀번호를 입력하세요 : ");
		String inputPw = sc.nextLine();
		
		// 관계 연산자 : a == b 같니? 맞으면 true, 틀리면 false
		System.out.println(1 == 1);
		// 문자열 비교 비교대상문자열.equals(비교할문자열);
		System.out.println(userId.equals(inputId));
		System.out.println(userPw.equals(inputPw));
	}

}
