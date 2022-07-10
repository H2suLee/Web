package co.self.mvc.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.self.mvc.comm.Command;

public class MemberJoinForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		return "member/memberJoinForm";
	}

}
