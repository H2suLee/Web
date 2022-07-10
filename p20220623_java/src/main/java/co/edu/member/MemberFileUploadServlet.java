package co.edu.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class MemberFileUploadServlet
 */
@WebServlet("/fileUpload")
public class MemberFileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberFileUploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Gson gson = new GsonBuilder().create();
		PrintWriter out = response.getWriter();

		// Multipart 요청일 때(파일 업로드 가능) -> MemberVO 인스턴스 생성하고, 이를 MemberDAO의 insertData()를
		// 통해 DB에 반영, 성공시 {"retCode": "Fullfilled"} JSON 문자열 리턴
		// application/x-www-form-urlencoded 요청일 때 -> MemberDAO의 deleteData(no)를 통해 삭제
		// 기능 수행, 성공시 {"retCode": "Success"} 리턴

		boolean isMulti = ServletFileUpload.isMultipartContent(request);
		if (isMulti) {
			// Multipart 요청일 때는 request.getParameter()로 태그의 name 속성을 불러오지 못함
			// MultipartRequest 객체를 생성하고 이 인스턴스로 getParameter() 메소드를 호출해야 함
			// MultipartRequest 객체를 생성할 때, 다섯 개의 인자가 필요
			// request, 파일경로, 파일사이즈, 인코딩타입, 리네임정책,

			String file = request.getServletContext().getRealPath("images");
			int fileSize = 5 * 1023 * 1024; // 5메가
			MultipartRequest mr = new MultipartRequest(request, file, fileSize, "utf-8", new DefaultFileRenamePolicy());
			String name = mr.getParameter("name");
			String phone = mr.getParameter("phone");
			String addr = mr.getParameter("addr");
			String birth = mr.getParameter("birth");
			String image = mr.getParameter("image");
			image=mr.getFilesystemName("image"); // 바뀐 이름으로 저장

			MemberVO vo = new MemberVO();
			vo.setMembName(name);
			vo.setMembPhone(phone);
			vo.setMembAddr(addr);
			vo.setMembBirth(birth);
			vo.setMembImage(image);

			MemberDAO dao = new MemberDAO();
			dao.insertData(vo);

			// {"retCode" : "Success"}
			out.print(gson.toJson("{\"retCode\" : \"Fullfilled\"}"));

		} else {
			MemberDAO dao = new MemberDAO();
			String cmd = request.getParameter("cmd");
			String no = request.getParameter("no");
			if (cmd.equals("remove")) {
				boolean result = dao.deleteData(Integer.parseInt(no));
				if (result) {
					out.print(gson.toJson("{\"retCode\" : \"Success\"}"));
				} else {
					out.print(gson.toJson("{\"retCode\" : \"Fail\"}"));
				}
			}

		}
	}

}
