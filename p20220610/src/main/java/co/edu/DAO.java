package co.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DAO: data access object
public class DAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	public void getConnect() {
		// 인스턴스를 만드는 대신
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 오라클 url 정보, 사용자 계정, 계정 비밀번호
			// https://.. 로 시작하는 웹페이지 url 주소와 다르다
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			// 커넥션 개체를 만드려고 이 염병을

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public void disconnect() {
		if (conn != null) { // conn이 사용되어졌으면, conn 에 인스턴스가 최소 하나 할당이 됐으면
			try {
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			} // null 일 경우에 close 해버리면 nullpointer 예외 뜸
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
