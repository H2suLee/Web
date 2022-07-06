package co.edu.prj.emp;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.prj.comm.DAO;

public class EmpDAO extends DAO {

	// Jobs 전체 조회
	public ArrayList<JobsVO> selectJobsAll() {
		ArrayList<JobsVO> list = new ArrayList<>();

		try {
			// 1. 연결
			getConnect();
			// 2. sql 구문 준비
			String sql = "select * from jobs order by job_id";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				JobsVO vo = new JobsVO();
				vo.setJobId(rs.getString("job_id"));
				vo.setJobTitle(rs.getString("job_title"));
				list.add(vo);
			}
		} catch (Exception e) {

		} finally {
			// 5. 연결 해제
			disconnect();
		}
		return list;
	}

	// 전체 조회
	public ArrayList<EmpVO> selectAll() {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try {
			// 1. 연결
			getConnect();
			// 2. sql 구문 준비
			String sql = "select * from employees order by employee_id";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmployeeId(rs.getString("employee_id"));
				vo.setLastName(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setHireDate(rs.getString("hire_date"));
				vo.setJobId(rs.getString("job_id"));
				list.add(vo);
			}

		} catch (Exception e) {

		} finally {
			// 5. 연결 해제
			disconnect();
		}
		return list;
	}

	// 단건 조회 - 1
	// 전체 조회에 if문 추가
	public ArrayList<EmpVO> selectConditionallyAll(String departmentId) {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try {
			// 1. 연결
			getConnect();
			// 2. sql 구문 준비
			String sql = "select * from employees ";
			if (departmentId != null && !departmentId.isEmpty()) {
				sql += "where department_id = ? ";
			} else {
				sql += "order by employee_id ";
			}
			psmt = conn.prepareStatement(sql);

			if (departmentId != null && !departmentId.isEmpty()) {
				psmt.setString(1, departmentId);
			}

			rs = psmt.executeQuery();
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmployeeId(rs.getString("employee_id"));
				vo.setLastName(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setHireDate(rs.getString("hire_date"));
				vo.setJobId(rs.getString("job_id"));
				list.add(vo);
			}

		} catch (Exception e) {

		} finally {
			// 5. 연결 해제
			disconnect();
		}
		return list;
	}

	// 단건 조회 - 2, 아예 메소드 따로 빼기
	// 단건 조회
	public EmpVO selectOne(String id) {
		EmpVO vo = new EmpVO();
		try {
			// 1. 연결
			getConnect();
			// 2. sql 구문 준비
			String sql = "select * from employees where employee_id=?";
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
		} catch (Exception e) {

		} finally {
			// 5. 연결 해제
			disconnect();
		}
		return vo;
	}

	// 등록
	public int insert(EmpVO vo) {
		int cnt = 0;

		try {
			getConnect();
			// 방법 1 수기 입력
			// String sql = "insert into employees (employee_id, last_name, email, hire_date, job_id) values (?,?,?,?,?)";
			// 방법 2 시퀀스나 서브쿼리 이용
			String sql = "insert into employees (employee_id, last_name, email, hire_date, job_id) values ((select max(employee_id)+1 from employees),?,?,?,?)";

			// 방법 1
			/*
			 * psmt = conn.prepareStatement(sql); 
			 * psmt.setString(1, vo.getEmployeeId());
			 * psmt.setString(2, vo.getLastName()); psmt.setString(3, vo.getEmail());
			 * psmt.setString(4, vo.getHireDate()); psmt.setString(5, vo.getJobId());
			 */
			// 방법2
			psmt = conn.prepareStatement(sql); 
			 
			psmt.setString(1, vo.getLastName());
			psmt.setString(2, vo.getEmail());
			psmt.setString(3, vo.getHireDate());
			psmt.setString(4, vo.getJobId());

			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return cnt;
	}

	// 수정
	public int update(EmpVO vo) {
		int cnt = 0;
		try {
			getConnect();
			String sql = "update employees set last_name=?, email=?, hire_date=?, job_id=?, department_id=? where employee_id=?";
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

	// 삭제
	public int delete(String id) {
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
