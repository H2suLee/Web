package co.edu.prj.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.prj.dept.DeptDAO;

// 서블릿 손수 만들어 보기

@WebServlet("/empUpdate")
public class EmpUpdateServ extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// super.doGet(req, resp); // 안 없애면 오류남

		// DB 연결
		// jobs table 연결

		EmpDAO dao = new EmpDAO();

		String empId = req.getParameter("no");

		req.setAttribute("emp", dao.selectOne(empId));
		req.setAttribute("jobs", dao.selectJobsAll());
		req.setAttribute("depts", new DeptDAO().selectDeptAll());
		
		req.getRequestDispatcher("/WEB-INF/jsp/emp/empUpdate.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		String id = req.getParameter("no");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String date = req.getParameter("date");
		String jobId = req.getParameter("jobId");
		String deptId = req.getParameter("deptId");

		EmpVO vo = new EmpVO();

		vo.setEmployeeId(id);
		vo.setLastName(name);
		vo.setEmail(email);
		vo.setHireDate(date);
		vo.setJobId(jobId);
		vo.setDepartmentId(deptId);

		EmpDAO dao = new EmpDAO();
		int cnt = dao.update(vo);

		//resp.getWriter().append(id).append(name).append(cnt + "건이 수정됨");
		

		resp.getWriter().append("<script>").append("alert('" + cnt + "건 수정 완료');").append("location.href='empList';")
				.append("</script>");
	}

}
