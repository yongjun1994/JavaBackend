package input;

import java.util.Scanner;

public class InputTest03 {
	public static void main(String[] args) {
//		System.out.print("이름을 입력하세요 : ");
//		sc.nextLine();
//		System.out.println(sc.nextLine());
		
		//변수
		//자료형 변수명 = 값;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();
		System.out.println(name + "님 환영합니다!");
		System.out.println("두번째 이름 입력 : ");
		String name1 = sc.nextLine();
		System.out.println(name1 + "님 환영합니다!");
		
		System.out.println("name 변수의 값 변경 : ");
		name = sc.nextLine();
		System.out.println(name + "님 재방문하셨군요!");
		
		System.out.println(name);
		//변수의 특징 : 하나의 자료형으로, 하나의 값만 저장할 수 있는 저장공간
		
	}
}
