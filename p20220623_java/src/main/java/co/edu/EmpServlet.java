// me version
package co.edu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// .html의 XMLHttpRequest 객체로부터 get 형식의 요청이 들어오면 실행할 내용:
		// Emp dao 객체를 생성하여 listEmp()(전체리스트 조회 기능)를 실행하고,
		// listEmp()를 통해 리턴받은 값을 JSON 형식으로 .html에 반납, 비동기 객체는 반납받은 데이터로 함수 실행
		EmpDAO dao = new EmpDAO();
		List<EmpVO> list = dao.listEmp();
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(list));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
