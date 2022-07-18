package co.self.mvc.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.self.mvc.comm.Command;
import co.self.mvc.member.service.MemberService;
import co.self.mvc.member.serviceImpl.MemberServiceImpl;

public class MemberJoinout implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(); 

		String id = request.getParameter("id");
		MemberService dao = new MemberServiceImpl();
		int cnt = dao.memberDelete(id);
		if(cnt>0) {
			request.setAttribute("message", "회원탈퇴 성공");
			session.invalidate();
		}else {
			request.setAttribute("message", "회원탈퇴 실패");
		}
		
	return "member/memberJoinout";	
	}

}
