// me verson

package co.edu.member;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 조회, 삽입, 갱신, 삭제 

public class MemberDAO extends DAO {

	public List<MemberVO> listData() {
		getConnect();
		List<MemberVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement("select * from member order by memb_no");
			rs = psmt.executeQuery();
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setMembNo(rs.getInt("memb_no"));
				vo.setMembName(rs.getString("memb_name"));
				vo.setMembPhone(rs.getString("memb_phone"));
				vo.setMembAddr(rs.getString("memb_addr"));
				vo.setMembBirth(rs.getString("memb_birth"));
				vo.setMembImage(rs.getString("memb_image"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	public MemberVO insertData(MemberVO vo) {
		getConnect();
		String sql = "insert into member (memb_no, memb_name, memb_phone, memb_addr, memb_birth, memb_image) values(?,?,?,?,?,?)";

		// sql의 첫번째 물음표에는 member_seq.nextval 이용할 것,
		// 지금 시점 member_seq.nextval 확인하고, 시퀀스 정보를 rs에 담아 리턴해서 psmt에 set할 것
		String seq = "select memb_seq.nextval from dual";
		int nextSeq = 0;
		try {
			psmt = conn.prepareStatement(seq);
			rs = psmt.executeQuery();
			if (rs.next()) {
				// .getInt()에는 컬럼명을 넣어도 되지만 컬럼번호를 넣어도 됨!
				nextSeq = rs.getInt(1);
			}
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, nextSeq);
			psmt.setString(2, vo.getMembName());
			psmt.setString(3, vo.getMembPhone());
			psmt.setString(4, vo.getMembAddr());
			psmt.setString(5, vo.getMembBirth());
			psmt.setString(6, vo.getMembImage());

			vo.setMembNo(nextSeq);

			int cnt = psmt.executeUpdate();
			System.out.println(cnt + "건 입력");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	public boolean updateData(MemberVO vo) {
		getConnect();
		String sql = "update member set memb_name=?,memb_phone=?,memb_addr=?,memb_birth=?,memb_image=? where memb_no=?";
		// 물음표에 들어가야할 파라미터가 다 안들어오면 null이 대입됨
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMembName());
			psmt.setString(2, vo.getMembPhone());
			psmt.setString(3, vo.getMembAddr());
			psmt.setString(4, vo.getMembBirth());
			psmt.setString(5, vo.getMembImage());
			psmt.setInt(6, vo.getMembNo());

			int cnt = psmt.executeUpdate();
			if (cnt > 0) {
				System.out.println(cnt + "건 수정");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public boolean deleteData(int memb_no) {
		getConnect();
		String sql = "delete member where memb_no=?";
		// 물음표에 들어가야할 파라미터가 다 안들어오면 null이 대입됨
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, memb_no);

			int cnt = psmt.executeUpdate();
			if (cnt > 0) {
				System.out.println(cnt + "건 삭제");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

}