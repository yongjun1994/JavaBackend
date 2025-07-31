package signup;

public class Child extends User {

	// User 클래스의 필드, 생성자, 메소드
	int num;

	public Child(String name, int age, String id, String pw, int num) {
		super(name, age, id, pw);
		this.num = num;
	}

	@Override
	public String toString() {
		return "Child [num=" + num + ", name=" + name + ", age=" + age + ", id=" + id + ", pw=" + pw + "]";
	}

}