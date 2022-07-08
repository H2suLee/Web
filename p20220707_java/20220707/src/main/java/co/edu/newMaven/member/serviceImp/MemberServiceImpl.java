package co.edu.newMaven.member.serviceImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.newMaven.comm.DataSource;
import co.edu.newMaven.member.service.MemberService;
import co.edu.newMaven.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private DataSource dao = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<MemberVO> memberSelectList() {
		List<MemberVO> list = new ArrayList<>();
		MemberVO vo;
		String sql = "SELECT * FROM MEMBER";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("member_id"));
				// vo.setMemberPW(rs.getString("member_pw"));
				// pw를 가지고 오는 것은 무의미.. 리스트에서 굳이 봐야할 일도 없고 어차피 암호화 되어서 넘어오기 때문에 안 보임
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberAuth(rs.getString("member_auth"));
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
	public MemberVO memberSelectOne(MemberVO vo) {
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID=?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setMemberId(rs.getString("member_id"));
				// vo.setMemberPW(rs.getString("member_pw"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberAuth(rs.getString("member_auth"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		int cnt = 0;
		String sql = "INSERT INTO MEMBER VALUES(?,?,?,?)";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPW());
			psmt.setString(3, vo.getMemberName());
			psmt.setString(4, vo.getMemberAuth());

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		int cnt = 0;
		String sql = "UPDATE MEMBER SET MEMBER_PW=?, MEMBER_AUTH=? WHERE MEMBER_ID=?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberPW());
			psmt.setString(2, vo.getMemberAuth());
			psmt.setString(3, vo.getMemberId());

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		int cnt = 0;
		String sql = "DELETE MEMBER WHERE MEMBER_ID=?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	@Override
	public boolean isMemberIdCheck(String id) {
		String sql = "SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_ID=?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return true;
				// 참이면 등록 가능
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false; 
		// 거짓이면 등록 불가능
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID=? AND MEMBER_PW=?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPW());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setMemberId(rs.getString("member_id"));
				vo.setMemberPW(rs.getString("member_pw"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberAuth(rs.getString("member_auth"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
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
