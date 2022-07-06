package co.edu.prj.emp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpDeleteServ
 */
@WebServlet("/EmpDeleteServ")
public class EmpDeleteServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpDeleteServ() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("no");
		int cnt = new EmpDAO().delete(id);
		// request.setAttribute("msg", cnt + "삭제됨");
		// response.getWriter().append(cnt + "삭제됨");
		// request.getRequestDispatcher("/WEB-INF/jsp/message.jsp");

		response.getWriter().append("<script>").append("alert('" + cnt + "건 삭제 완료');").append("location.href='empList';")
				.append("</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
