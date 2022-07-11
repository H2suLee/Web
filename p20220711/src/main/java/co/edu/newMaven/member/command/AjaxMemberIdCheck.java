package co.edu.newMaven.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.newMaven.comm.Command;
import co.edu.newMaven.member.service.MemberService;
import co.edu.newMaven.member.serviceImp.MemberServiceImpl;

public class AjaxMemberIdCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// ajax를 이용한 아이디 중복 체크
		MemberService memberDAO = new MemberServiceImpl();
		String id = request.getParameter("id");
		if(memberDAO.isMemberIdCheck(id)) {
			return "ajax:used";
		}
		return "ajax:un-used";
	}

}
