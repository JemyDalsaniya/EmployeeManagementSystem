package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Logout() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		System.out.println("session emp:" + session.getAttribute("employee"));
		System.out.println("session admin:" + session.getAttribute("admin"));

		System.out.println("before logout:" + session);
		session.invalidate();
		System.out.println("after logout:" + session);

		request.getRequestDispatcher("login.jsp").include(request, response);
//		out.println("<script type=\"text/javascript\">");
//		out.println("alert('Logout Successfully!!');");
//		out.println("</script>");
		// out.close();
	}

}
