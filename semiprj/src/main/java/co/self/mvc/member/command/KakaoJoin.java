package co.self.mvc.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.self.mvc.comm.Command;
import co.self.mvc.member.service.MemberService;
import co.self.mvc.member.serviceImpl.MemberServiceImpl;
import co.self.mvc.member.vo.MemberVO;

public class KakaoJoin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPw(request.getParameter("memberPw"));
		vo.setMemberNickname(request.getParameter("memberNickname"));
		vo.setMemberEmail(request.getParameter("memberEmail"));
		vo.setMemberAuth("user");
		vo.setMemberImg(request.getParameter("memberImg"));
		vo.setMemberGit(request.getParameter("memberGit"));

		int n = dao.memberInsert(vo);

		if (n != 0) {
			request.setAttribute("message", "회원가입이 정상적으로 처리되었습니다.");
			return "ajax:ok";
		} else {
			request.setAttribute("message", "회원가입 실패!");
			return "ajax:not ok";
		}

	}

}
