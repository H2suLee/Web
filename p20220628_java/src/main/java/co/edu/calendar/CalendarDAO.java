package co.edu.calendar;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.DAO;

public class CalendarDAO extends DAO {
	
	public List<CalendarVO> getSchedule(){
		// 전체 일정 정보를 가지고 오도록 메소드 완성
		getConnect();
		List<CalendarVO> list = new ArrayList<>();
		String sql = "select * from full_calendar";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CalendarVO vo = new CalendarVO();
				vo.setTitle(rs.getString("title"));
				vo.setStartDate(rs.getString("start_date"));
				vo.setEndDate(rs.getString("end_date"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return list;
	}

	
}
