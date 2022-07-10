// me version
package co.edu.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DAO: data access object
public class DAO {
	public Connection conn;
	public PreparedStatement psmt;
	public ResultSet rs;

	public void getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public void disconnect() {
		if (conn != null) {
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