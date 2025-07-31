package input;

import java.util.Scanner;

public class InputTest04 {
	public static void main(String[] args) {
		//입력클래스 import
		Scanner sc = new Scanner(System.in);
		
		//이름 입력 출력메시지
		System.out.println("이름 입력 : ");
		//문자열 변수 선언 및 초기화
		String name = sc.next();
		//입력받은 이름 출력
		System.out.println(name);
		
		//나이 입력 출력메시지
		System.out.println("나이 입력 : ");
		//정수형 변수 선언 및 초기화
		int age = sc.nextInt();
		System.out.println(age);
		
		//id와 pw 입력하는 출력메시지
		System.out.println("id와 pw를 한칸 띄어쓰기를 포함하여 입력하세요 : ");
		//문자열 변수 선언 및 초기화
		String id = sc.next();
		String pw = sc.next();
		System.out.println("id는 " + id + ", pw는 " + pw + "입니다");
		
		sc.nextLine(); //버퍼 비우기
		
		//좋아하는 동물을 입력 출력메시지
		System.out.println("좋아하는 동물을 입력하세요 : ");
		//문자열 변수 선언 및 초기화
		String animal = sc.nextLine();
		System.out.println(animal);
	}
}
