package inputTest;
//3번 : 입력 메소드 연습

import java.util.Scanner;

public class InputTest {
	public static void main(String[] args) {
		// 사용자로부터 입력받아서 값 출력하기
		// 입력받을 땐 반드시 Scanner 클래스가 있어야한다
		Scanner sc = new Scanner(System.in);
		// 자동 import => ctrl + shift + o

		// 입력메소드 : next(), nextLine(), nextInt(), nextDouble()

		System.out.println("이름 입력 : ");
		String name = sc.nextLine(); // 문자열로 입력받은 값을 문자열 name 변수에 저장
		System.out.println("입력한 이름은 " + name + "입니다.");

		System.out.println("나이 입력 : ");
		int age = sc.nextInt(); // 정수형으로 입력받은 값을 정수형 age 변수에 저장
		System.out.println("나이는 " + age + "입니다.");

		sc.nextLine(); // 버퍼비우기(엔터 소모하기)
		// 입력 메소드 중에서 sc.next(), sc.nextInt(), sc.nextDouble()를 사용하면
		// sc.nextLine()을 쓰기 전에 반드시 한 번 더 sc.nextLine() 작성해야 한다

		System.out.println("아이디 입력 : ");
		String id = sc.nextLine(); // 문자열로 입력받은 값을 문자열 id변수에 저장
		System.out.println("아이디는 " + id + "입니다.");

		System.out.println("비밀번호 입력 : ");
		String pw = sc.nextLine(); // 문자열로 입력받은 값을 문자열 pw변수에 저장
		System.out.println("비밀번호는 " + pw + "입니다.");
	}
}
