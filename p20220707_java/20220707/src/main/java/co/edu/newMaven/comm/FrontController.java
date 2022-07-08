package co.edu.newMaven.comm;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.newMaven.MainCommand;
import co.edu.newMaven.member.command.AjaxMemberIdCheck;
import co.edu.newMaven.member.command.MemberJoin;
import co.edu.newMaven.member.command.MemberJoinForm;
import co.edu.newMaven.member.command.MemberList;
import co.edu.newMaven.member.command.MemberLogin;
import co.edu.newMaven.member.command.MemberLoginForm;
import co.edu.newMaven.member.command.MemberLogout;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do") // 모든 .do 요청은 이 서블릿이 처리함 (확장자 패턴)
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	
	public void init(ServletConfig config) throws ServletException {
		// 초기화하는 메소드 (mapping하는 부분을 작성한다)
		// 키 값은 jsp 파일 이름이랑 똑같이 준다
		map.put("/main.do", new MainCommand()); // 처음 접속하는 페이지
		map.put("/memberLoginForm.do", new MemberLoginForm()); // 로그인 페이지
		map.put("/memberLogin.do", new MemberLogin()); // 로그인 페이지
		map.put("/memberLogout.do", new MemberLogout()); // 로그아웃 페이지
		map.put("/memberList.do", new MemberList()); // 멤버 조회 페이지
		map.put("/memberJoinForm.do", new MemberJoinForm()); // 회원 가입 페이지
		map.put("/ajaxMemberIdCheck.do", new AjaxMemberIdCheck()); // ajax를 이용한 아이디 중복체크
		map.put("/memberJoin.do", new MemberJoin()); 

	}
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 한글 처리
		req.setCharacterEncoding("utf-8");
		
		// 요청된 URI 확인
		String uri = req.getRequestURI();
			System.out.println("uri: " + uri); // /20220707/main.do
		// 요청 URI로부터 contextPath를 확인
		String contextPath = req.getContextPath();
			//System.out.println("contextPath: " + contextPath); // /20220707
		// 요청받은 서블릿 페이지 찾기
		String page = uri.substring(contextPath.length()); 
			System.out.println("page:" +page); // /main.do
		// 실제 수행할 Command를 찾음. 
		Command command = map.get(page); // map.get(page) 가 구현 객체가 됨 = new MainCommand();
		
		// 구현한 결과를 String으로 받음 
		String viewPage = command.exec(req, resp);
			System.out.println("viewPage: " + viewPage); // main/main
		
		// viewResolve
		// viewPage가 .do로 끝나지 않고 null도 아니면 실행 블록 안의 내용 실행
		if(!viewPage.endsWith(".do") && !viewPage.equals(null)) {
			if(viewPage.startsWith("ajax:")) {
				resp.setContentType("text/html; charset=UTF-8");
				resp.getWriter().append(viewPage.substring(5));
				return;
			}
			// 시스템에서 접근 가능한 폴더를 더해주고, 
			viewPage = "WEB-INF/view/" + viewPage + ".jsp";
			System.out.println("viewResolved viewPage: " + viewPage);
			// 원하는 페이지를 호출해서 전달함
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, resp);
		}else {
			// .do로 권한 위임 처리
			resp.sendRedirect(viewPage); //viewPage = memberList.do
		}
	}

}
