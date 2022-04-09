package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Project;
import service.ProjectService;

/**
 * Servlet implementation class displayAllProject
 */
public class displayAllProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public displayAllProject() {
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
		String status = request.getParameter("status");
		Project p = new Project();
		p.setProjectStatus(status);

		// int project_id = Integer.parseInt(request.getParameter("project_id"));
		// System.out.println("id is:" + project_id);
		// p.setProjectId(project_id);
		// System.out.println("id is:" + project_id);

		ProjectService lservice = new ProjectService();
		List<Project> list = lservice.displayAllProjects(p);
		System.out.println("List in displayAllProject:" + list);
		HttpSession s = request.getSession();
		s.setAttribute("project", list);
		RequestDispatcher rd = request.getRequestDispatcher("GetAllProjects.jsp");
		rd.forward(request, response);
	}

}
