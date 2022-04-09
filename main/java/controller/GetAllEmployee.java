package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Employee;
import service.UserService;

/**
 * Servlet implementation class GetAllEmployee
 */
public class GetAllEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// TODO Auto-generated method stub
		Employee emp = new Employee();
		System.out.println("hello inside method");
		UserService service = new UserService();
		String project_status = request.getParameter("project_status");
		String project_id = request.getParameter("project_id");
		if (request.getParameter("view") != null) {
			List<Employee> list = service.getWorkingEmployee(project_id, project_status, emp);
			HttpSession session = request.getSession();
			session.setAttribute("WorkingEmployeeList", list);
			RequestDispatcher req = request.getRequestDispatcher("OngoingProjectDetails.jsp");
			req.forward(request, response);

		} else if (request.getParameter("complete") != null) {
			service.completedProject(project_id);
			RequestDispatcher req = request.getRequestDispatcher("AdminHomePage.jsp");
			req.forward(request, response);

		} else if (request.getParameter("viewCompletedProjectEmployee") != null) {

			List<Employee> list1 = service.getWorkingEmployee(project_id, project_status, emp);
			HttpSession session = request.getSession();
			session.setAttribute("EmployeeList", list1);

			RequestDispatcher req = request.getRequestDispatcher("CompletedProjectDetails.jsp");
			req.forward(request, response);

		}

	}
}
