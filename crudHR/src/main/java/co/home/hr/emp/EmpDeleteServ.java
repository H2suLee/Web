package co.home.hr.emp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.home.hr.dept.DeptDAO;
import co.home.hr.dept.DeptVO;

/**
 * Servlet implementation class EmpUpdateServ
 */
@WebServlet("/EmpDeleteServ")
public class EmpDeleteServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpDeleteServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("employeeId");
		int cnt = new EmpDAO().deleteEmp(id);
		response.getWriter().append("<script>").append("alert('" + cnt + "건 삭제 완료');")
				.append("location.href='EmpSelectServ';").append("</script>");

	}

}
