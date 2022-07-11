package co.edu.newMaven.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.newMaven.comm.Command;
import co.edu.newMaven.member.service.MemberService;
import co.edu.newMaven.member.serviceImp.MemberServiceImpl;
import co.edu.newMaven.member.vo.MemberVO;

public class MemberJoin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 처리
		MemberService memberDAO = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPW(request.getParameter("memberPW"));
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberAuth("USER");
		int cnt = memberDAO.memberInsert(vo);
		if(cnt!=0) {
			request.setAttribute("message", "회원가입이 성공적으로 처리되었습니다.");
		} else {
			request.setAttribute("message", "회원가입 실패!");
		}
		return "member/memberJoin";
		
		// 회원목록은 관리자만 볼 수 있게 set해 놔야
		// return "memberList.do"; // http://localhost/20220707/memberList.do
		// return "member/memberList"; // 왜 일케하면 // http://localhost/20220707/memberJoin.do
	}

}
