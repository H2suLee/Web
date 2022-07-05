package co.edu;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet(urlPatterns = "/hello", loadOnStartup = 1)
// loadOnStartup: 서버를 Startup할 때 자동으로 서블릿 로드하는 속성
public class HelloWorld2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("served");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	public void destroy() {
		System.out.println("destroyed"); // server(tomcat)을 stop 하는 경우..
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("initialized");
	}

}
