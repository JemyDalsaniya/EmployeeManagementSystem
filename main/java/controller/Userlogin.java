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
 * Servlet implementation class User_login
 */
public class Userlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Userlogin() {
		// TODO Auto-generated constructor stub
		super();
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
		PrintWriter out = response.getWriter();
		/*
		 * String username; String email = request.getParameter("email"); try {
		 * PreparedStatement pstmt =
		 * conn.prepareStatement("select * from user where email=" + email); ResultSet
		 * rs = pstmt.executeQuery(); if (rs.next()) { username = rs.getString(2);
		 * out.println("welcome.." + username); }
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		Map<String, String> messages = new HashMap<String, String>();
		request.setAttribute("messages", messages);
		Employee emp = new Employee();
		response.setContentType("text/html");
		HttpSession session = request.getSession();

		emp.setEmpEmail(request.getParameter("email"));
		emp.setEmpPassword(request.getParameter("password"));

		UserService service = new UserService();
		boolean isValid = service.compareLoginDetails(emp);

		if (isValid) {
			if (emp.getEmpStatus()) {
				session.setAttribute("admin", emp);
				response.sendRedirect("AdminHomePage.jsp");
			} else {

				session.setAttribute("employee", emp);
				response.sendRedirect("EmployeeHomePage.jsp");
			}
		} else {
			messages.put("error", "Enter valid EmailId and Password!!");
			RequestDispatcher req = request.getRequestDispatcher("login.jsp");
			req.include(request, response);
		}

	}

}
