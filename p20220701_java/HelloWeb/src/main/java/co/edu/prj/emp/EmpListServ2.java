// EmpListServ2. JDBC 연결
package co.edu.prj.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class EmpListServ
 */
@WebServlet(urlPatterns = { "/EmpListServ2", "/empList" }) // 주소 중복되면 톰캣 실행 안됨 (localhost에서 거부함)
public class EmpListServ2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpListServ2() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		EmpDAO dao = new EmpDAO();
		// selectAll()
		// request.setAttribute("list", dao.selectAll());
		// http://localhost/HelloWeb/EmpListServ2
		
		// selectConditionallyAll()
		String deptId = request.getParameter("departmentId");
		request.setAttribute("list", dao.selectConditionallyAll(deptId));
		// http://localhost/HelloWeb/EmpListServ2?departmentId=60
		request.getRequestDispatcher("/WEB-INF/jsp/emp/empList2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
