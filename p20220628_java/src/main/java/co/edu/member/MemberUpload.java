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
 * Servlet implementation class MemberUpload
 */
@WebServlet({ "/memberUpload", "/fileUpload" })
public class MemberUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberUpload() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 요청이 Multipart 요청인 지 아닌 지 체크

		boolean isMulti = ServletFileUpload.isMultipartContent(request);
		if (isMulti) {

			String file = request.getServletContext().getRealPath("images");
			int fileSize = 5 * 1023 * 1024; // 5메가
			MultipartRequest mr = new MultipartRequest(request, file, fileSize, "utf-8", new DefaultFileRenamePolicy());
			// 파일이름, 파일사이즈, 인코딩타입, 리네임정책,

			String name = mr.getParameter("name");
			String phone = mr.getParameter("phone");
			String addr = mr.getParameter("addr");
			String birth = mr.getParameter("birth");
			String image = mr.getParameter("image");
			image = mr.getFilesystemName("image"); // 바뀐 이름으로 저장

			MemberVO vo = new MemberVO();
			vo.setMembName(name);
			vo.setMembPhone(phone);
			vo.setMembAddr(addr);
			vo.setMembBirth(birth);
			vo.setMembImage(image);

			MemberDAO dao = new MemberDAO();
			Gson gson = new GsonBuilder().create();
			PrintWriter out = response.getWriter();
			dao.insertData(vo);

			// {"retCode": "Fullfilled"}
			out.print("{\"retCode\": \"Fullfilled\"}");
		} else {
			String cmd=request.getParameter("cmd");
			String id=request.getParameter("no");
			PrintWriter out = response.getWriter();
			if(cmd.equals("remove")) {
				MemberDAO dao = new MemberDAO();
				if(dao.deleteData(Integer.parseInt(id))) {
					out.print("{\"retCode\": \"Success\"}");
				}else {
					out.print("{\"retCode\": \"Fail\"}");
				}
			}
		}

	}
}
