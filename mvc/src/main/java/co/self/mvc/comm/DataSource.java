package co.self.mvc.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// DAO 역할을 하는 클래스 (DB 연결), 싱글톤
public class DataSource {
	// 필드
	private static DataSource dataSource = new DataSource();
	private Connection conn;
	
	// 생성자
	private DataSource() {
		
	}
	
	// 메소드
	public static DataSource getInstance() {
		return dataSource;
	}
	
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			System.out.println("DB 연결 성공");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
		return conn;
	}
}
