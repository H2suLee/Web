package co.home.hr.dept;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeptUpdateServ
 */
@WebServlet("/DeptUpdateServ")
public class DeptUpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeptUpdateServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("departmentId");
		DeptDAO dao = new DeptDAO();
		request.setAttribute("dept", dao.selectOne(id));
		request.getRequestDispatcher("/WEB-INF/jsp/dept/deptUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("departmentId");
		String name = request.getParameter("departmentName");

		DeptVO vo = new DeptVO();
		vo.setDepartmentId(id);
		vo.setDepartmentName(name);

		int cnt = new DeptDAO().updateDept(vo);
		response.getWriter().append("<script>").append("alert('" + cnt + "건 수정 완료');")
		.append("location.href='DeptSelectServ';").append("</script>");
	}

}
