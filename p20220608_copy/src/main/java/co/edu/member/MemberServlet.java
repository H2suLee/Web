package co.edu.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// 원래는
	// get 방식 -> 조회
	// post 방식 -> 입력, 수정, 삭제
	// 지금은 연습을 위해 doGet에 조회, 입력, 수정, 삭제 다 구현

	// 서블릿의 처리 방식에는 form, ajax 두 개의 방식이 있다
	// form (jsp) 경로 이동이 많다
	// ajax 한 화면 안에서 구현 가능
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글 깨짐 현상 예방
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");

//		Gson gson = new GsonBuilder().create();
		Gson gson - new GsonBuilder().create();
		String cmd = request.getParameter("cmd");
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.memberList();
		response.getWriter().print(gson.toJson(list));
		if (cmd.equals("list")) {
			// 전체 리스트 => json
//			List<MemberVO> list = dao.memberList();
//			response.getWriter().print(gson.toJson(list));
		} else if (cmd.equals("insert")) {
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String addr = request.getParameter("addr"); // 넘겨준 값 만큼 넘어감
			MemberVO vo = new MemberVO();
			vo.setMembName(name);
			vo.setMembPhone(phone);
			vo.setMembAddr(addr);
			dao.insertMember(vo);// ★vo 리턴, 어디 담을 필요 없는 지..

			response.getWriter().print(gson.toJson((vo)));
		} else if (cmd.equals("update")) {
			String numb = request.getParameter("no"); // key
			String phone = request.getParameter("ph"); // 수정할 value

			MemberVO vo = new MemberVO();
			vo.setMembNo(Integer.parseInt(numb));
			vo.setMembPhone(phone);

			boolean updateMemberResult = dao.updateMember(vo); // boolean 리턴

			if (updateMemberResult) {
				response.getWriter().print("{\"retCode\": \"Success\"}"); // {"retcode" : "Succcess"}
			} else {
				// ex no에 db에 없는 memb_no를 넣을 경우
				response.getWriter().print("{\"retCode\": \"Fail\"}"); // {"retcode" : "Fail"}
			}

		} else if (cmd.equals("delete")) {
			String delNo = request.getParameter("delNumber");
			if (dao.deleteMember(Integer.parseInt(delNo))) {
				response.getWriter().print("{\"retCode\": \"Success\"}"); // {"retcode" : "Success"}
			} else {
				response.getWriter().print("{\"retCode\": \"Fail\"}"); // {"retcode" : "Fail"}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");

		String membName = request.getParameter("name");
		String membAddr = request.getParameter("addr");
		String membPhone = request.getParameter("phone");
		String membBirth = request.getParameter("birth");
		String membImage = request.getParameter("image");
		
		MemberVO vo = new MemberVO();
		vo.setMembName(membName);
		vo.setMembAddr(membAddr);
		vo.setMembPhone(membPhone);
		vo.setMembBirth(membBirth);
		vo.setMembImage(membImage);
		
		MemberDAO dao = new MemberDAO();
		
		Gson gson = new GsonBuilder().create();
		PrintWriter out = response.getWriter();
		
		// 포스트 방식이 요청되면 실행할 메소드
		String cmd = request.getParameter("cmd");
		if (cmd.equals("add")) {
			// 1. 입력
			dao.insertMember(vo);
			out.print(gson.toJson(vo)); // dao.insertMember(vo) 랑 vo랑 같은 주소를 가지고 있다

		} else if (cmd.equals("modify")) {
			// 2. 수정
			if(dao.updateMember(vo)) {
				out.print("{\"retCode\" = \"Success\"}");
			} else {
				out.print("{\"retCode\" = \"Fail\"}");
			}
		} else if (cmd.equals("remove")) {
			// 3. 삭제
			String delNo = request.getParameter("delNo");
			if(dao.deleteMember(Integer.parseInt(delNo))) {
				out.print("{\"retCode\" = \"Success\"}");
			} else {
				out.print("{\"retCode\" = \"Fail\"}");
			}
		}

	}

}
