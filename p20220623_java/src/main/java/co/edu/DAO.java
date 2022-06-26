// me version
package co.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

	// 필드
	Connection conn; // 오라클과 connect, disconnect하는 역할
	PreparedStatement psmt; // 쿼리문을 담는 역할
	ResultSet rs; // 쿼리 실행 결과를 담는 역할

	// 메소드-1
	// DB와 연결
	public void getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// getConnection(오라클 url, 사용자 계정, 사용자 비밀번호);
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	// 메소드-2
	// DB와 연결 끊고 psmt, rs 객체 사용 중지
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