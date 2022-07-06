package co.edu.prj.board;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.prj.comm.DAO;
import co.edu.prj.emp.EmpVO;

public class BoardDAO extends DAO {
	// 조회
	public ArrayList<BoardVO> selectBoard() {
		getConnect();
		ArrayList<BoardVO> list = new ArrayList<>();
		String sql = "select * from board order by id desc";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setId(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setContent(rs.getString(3));
				vo.setWriter(rs.getString(4));
				vo.setRdt(rs.getString(5));
				vo.setHit(rs.getInt(6));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 단건 조회

	public BoardVO selectOne(String id) {
		BoardVO vo = new BoardVO();
		try {
			// 1. 연결
			getConnect();
			// 2. sql 구문 준비
			String sql = "select * from board where id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setId(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setContent(rs.getString(3));
				vo.setWriter(rs.getString(4));
				vo.setRdt(rs.getString(5));
				vo.setHit(rs.getInt(6));
			}
		} catch (Exception e) {

		} finally {
			// 5. 연결 해제
			disconnect();
		}
		return vo;
	}

	// 등록
	public int insertBoard(BoardVO vo) {
		int cnt = 0;

		try {
			getConnect();
			String sql = "insert into board (id, title, content, writer, rdt, hit) values ((select max(id)+1 from board),?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriter());
			psmt.setString(4, vo.getRdt());
			psmt.setInt(5, vo.getHit());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return cnt;
	}

	// 삭제
	public int deleteBoard(String id) {
		int cnt = 0;
		getConnect();
		int parsedId = Integer.parseInt(id);
		String sql = "delete board where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, parsedId);
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return cnt;
	}

	// 수정
	public int updateBoard(BoardVO vo) {
		int cnt = 0;
		try {
			getConnect();
			String sql = "update board set title=?, content=? where id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setInt(3, vo.getId());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return cnt;
	}

}
