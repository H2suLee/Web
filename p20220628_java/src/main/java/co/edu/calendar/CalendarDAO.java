package co.edu.calendar;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.DAO;

public class CalendarDAO extends DAO {

	// 입력

	public boolean insertSchedule(CalendarVO vo) {

		// 정상적으로 한 건 입력이 되면 true를,
		// 예외가 발생하거나 입력이 안 되면 false를 리턴

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

	public boolean deleteSchedule(String delTitle) {

		// 정상적으로 한 건 입력이 되면 true를,
		// 예외가 발생하거나 입력이 안 되면 false를 리턴

		getConnect();
		String sql = "delete full_calendar where title=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, delTitle);

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

	public List<CalendarVO> getSchedule() {
		// 전체 일정 정보를 가지고 오도록 메소드 완성
		getConnect();
		List<CalendarVO> list = new ArrayList<>();
		String sql = "select * from full_calendar";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
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
