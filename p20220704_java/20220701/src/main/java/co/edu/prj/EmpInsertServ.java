package co.edu.prj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿 손수 만들어 보기

@WebServlet("/empInsert")
public class EmpInsertServ extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//super.doGet(req, resp); // 안 없애면 오류남
		req.getRequestDispatcher("/WEB-INF/jsp/empInsert.jsp").forward(req, resp);
	}
}
