package co.edu.calendar;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.member.DAO;

public class CalendarDAO extends DAO {
	public boolean deleteCalendar(CalendarVO vo) {
		getConnect();
		String sql = "delete full_calendar where title=? and start_date=? and end_date=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getStartDate());
			psmt.setString(3, vo.getEndDate());
			int cnt = psmt.executeUpdate();
			if (cnt > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public boolean insertCalendar(CalendarVO vo) {
		getConnect();
		String sql = "insert into full_calendar values(?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getStartDate());
			psmt.setString(3, vo.getEndDate());

			int cnt = psmt.executeUpdate();
			if (cnt > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public List<CalendarVO> showCalendar() {
		getConnect();
		String sql = "select * from full_calendar";
		List<CalendarVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				CalendarVO vo = new CalendarVO();
				vo.setTitle(rs.getString(1));
				vo.setStartDate(rs.getString(2));
				vo.setEndDate(rs.getString(3));
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
