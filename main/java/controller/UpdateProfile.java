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
 * Servlet implementation class UpdateProfile
 */
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	Connection conn;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// create connection
		try {
			conn = MyConnection.getInstance().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Employee emp = new Employee();

		// Employee emp = (Employee) session.getAttribute("employee");
//		HttpSession session1 = request.getSession();

		/*
		 * emp.setEmpId(Integer.parseInt(request.getParameter("empId")));
		 * System.out.println("Employee Id : " + request.getParameter("empId"));
		 */
		emp.setEmpName(request.getParameter("empName"));
		emp.setEmpEmail(request.getParameter("empEmail"));
		emp.setEmpContact(request.getParameter("empContact"));
		emp.setEmpPassword(request.getParameter("empPassword"));

		Map<String, String> messages = new HashMap<String, String>();
		request.setAttribute("messages", messages);

		UserService us = new UserService();
		us.validateUserDetails(emp, messages);
		HttpSession session = request.getSession();
		if (messages.isEmpty()) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Updated Successfully!!');");
			out.println("</script>");
			session.invalidate();

			us.userUpdate(emp);
			RequestDispatcher req = request.getRequestDispatcher("/login.jsp");
			req.forward(request, response);
		} else

		{
			RequestDispatcher req = request.getRequestDispatcher("EditProfile.jsp");
			req.include(request, response);
		}

	}
}
