// me version

package co.edu.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// 주로 조회는 get, 삽입/갱신/삭제는 post
	// memberForm 연습을 위해 get 방식으로도 간단히 삽입/갱신/삭제 해보기
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글 깨짐 현상 예방
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		Gson gson = new GsonBuilder().create();
		PrintWriter out = response.getWriter();

		// .html의 form 태그로부터 get 형식의 요청이 들어오면 실행할 내용:
		// MemberDAO 객체를 생성하고 cmd 파라미터의 value 별로 조회,삽입,갱신,삭제
		// 각 기능별로 리턴받은 값은 각 resonse.getWriter().print()에 따라 화면에 그대로 출력
		MemberDAO dao = new MemberDAO();
		String cmd = request.getParameter("cmd");
		// response.getWriter().print(gson.toJson(list));
		List<MemberVO> list = dao.listData();
		if (cmd.equals("select")) {
			response.getWriter().print(gson.toJson(dao.listData()));
		} else if (cmd.equals("insert")) {
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String address = request.getParameter("addr");
			// 받지 않은 parameter엔 null으로 insert됨
			MemberVO vo = new MemberVO();
			vo.setMembName(name);
			vo.setMembPhone(phone);
			vo.setMembAddr(address);

			dao.insertData(vo);

			response.getWriter().print(gson.toJson(vo));
			// response.getWriter().print(gson.toJson(dao.insertData(vo))); //도 됨, 매개변수로 들어간
			// vo랑 리턴받은 vo랑 같은 주소를 공유하고 있다고 함
		} else if (cmd.equals("update")) {
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String address = request.getParameter("addr");
			String no = request.getParameter("no");
			// 받지 않은 parameter엔 null으로 insert됨
			MemberVO vo = new MemberVO();
			vo.setMembName(name);
			vo.setMembPhone(phone);
			vo.setMembAddr(address);
			vo.setMembNo(Integer.parseInt(no)); // 파라미터 값은 무조건 string으로 넘어오므로, 형변환 해줘야
			if (dao.updateData(vo)) {
				out.print("{\"retCode\": \"Success\"}");
			} else {
				out.print("{\"retCode\": \"Fail\"}");
			}
		} else if (cmd.equals("delete")) {
			String no = request.getParameter("no");
			if (dao.deleteData(Integer.parseInt(no))) {
				response.getWriter().print("\"Delete Success\"");
			} else {
				response.getWriter().print("\"Delete Fail\"");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// memberAjax로 삽입(add)/갱신(modify)/삭제(remove)
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글 깨짐 현상 예방
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");

		// 필요 기능 import
		Gson gson = new GsonBuilder().create();
		PrintWriter out = response.getWriter();

		// .html의 js의 생성된 비동기객체 xtml로부터 open send 메소드를 통해 post 형식의 데이터 요청이 들어오면 실행할 내용:
		// MemberDAO 객체를 생성하고 cmd value따라 삽입(add)/갱신(modify)/삭제(remove)
		// 각 기능별로 리턴받은 값을 .html의 JS로 넘길 예정이며, JS는 xhtp의 .responseText를 통해 받음.

		// xhtp.send(`name=${mNm}&addr=${mAr}&phone=${mPh}&birth=${mBr}&cmd=add`);
		// js에서 위와 같이 인자값을 전달해 주면 아래와 같이 받으면 됨

		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		String birth = request.getParameter("birth");
		String image = request.getParameter("image");

		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		vo.setMembName(name);
		vo.setMembPhone(phone);
		vo.setMembAddr(addr);
		vo.setMembBirth(birth);
		vo.setMembImage(image);

		// cmd 값으로 조건문 생성
		String cmd = request.getParameter("cmd");
		if (cmd.equals("add")) {
			dao.insertData(vo);
			out.print(gson.toJson(vo));
			// out.print(gson.toJson(dao.insertData(vo))); // 도 됨
		} else if (cmd.equals("modify")) {
			JsonObject obj = new JsonObject();
			String num = request.getParameter("no");
			vo.setMembNo(Integer.parseInt(num));
			if (dao.updateData(vo)) {
				// out.print("{\"retCode\": \"Success\"}");
				
				// for 수정 방법 2
				// {"membNo": "num", "membName": "name", "membPhone": "phone", "membAddr": "vo.getMembAddr()", "membBirth": "birth" "membImage": "image", "retCode": "Success"}
				// out.print("{\"membNo\": \""+num+"\", \"membName\": \""+name+"\", \"membPhone\": \""+phone+"\", \"membAddr\": \""+addr+"\", \"membBirth\": \""+birth+"\" , \"retCode\": \"Success\" }");
				
				// 윗줄을 라이브러리를 사용해서 편리하게
				obj.addProperty("membNo", num); // {membNo: 20};
				obj.addProperty("membName", name);
				obj.addProperty("membPhone", phone);
				obj.addProperty("membAddr", addr);
				obj.addProperty("membBirth", birth);
				obj.addProperty("retCode", "Success");
			} else {
				obj.addProperty("retCode", "Fail");
			}
			out.print(gson.toJson(obj));
			// obj: JSON 오브젝트로 만드는 놈
			// out.print() : ()안의 놈을 JSON 형태의 문자열로 만들어 주는 놈
		} else if (cmd.equals("remove")) {
			String no = request.getParameter("no");
			if (dao.deleteData(Integer.parseInt(no))) {
				out.print("{\"retCode\": \"Success\"}");
			} else {
				out.print("{\"retCode\": \"Fail\"}");
			}
		} else {
			out.print(dao.listData());
		}

	}

}