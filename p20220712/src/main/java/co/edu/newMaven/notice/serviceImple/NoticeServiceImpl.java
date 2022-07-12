package co.edu.newMaven.notice.serviceImple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.newMaven.comm.DataSource;
import co.edu.newMaven.notice.service.NoticeService;
import co.edu.newMaven.notice.vo.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	private DataSource dao = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<NoticeVO> noticeSelectList() {
		List<NoticeVO> list = new ArrayList<>();
		NoticeVO vo;
		String sql = "SELECT * FROM NOTICE";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new NoticeVO();
				vo.setNoticeId(rs.getInt(1));
				vo.setNoticeWriter(rs.getString(2));
				vo.setNoticeTitle(rs.getString(3));
				// vo.setNoticeContent(rs.getString(4));
				vo.setNoticeDate(rs.getDate(5));
				vo.setNoticeHit(rs.getInt(6));
				vo.setNoticeAttach(rs.getString(7));
				// vo.setNoticeAttachLoc(rs.getString(8));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public NoticeVO noticeSelectOne(NoticeVO vo) {
		String sql = "SELECT * FROM NOTICE WHERE NOTICE_ID=?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getNoticeId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setNoticeId(rs.getInt(1));
				vo.setNoticeWriter(rs.getString(2));
				vo.setNoticeTitle(rs.getString(3));
				vo.setNoticeContent(rs.getString(4));
				vo.setNoticeDate(rs.getDate(5));
				vo.setNoticeHit(rs.getInt(6));
				vo.setNoticeAttach(rs.getString(7));
				// vo.setNoticeAttachLoc(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		int cnt = 0;
		String sql = "INSERT INTO NOTICE VALUES(notice_seq.nextval,?,?,?,?,?,?,?)";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getNoticeWriter());
			psmt.setString(2, vo.getNoticeTitle());
			psmt.setString(3, vo.getNoticeContent());
			psmt.setDate(4, vo.getNoticeDate());
			psmt.setInt(5, 0); // 조회수 초기값 0
			psmt.setString(6, vo.getNoticeAttach());
			psmt.setString(7, vo.getNoticeAttachLoc());
			cnt = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		int cnt = 0;
		String sql = "UPDATE NOTICE SET NOTICE_WRITER=?, NOTICE_CONTENT=?, NOTICE_ATTACH=?, NOTICE_ATTACH_LOC=? WHERE NOTICE_ID=?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getNoticeWriter());
			psmt.setString(2, vo.getNoticeContent());
			psmt.setString(3, vo.getNoticeAttach());
			psmt.setString(4, vo.getNoticeAttachLoc());
			psmt.setInt(5, vo.getNoticeId());
			cnt = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	@Override
	public int deleteUpdate(NoticeVO vo) {
		int cnt = 0;
		String sql = "DELETE NOTICE WHERE NOTICE_ID=?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getNoticeId());
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	@Override
	public List<NoticeVO> noticeSearchList(String key, String val) {
		// 검색
		List<NoticeVO> list = new ArrayList<>();
		NoticeVO vo;
		String sql = "SELECT * FROM NOTICE WHERE ? LIKE '%?%'";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, key);
			psmt.setString(2, val);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new NoticeVO();
				vo.setNoticeId(rs.getInt(1));
				vo.setNoticeWriter(rs.getString(2));
				vo.setNoticeTitle(rs.getString(3));
				vo.setNoticeContent(rs.getString(4));
				vo.setNoticeDate(rs.getDate(5));
				vo.setNoticeHit(rs.getInt(6));
				vo.setNoticeAttach(rs.getString(7));
				vo.setNoticeAttachLoc(rs.getString(8));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 연 순서대로 닫기
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
