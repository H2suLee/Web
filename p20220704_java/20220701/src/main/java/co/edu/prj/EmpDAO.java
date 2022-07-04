package co.edu.prj;

import java.util.ArrayList;

public class EmpDAO extends DAO {

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
				vo.setFirstName(rs.getString("first_name"));
				vo.setSalary(rs.getString("salary"));
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
	public EmpVO selectOne(String id) {
		EmpVO vo = new EmpVO();

		return vo;
	}

	// 등록
	public int insert(EmpVO vo) {
		int cnt = 0;
		return cnt;
	}

	// 수정
	public int update(EmpVO vo) {
		int cnt = 0;
		return cnt;
	}

	// 삭제
	public int delete(EmpVO vo) {
		int cnt = 0;
		return cnt;
	}
}
