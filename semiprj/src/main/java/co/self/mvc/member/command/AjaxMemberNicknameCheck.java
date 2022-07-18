package co.self.mvc.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.self.mvc.comm.Command;
import co.self.mvc.member.service.MemberService;
import co.self.mvc.member.serviceImpl.MemberServiceImpl;

public class AjaxMemberNicknameCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberService dao = new MemberServiceImpl();
		String nickname = request.getParameter("nickname");
		if (dao.isMemberNickname(nickname)) {
			return "ajax:able";
		}
		return "ajax:unable";
	}
}
