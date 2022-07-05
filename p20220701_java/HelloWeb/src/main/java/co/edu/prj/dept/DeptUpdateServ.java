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
@WebServlet("/DeptUpdate")
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
		// 수정 페이지 이동
		// response.setContentType("text/html; charset=UTF-8");
		// response.getWriter().append("get 요청");

		// 부서 번호로 단건 조회
		DeptDAO dao = new DeptDAO();
		String departmentId = request.getParameter("departmentId");
		request.setAttribute("dept", dao.selectOne(departmentId));
		request.getRequestDispatcher("/WEB-INF/jsp/dept/deptUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// DB 수정 처리
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("departmentId");
		String name = request.getParameter("departmentName");
		// System.out.println(name);

		DeptVO vo = new DeptVO();

		vo.setDeptId(id);
		vo.setDeptName(name);

		DeptDAO dao = new DeptDAO();
		int cnt = dao.update(vo);

		// response.getWriter().append(id).append(name).append(cnt + "건이 등록됨");
		request.getRequestDispatcher("DeptListServ").forward(request, response);

	}

}
