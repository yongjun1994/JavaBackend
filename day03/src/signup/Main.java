package signup;

public class Main {
	public static void main(String[] args) {
		User user1 = new User("짱구", 5);
		System.out.println(user1);
		System.out.println(user1.name);

		Child user2 = new Child("철수", 5, "k", "k1", 1);
		System.out.println(user2);

	}

}
