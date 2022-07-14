package co.lhs.semiprj.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 싱글톤으로 
public class DataSource {
	
	// 필드
	private static DataSource dataSource = new DataSource(); // 인스턴스 생성
	private Connection conn;
	
	// 생성자
	private DataSource() {
	} 

	public static DataSource getInstance() {
		return dataSource;
	}
	
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "micol", "1234");
			System.out.println("성공");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("실패");
			
		}
		return conn;
	}

}
