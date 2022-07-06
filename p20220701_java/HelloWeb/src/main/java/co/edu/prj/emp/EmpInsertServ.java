package co.edu.prj.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.prj.dept.DeptDAO;

// 서블릿 손수 만들어 보기

@WebServlet("/empInsert")
public class EmpInsertServ extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// super.doGet(req, resp); // 안 없애면 오류남

		// DB 연결
		// jobs table 연결
		req.setAttribute("jobs", new EmpDAO().selectJobsAll());
		req.setAttribute("depts", new DeptDAO().selectDeptAll());
		
		req.getRequestDispatcher("/WEB-INF/jsp/emp/empInsert.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		//String id = req.getParameter("no");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String date = req.getParameter("date");
		String jobId = req.getParameter("job");

		EmpVO vo = new EmpVO();

		//vo.setEmployeeId(id);
		vo.setLastName(name);
		vo.setEmail(email);
		vo.setHireDate(date);
		vo.setJobId(jobId);

		EmpDAO dao = new EmpDAO();
		int cnt = dao.insert(vo);
		
		// 결과 출력
		// resp.getWriter().append(id).append(name).append(cnt + "건이 등록됨");
		
		// getRequestDispatcher 에서는 결과가 안나옴, 서블릿 주소가 empInsert로 유지
		// 같은 웹페이지에서 새로고침한 느낌
		// req.getRequestDispatcher("empList").forward(req, resp);
		
		// sendRedirect는 empInsert 요청하고 empInsert의 응답에 따라 empList로 direct
		resp.sendRedirect("empList");
		
		// 다른 페이지(서블릿)로 가려면 sendDirect()

	}

}
