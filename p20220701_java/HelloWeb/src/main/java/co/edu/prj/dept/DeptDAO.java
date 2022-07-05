package co.edu.prj.dept;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.prj.comm.DAO;
import co.edu.prj.emp.EmpVO;

public class DeptDAO extends DAO {
	// department_id 전체 조회
	public ArrayList<DeptVO> selectDeptAll() {
		ArrayList<DeptVO> list = new ArrayList<>();

		try {
			// 1. 연결
			getConnect();
			// 2. sql 구문 준비
			String sql = "select * from departments order by 1";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				DeptVO vo = new DeptVO();
				vo.setDeptId(rs.getString(1));
				vo.setDeptName(rs.getString(2));
				list.add(vo);
			}
		} catch (Exception e) {

		} finally {
			// 5. 연결 해제
			disconnect();
		}
		return list;
	}

	// 단건 조회
	public DeptVO selectOne(String deptId) {
		DeptVO vo = new DeptVO();
		try {
			// 1. 연결
			getConnect();
			// 2. sql 구문 준비
			String sql = "select * from departments where department_id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, deptId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setDeptId(rs.getString("department_id"));
				vo.setDeptName(rs.getString("department_name"));
			}
		} catch (Exception e) {

		} finally {
			// 5. 연결 해제
			disconnect();
		}
		return vo;
	}

	// 등록
	public int insert(DeptVO vo) {
		int cnt = 0;

		try {
			getConnect();
			String sql = "insert into departments (department_id, department_name) values(?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getDeptId());
			psmt.setString(2, vo.getDeptName());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return cnt;
	}

	// 수정
	public int update(DeptVO vo) {
		int cnt = 0;
		return cnt;
	}

	// 삭제
	public int delete(DeptVO vo) {
		int cnt = 0;
		return cnt;
	}

}
