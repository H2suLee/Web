package co.self.mvc.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.self.mvc.comm.Command;
import co.self.mvc.member.serviceImpl.MemberServiceImpl;
import co.self.mvc.member.vo.MemberVO;

public class MemberUpdateSubmit implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String img = request.getParameter("img");
		String id = request.getParameter("id");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String git = request.getParameter("git");
		
		MemberVO vo = new MemberVO();
		vo.setMemberImg(img);
		vo.setMemberId(id);
		vo.setMemberNickname(nickname);
		vo.setMemberEmail(email);
		vo.setMemberGit(git);
		
		
		int cnt = new MemberServiceImpl().memberUpdate(vo);
		
		return "main.do";
	}

}
