package co.home.hr.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.home.hr.dept.DeptDAO;

/**
 * Servlet implementation class EmpInsertServ
 */
@WebServlet("/EmpInsertServ")
public class EmpInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpInsertServ() {
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
		
		request.setAttribute("jobList", new EmpDAO().selectJob());
		request.setAttribute("deptList", new DeptDAO().selectDept());
		request.getRequestDispatcher("/WEB-INF/jsp/emp/empInsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		
		String id = request.getParameter("employeeId");
		String name = request.getParameter("lastName");
		String email = request.getParameter("email");
		String date = request.getParameter("hireDate");
		String jobId = request.getParameter("jobId");
		String departmentId = request.getParameter("departmentId");

		EmpVO vo = new EmpVO();
		vo.setEmployeeId(id);
		vo.setLastName(name);
		vo.setEmail(email);
		vo.setHireDate(date);
		vo.setJobId(jobId);
		vo.setDepartmentId(departmentId);

		EmpDAO dao = new EmpDAO();
		int cnt = dao.insertEmp(vo);

		response.sendRedirect("EmpSelectServ");
	}

}
