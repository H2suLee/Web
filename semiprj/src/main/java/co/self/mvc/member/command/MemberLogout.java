package co.self.mvc.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.self.mvc.comm.Command;

public class MemberLogout implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 세션에 있는 로그인 정보를 삭제하면 로그아웃이 됨
		HttpSession session = request.getSession();
		String nickname = (String) session.getAttribute("nickname");
		request.setAttribute("message", nickname + "님, 정상적으로 로그아웃 되었습니다.");
		session.invalidate();
		return "member/memberLogout";
	}

}
