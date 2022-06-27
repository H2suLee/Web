package co.edu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DAO {

	// class => 복합적인 데이터를 하나의 변수에 넣을 수 있게 해준다
	// 사원번호, 이름, 이메일, 직무 => 각 필드에 담기
	public void insertEmp(Employee emp) {
		getConnect();
		String sql = "insert into employees (employee_id, last_name, email, job_id, hire_date) values (employees_seq.nextval, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getLastName());
			psmt.setString(2, emp.getEmail());
			psmt.setString(3, emp.getJobId());
			psmt.setString(4, emp.getHireDate());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public List<String> getNames() {
		getConnect();
		String sql = "select last_name from employees";
		List<String> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("last_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}
