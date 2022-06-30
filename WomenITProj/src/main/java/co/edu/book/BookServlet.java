package co.edu.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");

		Gson gson = new GsonBuilder().create();
		PrintWriter out = response.getWriter();

		BookDAO dao = new BookDAO();
		List<BookVO> list = dao.listData();
		out.print(gson.toJson(list));
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

		Gson gson = new GsonBuilder().create();
		PrintWriter out = response.getWriter();

		String cmd = request.getParameter("cmd");
		String no = request.getParameter("no");

		BookDAO dao = new BookDAO();

		if (cmd.equals("insert")) {
			// ★★★★ if문 밖에 아래 라인을 짜놓으니까 remove에서 parsing 에러남
			//
			
			String name = request.getParameter("name");
			String writer = request.getParameter("writer");
			String publisher = request.getParameter("publisher");
			String price = request.getParameter("price");

			BookVO vo = new BookVO();
			vo.setNo(no);
			vo.setName(name);
			vo.setWriter(writer);
			vo.setPublisher(publisher);
			vo.setPrice(Integer.parseInt(price));
			
			//
			
			out.print(gson.toJson(dao.insertData(vo)));
	
		} else if (cmd.equals("remove")) {
			if (dao.deleteData(no)) {
				out.print("{\"retCode\": \"Success\"}");
			} else {
				out.print("{\"retCode\": \"Fail\"}");
			}
		}
	}

}
