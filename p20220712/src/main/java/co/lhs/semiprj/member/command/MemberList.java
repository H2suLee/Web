package co.lhs.semiprj.member.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.lhs.semiprj.comm.Command;
import co.lhs.semiprj.member.service.MemberService;
import co.lhs.semiprj.member.serviceImp.MemberServiceImpl;
import co.lhs.semiprj.member.vo.MemberVO;

public class MemberList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 멤버 리스트 보기
		MemberService memberDAO = new MemberServiceImpl();
		List<MemberVO> list = new ArrayList<>();
		list = memberDAO.memberSelectList();
		request.setAttribute("list", list);
		return "member/memberList";
	}

}
