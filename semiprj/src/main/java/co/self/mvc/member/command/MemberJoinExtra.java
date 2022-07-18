package co.self.mvc.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.self.mvc.comm.Command;
import co.self.mvc.member.service.MemberService;
import co.self.mvc.member.serviceImpl.MemberServiceImpl;
import co.self.mvc.member.vo.MemberVO;

public class MemberJoinExtra implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = dao.memberSelectOne(id);
		request.setAttribute("vo", vo);
		if(vo.getMemberNickname() != null) {
			return "ajax:ok";
		}
		return "ajax:not ok";
	}

}
