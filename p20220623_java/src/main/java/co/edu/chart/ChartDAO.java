package co.edu.chart;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import co.edu.DAO;

public class ChartDAO extends DAO {
	public Map<String, Integer> getDeptCnt() {
		getConnect();
		Map<String, Integer> map = new HashMap<>();
		String sql = "select department_name, count(*) from employees e, departments d where e.department_id = d.department_id group by department_name";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				map.put(rs.getString(1), rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return map;
	}
}
