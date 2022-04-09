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
 * Servlet implementation class displayProject
 */
public class displayProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public displayProject() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String status = request.getParameter("status");
		Project p = new Project();
		p.setProjectStatus(status);

		ProjectService lservice = new ProjectService();
		List<Project> list = lservice.displayProject(p);
		// System.out.println("List" + list);
		HttpSession s = request.getSession();
		s.setAttribute("project", list);
		RequestDispatcher rd = request.getRequestDispatcher("DisplayProjectAdmin.jsp");
		rd.forward(request, response);

	}

}
