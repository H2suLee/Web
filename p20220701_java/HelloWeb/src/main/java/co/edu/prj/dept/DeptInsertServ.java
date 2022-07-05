package co.edu.prj.dept;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeptInsertServ
 */
@WebServlet("/DeptInsert")
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
		// 등록 처리
		// response.setContentType("text/html; charset=UTF-8");
		// response.getWriter().append("get 요청");
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
		// System.out.println(name);

		DeptVO vo = new DeptVO();

		vo.setDeptId(id);
		vo.setDeptName(name);

		DeptDAO dao = new DeptDAO();
		int cnt = dao.insert(vo);

		//response.getWriter().append(id).append(name).append(cnt + "건이 등록됨");
		request.getRequestDispatcher("DeptListServ").forward(request, response);

	}

}
