package co.home.hr.dept;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.home.hr.common.DAO;

public class DeptDAO extends DAO {

	// select
	public List<DeptVO> selectDept() {
		getConnect();
		List<DeptVO> list = new ArrayList<>();
		String sql = "select * from departments order by department_id";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				DeptVO vo = new DeptVO();
				vo.setDepartmentId(rs.getString(1));
				vo.setDepartmentName(rs.getString(2));
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
	public DeptVO selectOne(String id) {
		getConnect();
		DeptVO vo = new DeptVO();
		String sql = "select * from departments where department_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setDepartmentId(rs.getString(1));
				vo.setDepartmentName(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	// insert
	public int insertDept(DeptVO vo) {
		int cnt = 0;
		getConnect();
		String sql = "insert into departments (department_id, department_name) values(?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getDepartmentId());
			psmt.setString(2, vo.getDepartmentName());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return cnt;
	}

	// update
	public int updateDept(DeptVO vo) {
		int cnt = 0;
		getConnect();
		String sql = "update departments set department_name=? where department_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getDepartmentName());
			psmt.setString(2, vo.getDepartmentId());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return cnt;
	}
	// delete
	public int deleteDept(String id) {
		int cnt = 0;
		getConnect();
		String sql = "delete departments where department_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return cnt;
	}

}
