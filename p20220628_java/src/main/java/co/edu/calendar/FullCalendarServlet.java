package co.edu.calendar;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class FullCalendarServlet
 */
@WebServlet("/FullCalendarServlet")
public class FullCalendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FullCalendarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");

		CalendarDAO dao = new CalendarDAO();
		List<CalendarVO> list = dao.getSchedule();

		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(list));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		Gson gson = new GsonBuilder().create();
		PrintWriter out = response.getWriter();
		// 파라미터 정보: cmd=insert, title=입력값, start=입력값, end=입력값

		String cmd = request.getParameter("cmd");
		String title = request.getParameter("title");
		String start = request.getParameter("start");
		String end = request.getParameter("end");

		CalendarVO vo = new CalendarVO();
		vo.setTitle(title);
		vo.setStartDate(start);
		vo.setEndDate(end);

		CalendarDAO dao = new CalendarDAO();

		if (cmd.equals("insert")) {
			// vo 생성이랑 setter를 여기?
			if (dao.insertSchedule(vo)) {
				// {"retCode" : "Success"}
				out.print("{\"retCode\" : \"Success\"}");
			} else {
				out.print("{\"retCode\" : \"Fail\"}");
			}
		} else if (cmd.equals("del")) {
			String delTitle = request.getParameter("title");
			if (dao.deleteSchedule(delTitle)) {
				// {"retCode" : "Success"}
				out.print("{\"retCode\" : \"Success\"}");
			} else {
				out.print("{\"retCode\" : \"Fail\"}");
			}
		}
	}

}
