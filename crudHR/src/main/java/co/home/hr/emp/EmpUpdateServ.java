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
@WebServlet("/EmpUpdateServ")
public class EmpUpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpUpdateServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("employeeId");
		request.setAttribute("emp", new EmpDAO().selectOne(id));
		request.setAttribute("jobList", new EmpDAO().selectJob());
		request.setAttribute("deptList", new DeptDAO().selectDept());
		request.getRequestDispatcher("WEB-INF/jsp/emp/empUpdate2.jsp").forward(request, response);
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
		String deptId = request.getParameter("departmentId");

		EmpVO vo = new EmpVO();
		vo.setEmployeeId(id);
		vo.setLastName(name);
		vo.setEmail(email);
		vo.setHireDate(date);
		vo.setJobId(jobId);
		vo.setDepartmentId(deptId);

		int cnt = new EmpDAO().updateEmp(vo);
		response.getWriter().append("<script>").append("alert('" + cnt + "건 수정 완료');")
				.append("location.href='EmpSelectServ';").append("</script>");

	}

}
