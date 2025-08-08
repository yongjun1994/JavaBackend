package com.koreait.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.koreait.userDAO.DBConnector;

public class Main {
	public static void main(String[] args) {
		Connection connection = null;

		try {

			connection = DBConnector.getConnection();
			if (connection != null) {
				System.out.println("오라클 db 연결 성공!");
			} else {
				System.out.println("오라클 db 연결 실패!");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
