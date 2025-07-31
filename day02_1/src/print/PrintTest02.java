package print;

public class PrintTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//printf() : 서식에 맞는 값을 콘솔에 출력하고 줄바꿈이 되지 않는다
		//자료형(Data Type)					서식문자
		//정수형 byte, short, int, long		%d
		//실수형 double, float				%f
		//논리형 boolean						%s
		//문자형 char		' '로 감싸진 1개 문자	%c
		//문자열 String	""로 감싸진 0개 이상의 문자	%s
		
		System.out.printf("%d %f %s %s %c", -10, 3.14, true, "hello", 'a');
		System.out.printf("%d", 2025);
		System.out.println("안녕하세요. 저는 김영선입니다. 제 나이는 " + 20 + "살입니다.");
		System.out.printf("안녕하세요. 저는 김영선입니다. 제 나이는 %d살입니다.\n", 20);
		System.out.print("오늘은 2일차 수업입니다.\n");
		
		//이름, 나이, 취미 출력하기(println, print, printf)
		System.out.println("이름 : 김영선, 나이 : 20살, 취미 : 여행");
		System.out.print("이름 : 김영선, 나이 : 20살, 취미 : 여행\n");
		System.out.printf("이름 : %s, 나이 : %d살, 취미 : %s", "김영선", 20, "여행");
	
	}

}
