package input;

import java.util.Scanner;

public class InputTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//입력메소드를 사용하기 위해서는 반드시 한줄이 필요하다
		Scanner sc = new Scanner(System.in);
		//자동 import ctrl + shift + o
		
//		sc.next();
		//주석 단축키 ctrl + /
//		System.out.println(sc.next());
//		System.out.println(sc.next());
		
		System.out.println("이름입력 : ");
		System.out.println(sc.nextLine());
		System.out.println("아이디 입력 : ");
		System.out.println(sc.nextLine());
		System.out.println("비밀번호 입력 : ");
		System.out.println(sc.nextLine());

	}

}
