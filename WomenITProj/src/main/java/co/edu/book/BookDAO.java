package co.edu.book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO extends DAO {
	public List<BookVO> listData() {
		getConnect();
		List<BookVO> list = new ArrayList<>();
		String sql = "select * from book"; 
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BookVO vo = new BookVO();
				vo.setNo(rs.getString("book_code"));
				vo.setName(rs.getString("book_name"));
				vo.setWriter(rs.getString("book_auth"));
				vo.setPublisher(rs.getString("book_pres"));
				vo.setPrice(rs.getInt("book_amt"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	public BookVO insertData(BookVO vo) {
		getConnect();
		String sql = "insert into book values(?,?,?,?,?)";

		// sql의 첫번째 물음표에는 member_seq.nextval 이용할 것,
		// 지금 시점 member_seq.nextval 확인하고, 시퀀스 정보를 rs에 담아 리턴해서 psmt에 set할 것
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getNo());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getWriter());
			psmt.setString(4, vo.getPublisher());
			psmt.setInt(5, vo.getPrice());

			int cnt = psmt.executeUpdate();
			System.out.println(cnt + "건 입력");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	public boolean deleteData(String bookCode) {
		getConnect();
		String sql = "delete book where book_code=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookCode);

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
