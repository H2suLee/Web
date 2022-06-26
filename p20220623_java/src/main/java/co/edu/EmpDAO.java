// me version
package co.edu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// CRUD

public class EmpDAO extends DAO {

	// 조회
	public List<EmpVO> listEmp() {
		getConnect();
		List<EmpVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement("select * from employees");
			rs = psmt.executeQuery();

			// 다음 row가 없을 때까지 루핑
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmpId(rs.getInt("employee_id"));
				vo.setLastName(rs.getString("last_name"));
				vo.setJobId(rs.getString("job_id"));
				vo.setHireDate(rs.getString("hire_date"));
				vo.setEmail(rs.getString("email"));
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 이름만 조회
	public List<String> listNamesOnly() {
		getConnect();
		List<String> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement("select last_name from employees");
			rs = psmt.executeQuery();
			// 다음 row가 없을 때까지 루핑
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

	// 삽입
	public void insertEmp(EmpVO vo) {
		getConnect();
		String sql = "insert into employees (employee_id, last_name, job_id, hire_date, email) values (employees_seq.nextval, ?,?,?,?))";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getLastName());
			psmt.setString(2, vo.getJobId());
			psmt.setString(3, vo.getHireDate());
			psmt.setString(4, vo.getEmail());
			
			// 조회는 excuteQuery()(=>ResultSet), 수정, 삽입 및 삭제는 executeUpdate()(=>int),
			int cnt = psmt.executeUpdate();
			System.out.println(cnt + "건 입력");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

}