package co.self.mvc.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.self.mvc.comm.Command;
import co.self.mvc.member.service.MemberService;
import co.self.mvc.member.serviceImpl.MemberServiceImpl;
import co.self.mvc.member.vo.MemberVO;

public class KakaoLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 처리
		// 서버가 만들어 놓은 세션을 가져온다
		// 한번 가져온 로그인 정보를 세션에 담아주어 페이지 바뀔 때마다 로그인 할 필요 없도록
		HttpSession session = request.getSession();
		MemberService memberDAO = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		System.out.println("id:: " + request.getParameter("id"));
		System.out.println("pw:: " + request.getParameter("pw"));
		vo.setMemberId(request.getParameter("id"));
		vo.setMemberPw(request.getParameter("pw"));
		vo = memberDAO.memberLogin(vo);
		
		System.out.println(vo.getMemberId() + "::" + vo.getMemberPw() + "::" + vo.getMemberName() + "::" + vo.getMemberAuth());
		
	
		if (vo.getMemberName() != null) {
			// 세션 객체에 담음, 세션은 전역적으로 쓰임
			session.setAttribute("id", vo.getMemberId());
			session.setAttribute("auth", vo.getMemberAuth());
			session.setAttribute("name", vo.getMemberName());

			// 넘겨줄 페이지에 담음
			request.setAttribute("message", "Welcome to this page, " + vo.getMemberName() + " !");
			return "ajax:ok";
		} else {
			request.setAttribute("message", "아이디 또는  패스워드가 일치하지 않습니다.");
			return "ajax:not ok";
		}
	}
}
