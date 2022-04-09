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
import service.UserService;

/**
 * Servlet implementation class ProjectDetails
 */
public class ProjectDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProjectDetails() {
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
		// doGet(request, response);

		Project project = new Project();
		Employee emp = new Employee();
		ProjectService serviceobj = new ProjectService();
		UserService userobj = new UserService();

		int project_id = Integer.parseInt(request.getParameter("project_id"));
		String project_status = request.getParameter("project_status");

		project.setProjectId(project_id);
		project.setProjectStatus(project_status);

		List<Employee> emplist = userobj.displayUser(emp);
		List<Project> list = serviceobj.projectDetails(project);
		List<Project> plist = serviceobj.displayAllProjects(project);
		System.out.println(plist);

		HttpSession session = request.getSession();
		session.setAttribute("projectDetails", list);
		session.setAttribute("employeeList", emplist);
		session.setAttribute("projectList", plist);

		if (project_status.equals("upcoming")) {
			RequestDispatcher req = request.getRequestDispatcher("UpcomingProjectDetails.jsp");
			req.forward(request, response);
		} else if (project_status.equals("ongoing")) {
			RequestDispatcher req = request.getRequestDispatcher("OngoingProjectDetails.jsp");
			req.forward(request, response);
		} else if (project_status.equals("completed")) {
			RequestDispatcher req = request.getRequestDispatcher("CompletedProjectDetails.jsp");
			req.forward(request, response);
		} else {
			RequestDispatcher req = request.getRequestDispatcher("GetAllProjects.jsp");
			req.forward(request, response);

		}

	}

}
