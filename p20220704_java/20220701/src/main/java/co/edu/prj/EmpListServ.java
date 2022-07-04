// EmpListServ. 스크립틀릿태그(?)

package co.edu.prj;

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
@WebServlet("/EmpListServ")
public class EmpListServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpListServ() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><body><table><thead><tr><th>사번</th><th>이름</th><th>급여</th></tr></thead>\r\n" + "");
		out.print("<tbody>");
		List<EmpVO> list = new ArrayList<>();
		list.add(new EmpVO("100", "Ann", "43000"));
		list.add(new EmpVO("101", "Lesley", "20000"));
		list.add(new EmpVO("102", "Chris", "35000"));

		for (EmpVO vo : list) {
			out.print("<tr>");
			out.printf("<td>%s</td>", vo.getEmployeeId());
			out.printf("<td>%s</td>", vo.getFirstName());
			out.printf("<td>%s</td>", vo.getSalary());
			out.print("</tr>");
		}
		out.print("</tbody></table></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
