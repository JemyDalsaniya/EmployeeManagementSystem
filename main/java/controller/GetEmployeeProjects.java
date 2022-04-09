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
import model.Project;
import service.ProjectService;

/**
 * Servlet implementation class GetEmployeeProjects
 */
public class GetEmployeeProjects extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetEmployeeProjects() {
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
		HttpSession session = request.getSession();
		Employee emp = (Employee) session.getAttribute("employee");
		int id = emp.getEmpId();

		Project obj = new Project();
		ProjectService service = new ProjectService();
		String Status = request.getParameter("project_status");
		obj.setProjectStatus(Status);

		List<Project> list = service.getEmpProjects(obj, id);
		HttpSession session1 = request.getSession();
		session1.setAttribute("EmpProject", list);
		RequestDispatcher req = request.getRequestDispatcher("GetEmployeeProjects.jsp");
		req.forward(request, response);

	}

}
