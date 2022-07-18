package co.self.mvc.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.self.mvc.comm.DataSource;
import co.self.mvc.member.service.MemberService;
import co.self.mvc.member.vo.MemberVO;

// MemberDAO 역할
public class MemberServiceImpl implements MemberService {

	private DataSource dao = DataSource.getInstance();

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<MemberVO> memberSelect() {
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
				vo.setMemberPw(rs.getString("member_pw"));
				// vo.setMemberName(rs.getString("member_name"));
				vo.setMemberAuth(rs.getString("member_auth"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public MemberVO memberSelectOne(String id) {
		MemberVO vo = null;
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID=?";

		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			if (rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("member_id"));
				vo.setMemberPw(rs.getString("member_pw"));
				vo.setMemberNickname(rs.getString("member_nickname"));
				vo.setMemberEmail(rs.getString("member_email"));
				vo.setMemberImg(rs.getString("member_img"));
				vo.setMemberAuth(rs.getString("member_auth"));
				vo.setMemberGit(rs.getString("member_git"));
				vo.setMemberNo(rs.getInt("member_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		int cnt = 0;
		String sql = "insert into member values (?,?,?,?,?,?,?, (select max(member_no)+1 from member))";

		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPw());
			psmt.setString(3, vo.getMemberNickname());
			psmt.setString(4, vo.getMemberEmail());
			psmt.setString(5, vo.getMemberImg());
			psmt.setString(6, vo.getMemberAuth());
			psmt.setString(7, vo.getMemberGit());

			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		int cnt = 0;
		String sql = "update member set member_img=?, member_nickname=?, member_email=?, member_git=?  where member_id=?";
		conn = dao.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberImg());
			psmt.setString(2, vo.getMemberNickname());
			psmt.setString(3, vo.getMemberEmail());
			psmt.setString(4, vo.getMemberGit());
			psmt.setString(5, vo.getMemberId());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	@Override
	public int memberDelete(String id) {
		int cnt = 0;
		String sql = "delete member where member_id=?";
		conn = dao.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	@Override
	public boolean isMemberId(String id) {
		String sql = "SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_ID=?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (!rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	@Override
	public boolean isMemberNickname(String nickname) {
		String sql = "SELECT MEMBER_NICKNAME FROM MEMBER WHERE MEMBER_NICKNAME=?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, nickname);
			rs = psmt.executeQuery();
			if (!rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID=? AND MEMBER_PW=?";

		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPw());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("member_id"));
				vo.setMemberPw(rs.getString("member_pw"));
				vo.setMemberNickname(rs.getString("member_nickname"));
				vo.setMemberEmail(rs.getString("member_email"));
				vo.setMemberImg(rs.getString("member_img"));
				vo.setMemberAuth(rs.getString("member_auth"));
				vo.setMemberGit(rs.getString("member_git"));
				vo.setMemberNo(rs.getInt("member_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

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
