package co.self.mvc.member.service;

import java.util.List;

import co.self.mvc.member.vo.MemberVO;

public interface MemberService {
	// 추상메서드
	List<MemberVO> memberSelect(); // R
	MemberVO memberSelectOne(); // R
	
	int memberInsert(MemberVO vo); // C
	int memberUpdate(MemberVO vo); // U
	int memberDelete(MemberVO vo); // D
	
	// R, 아이디 중복체크, default 리턴 값이 false인 것이 관례
	// 아이디가 존재하지 않으면 true, 등록 가능
	// 아이디가 존재하면 false, 등록 불가
	boolean isMemberId(String id); 

	// R, vo의 아이디와 패스워드를 조회하여 일치하면 그 vo를 리턴
	MemberVO memberLogin(MemberVO vo); 
}
