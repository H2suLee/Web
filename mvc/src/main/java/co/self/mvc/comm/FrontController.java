package co.self.mvc.comm;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.self.mvc.MainCommand;
import co.self.mvc.member.command.AjaxMemberIdCheck;
import co.self.mvc.member.command.MemberJoin;
import co.self.mvc.member.command.MemberJoinForm;
import co.self.mvc.member.command.MemberLogin;
import co.self.mvc.member.command.MemberLoginForm;
import co.self.mvc.member.command.MemberLogout;
import co.self.mvc.member.command.MemberSelect;

@WebServlet("*.do") 
// .do로 들어오는 모든 요청을 처리
// init, service 메소드만 존재

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<>();
	// key가 요청
	// value 가 요청을 실행할 Command 객체
	// 요청과 Command 객체 1:1 매핑
	
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand());
		map.put("/memberSelect.do", new MemberSelect());
		map.put("/memberLogin.do", new MemberLogin());
		map.put("/memberLoginForm.do", new MemberLoginForm());
		map.put("/memberLogout.do", new MemberLogout());
		map.put("/memberJoinForm.do", new MemberJoinForm());
		map.put("/memberJoin.do", new MemberJoin());
		map.put("/ajaxMemberIdCheck.do", new AjaxMemberIdCheck());
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
			System.out.println("uri: " + uri);
		String contextPath = request.getContextPath();
			System.out.println("conPath: " + contextPath);
		String page = uri.substring(contextPath.length());
			System.out.println("page: " + page); // /main.do
		
		Command command = map.get(page); 
		// command는 interface이므로 구현객체를 통해서만 생성 가능	
		// command = new MainCommand()와 같은 의미
		
		String viewPage = command.exec(request, response);
			System.out.println("viewPage: " + viewPage); // main/main
		
		// viewResolve, 보여줄 페이지 선택
		if(!viewPage.endsWith(".do") && !viewPage.equals(null)) { // viewPage가 .do로 끝나지 않고 null이 아니면
			if(viewPage.startsWith("ajax:")) { // ajax로 들어온 페이지 처리
					response.setContentType("text/html; charset=UTF-8");
					response.getWriter().append(viewPage.substring(5));
					return;
			}else {
				viewPage = "WEB-INF/view/" + viewPage + ".jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
				dispatcher.forward(request, response);
			}
		
		}else {
			response.sendRedirect(viewPage);
		}
		
		System.out.println("(resolved) viewPage2: " +  viewPage);
		
	}


}
