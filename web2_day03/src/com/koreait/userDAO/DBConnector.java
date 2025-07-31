package com.koreait.userDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	public static Connection getConnection() {
		// getConnection() static 메소드를 만든다

		Connection connection = null;
		// 연결에 필요한 정보
		String userName = "web";
		String password = "1234";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// URL 정해져 있는 것, JDBC로 연결할 때 구글링하면 나온다
		// URL 주소 / 어디로 전달할래? URL을 정확하게 작성해야한다!

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 이친구가 문제없으면 메모리에 올라간다, 관리할 수 있게 된것을 의미함
			// 커넥션 객체가 드라이버로 오게된다
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("연결성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결 정보 오류");
			e.printStackTrace();
		}

		return connection;

	}
}
