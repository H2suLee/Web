package co.edu.member;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO extends DAO {

	// 전체 조회(매개값 필요 x)
	public List<MemberVO> memberList() {
		getConnect();
		List<MemberVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement("select * from member order by memb_no");
			// 조회: executeQuery(), 추가수정삭제: executeUpdate()
			rs = psmt.executeQuery(); // 쿼리문을 실행한 결과를 rs에 담음
			while (rs.next()) {
				MemberVO mem = new MemberVO();
				// next()는 데이터가 있을 때 true 리턴
				// 데이터가 없을 때까지 while문 looping 함
				mem.setMembNo(rs.getInt("memb_no"));
				mem.setMembName(rs.getString("memb_name"));
				mem.setMembPhone(rs.getString("memb_phone"));
				mem.setMembAddr(rs.getString("memb_addr"));
				mem.setMembBirth(rs.getString("memb_birth"));
				mem.setMembImage(rs.getString("memb_image"));
				list.add(mem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 입력(매개값: MemberVO)
	public MemberVO insertMember(MemberVO vo) {
		getConnect();
		String sql = "insert into member (memb_no, memb_name, memb_phone, memb_addr, memb_birth, memb_image) values(?,?,?,?,?,?)";

		// 지금 시점 memb_seq.nextval 확인하려면
		String seqSql = "select memb_seq.nextval from dual";

		try {
			// 시퀀스 정보 가져와서 rs에 담아서 리턴
			int nextSeq = 0;
			psmt = conn.prepareStatement(seqSql);
			rs = psmt.executeQuery(); // 한 번 실행할 때 한 건의 결과를 반납할 것임.. 그리고 그걸 rs에 담음
			if (rs.next()) {
				nextSeq = rs.getInt(1); // 1이 첫번째 값
			}
			// 입력 처리
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, nextSeq); // 첫번째 물음표에 숫자 리턴 받은 값
			psmt.setString(2, vo.getMembName()); // 두번째 물음표에 vo.getMembName()
			psmt.setString(3, vo.getMembPhone());
			psmt.setString(4, vo.getMembAddr());
			psmt.setString(5, vo.getMembBirth());
			psmt.setString(6, vo.getMembImage());

			vo.setMembNo(nextSeq);

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	// 수정(매개값: MemberVO)
	public boolean updateMember(MemberVO vo) {
		getConnect();
		String sql = "update member set memb_name =?, memb_phone=?, memb_addr =?, memb_birth = ?, memb_image =? where memb_no = ?";
		// 물음표에 들어가야할 파라미터가 다 안들어오면 null이 대입됨
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMembName());
			psmt.setString(2, vo.getMembPhone());
			psmt.setString(3, vo.getMembAddr());
			psmt.setString(4, vo.getMembBirth());
			psmt.setString(5, vo.getMembImage());
			psmt.setInt(6, vo.getMembNo());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정");
			if (r > 0) {
				return true; // 정상적으로 변경됨
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return false; // 변경 실패
	}

	// 삭제(매개값: memb_no)
	public boolean deleteMember(int membNo) {
		getConnect();
		String sql = "delete member where memb_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, membNo);

			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");

			if (r > 0) {
				return true; // 삭제 성공
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return false; // 삭제 실패
	}

	// 조건 조회(조건: memb_no)
	public MemberVO searchMember(int membNo) {

		getConnect();
		MemberVO mem = null;
		// MemberVO mem = new MemberVO();로 하면.. 조회결과가 아무것도 없을 때 null을 반환하지 않고 오류를 반환한다		
		try {
			psmt = conn.prepareStatement("select * from member where memb_no = ?");
			// 조회: executeQuery(), 추가수정삭제: executeUpdate()
			psmt.setInt(1, membNo);
			rs = psmt.executeQuery(); // 쿼리문을 실행한 결과를 rs에 담음
			if (rs.next()) {
				mem = new MemberVO();
				mem.setMembNo(rs.getInt("memb_no"));
				mem.setMembName(rs.getString("memb_name"));
				mem.setMembPhone(rs.getString("memb_phone"));
				mem.setMembAddr(rs.getString("memb_addr"));
				mem.setMembBirth(rs.getString("memb_birth"));
				mem.setMembImage(rs.getString("memb_image"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return mem;
	}

}
