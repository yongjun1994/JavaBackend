package user;
// 1번 : 사용자의 정보를 담을 수 있는 User 클래스
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
	
	public User(String name, int age, String id, String pw) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
		this.pw = pw;
	}
	
	
}
