package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Employee;
import service.UserService;
import utility.MyConnection;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	Connection conn;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// create connection
		try {
			conn = MyConnection.getInstance().getConnection();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		Employee emp = new Employee();
		PrintWriter out = response.getWriter();
		// TODO Auto-generated method stub

		emp.setEmpName(request.getParameter("name"));
		emp.setEmpEmail(request.getParameter("email"));
		emp.setEmpPassword(request.getParameter("password"));
		emp.setEmpContact(request.getParameter("contact"));

		Map<String, String> messages = new HashMap<String, String>();
		request.setAttribute("messages", messages);

		UserService serviceobj = new UserService();
		serviceobj.validateUserDetails(emp, messages);

		HttpSession session = request.getSession();
		if (messages.isEmpty()) {
			out.println("<script type=\"text/javascript\">");
			System.out.println("console.log('hello inside script')");
			out.println("alert('Registered Successfully!!');");
			out.println("</script>");
			session.invalidate();

			serviceobj.addUser(emp);
			RequestDispatcher req = request.getRequestDispatcher("/login.jsp");
			req.forward(request, response);
		} else

		{
			RequestDispatcher req = request.getRequestDispatcher("register.jsp");
			req.include(request, response);
		}
	}

}
