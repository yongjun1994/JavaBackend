package userLogin;

public class User {
	// 필드
	String name;
	int age;
	String id;
	String pw;

	// 생성자
	// 기본생성자
	public User() {
		super();
	}

	// 매개변수가 4개인 생성자
	public User(String name, int age, String id, String pw) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
		this.pw = pw;
	}
	
	// 메소드
	// 회원 정보 출력 메소드
	void printInfo() {
		System.out.println("====[회원정보]====");
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("아이디 : " + id);
		System.out.println("=================");
	}
}
