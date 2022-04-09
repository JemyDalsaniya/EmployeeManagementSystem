package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Project;
import service.ProjectService;

/**
 * Servlet implementation class AddProject
 */
public class AddProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProject() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		Project project = new Project();
		PrintWriter out = response.getWriter();

		// object of model bean class Project
		project.setProjectName(request.getParameter("projectname"));
		project.setProjectStatus("upcoming");

		Map<String, String> messages = new HashMap<String, String>();
		request.setAttribute("messages", messages);

		// object of projectservice implementation class
		ProjectService obj = new ProjectService();
		obj.validateProjectDetails(project, messages);

		HttpSession session = request.getSession();
		if (messages.isEmpty()) {
			session.invalidate();
			out.println("<script type=\"text/javascript\">");
			System.out.println("console.log('hello inside script')");
			out.println("alert('Project added Successfully!!');");
			out.println("</script>");

			obj.addProject(project);
			RequestDispatcher req = request.getRequestDispatcher("AdminHomePage.jsp");
			req.forward(request, response);
		} else {
			RequestDispatcher req = request.getRequestDispatcher("AddProject.jsp");
			req.include(request, response);
		}
	}
}
