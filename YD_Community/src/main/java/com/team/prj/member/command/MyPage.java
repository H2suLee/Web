package com.team.prj.member.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.prj.board.vo.BoardVO;
import com.team.prj.common.Command;
import com.team.prj.member.service.MemberServiceImpl;
import com.team.prj.member.vo.MemberVO;
import com.team.prj.page.serviceImpl.PageServiceImpl;

public class MyPage implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		PageServiceImpl pageService = new PageServiceImpl();
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member"); //세션 가져오기
		
		int memberNo = member.getMemberNo();
		int boardWriter = Integer.parseInt(request.getParameter("no"));
		String memberNick = new MemberServiceImpl().searchMemberNick(boardWriter);
		
		List<BoardVO> list = pageService.myLogList(boardWriter);
		
		
		request.setAttribute("list", list);
		request.setAttribute("memberNo", memberNo);
		request.setAttribute("boardWriter", boardWriter);
		request.setAttribute("memberNick", memberNick);
		// my Page 출력
		return "member/myPage";
	}

}
