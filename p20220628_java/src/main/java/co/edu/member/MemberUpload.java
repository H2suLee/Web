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
import com.google.gson.JsonObject;
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");

		// 요청이 Multipart 요청인 지 아닌 지 체크

		boolean isMulti = ServletFileUpload.isMultipartContent(request);
		if (isMulti) {

			String file = request.getServletContext().getRealPath("images");
			int fileSize = 5 * 1023 * 1024; // 5메가
			MultipartRequest mr = new MultipartRequest(request, file, fileSize, "utf-8", new DefaultFileRenamePolicy());
			// 파일이름, 파일사이즈, 인코딩타입, 리네임정책,

			// String no = mr.getParameter("no");
			String name = mr.getParameter("name");
			String phone = mr.getParameter("phone");
			String addr = mr.getParameter("addr");
			String birth = mr.getParameter("birth");
			String image = mr.getParameter("image");
			image = mr.getFilesystemName("image"); // 바뀐 이름으로 저장

			MemberVO vo = new MemberVO();
			// vo.setMembNo(Integer.parseInt(no));
			vo.setMembName(name);
			vo.setMembPhone(phone);
			vo.setMembAddr(addr);
			vo.setMembBirth(birth);
			vo.setMembImage(image);

			MemberDAO dao = new MemberDAO();
			Gson gson = new GsonBuilder().create();
			PrintWriter out = response.getWriter();
			dao.insertData(vo);
			// 방법 1
			/*
			 * JsonObject obj = new JsonObject();
			 * 
			 * // obj.addProperty("membNo", no); // {membNo: 20};
			 * obj.addProperty("membName", name); obj.addProperty("membPhone", phone);
			 * obj.addProperty("membAddr", addr); obj.addProperty("membBirth", birth);
			 * obj.addProperty("membImage", image); obj.addProperty("retCode", "Success");
			 * 
			 * out.print(gson.toJson(obj));
			 */
			// 방법 2
			// {"retCode": "Fullfilled"}
			out.print(gson.toJson("{\"retCode\": \"Fullfilled\"}"));
			
		} else {
			String cmd = request.getParameter("cmd");
			String id = request.getParameter("no");
			PrintWriter out = response.getWriter();
			if (cmd.equals("remove")) {
				MemberDAO dao = new MemberDAO();
				if (dao.deleteData(Integer.parseInt(id))) {
					out.print("{\"retCode\": \"Success\"}");
				} else {
					out.print("{\"retCode\": \"Fail\"}");
				}
			}
		}

	}
}
