package co.home.hr.dept;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeptInsertServ
 */
@WebServlet("/DeptInsertServ")
public class DeptInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeptInsertServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/dept/deptInsert.jsp").forward(request, response);

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

		DeptDAO dao = new DeptDAO();
		int cnt = dao.insertDept(vo);

		// response.getWriter().append(id).append(name).append(cnt + "건이 등록됨");
		request.getRequestDispatcher("DeptSelectServ").forward(request, response);
	}

}
