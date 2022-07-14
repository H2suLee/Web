package co.lhs.semiprj.member.service;

import java.util.List;

import co.lhs.semiprj.member.vo.MemberVO;

public interface MemberService {
	// R 멤버 전체 조회
	List<MemberVO> memberSelectList(); 
	
	// R 멤버 단건 조회
	MemberVO memberSelectOne(MemberVO vo);
	
	// C 삽입
	int memberInsert(MemberVO vo);
	
	// U 갱신
	int memberUpdate(MemberVO vo);
	
	// D 삭제
	int memberDelete(MemberVO vo);
	
	// R 아이디 중복 체크
	boolean isMemberIdCheck(String id); // 존재하면 false // boolean 메소드는 디폴트 리턴 값이 false인 것이 관례
	
	// R 로그인 체크
	MemberVO memberLogin(MemberVO vo);
}
