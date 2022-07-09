package co.home.hr.emp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.home.hr.common.DAO;

public class EmpDAO extends DAO {
	// selectJob
	public List<JobVO> selectJob() {
		getConnect();
		List<JobVO> list = new ArrayList<>();
		String sql = "select * from jobs order by job_id";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				JobVO vo = new JobVO();
				vo.setJobId(rs.getString("job_id"));
				vo.setJobTitle(rs.getString("job_title"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;

	}

	// select
	public List<EmpVO> selectEmp() {
		getConnect();
		List<EmpVO> list = new ArrayList<>();
		String sql = "select * from employees order by employee_id";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmployeeId(rs.getString("employee_id"));
				vo.setLastName(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setHireDate(rs.getString("hire_date"));
				vo.setJobId(rs.getString("job_id"));
				vo.setDepartmentId(rs.getString("department_id"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// selectOne
	public EmpVO selectOne(String id) {
		getConnect();
		EmpVO vo = new EmpVO();
		String sql = "select * from employees where employee_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setEmployeeId(rs.getString("employee_id"));
				vo.setLastName(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setHireDate(rs.getString("hire_date"));
				vo.setJobId(rs.getString("job_id"));
				vo.setDepartmentId(rs.getString("department_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	// insert
	public int insertEmp(EmpVO vo) {
		int cnt = 0;
		getConnect();
		String sql = "insert into employees (employee_id, last_name, email, hire_date, job_id) values(?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getEmployeeId());
			psmt.setString(2, vo.getLastName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getHireDate());
			psmt.setString(5, vo.getJobId());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return cnt;
	}

	// update
	public int updateEmp(EmpVO vo) {
		int cnt = 0;
		getConnect();
		String sql = "update employees set last_name=?, email=?, hire_date=?, job_id=?, department_id=? where employee_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getLastName());
			psmt.setString(2, vo.getEmail());
			psmt.setString(3, vo.getHireDate());
			psmt.setString(4, vo.getJobId());
			psmt.setString(5, vo.getDepartmentId());
			psmt.setString(6, vo.getEmployeeId());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return cnt;
	}

	// delete
	public int deleteEmp(String id) {
		int cnt = 0;
		getConnect();
		String sql = "delete employees where employee_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return cnt;
	}

}
