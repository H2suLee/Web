package co.lhs.semiprj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.lhs.semiprj.comm.Command;
import co.lhs.semiprj.member.service.MemberService;
import co.lhs.semiprj.member.serviceImp.MemberServiceImpl;

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
