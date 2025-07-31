package input;

public class VariableTest01 {
	public static void main(String[] args) {
		//변수
		int age;	// 정수형 저장공간의 이름을 age로 선언
		age = 20;	// age 변수에 20이라는 정수형 값을 대입(저장)
		System.out.println(age); //age에 저장된 값을 콘솔에 출력
		
		String name;	//문자열 저장공간의 이름을 name으로 선언
		name = "홍길동";  //name 변수에 "홍길동"이라는 문자열 값을 대입(저장)
		System.out.println(name); //name에 저장된 문자열 값을 콘솔에 출력
		
		String id = "korea"; //문자열 저장공간의 이름을 id로 선언, korea 문자열로 초기화
		int pw = 1234;
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(name + "님 환영합니다!" + name 
				+ "님의 id는 " + id + ", pw는 " + pw +"입니다");
		System.out.printf("%s님 환영합니다! %s님의 id는 %s이고, pw는 %d입니다.", name, name, id, pw);
	}
}
