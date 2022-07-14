package co.lhs.semiprj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.lhs.semiprj.comm.Command;

public class MemberLogout implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그아웃
		// 로그아웃은 세션 invalidate를 통해 이루어짐
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name"); // 세션 객체에 담아둔 name값을 가져온다.
		request.setAttribute("message", name+"님 정상적으로 로그아웃 되었습니다.");
		session.invalidate();
		return "member/memberLogout";
	}

}
