package service;

import java.util.List;
import java.util.Map;

import dao.ProjectDaoImpl;
import model.Project;

public class ProjectService implements ProjectServiceDao {

	ProjectDaoImpl obj = new ProjectDaoImpl();

	@Override
	public void addProject(Project project) {
		obj.newProject(project);
	}

	@Override
	public List<Project> displayProject(Project p) {
		List<Project> list = obj.displayProject(p);
		return list;

	}

	@Override
	public void validateProjectDetails(Project project, Map<String, String> messages) {
		// TODO Auto-generated method stub

		if (project.getProjectName() == " " || project.getProjectName() == "") {
			messages.put("projectname", "Please enter Project Name!!");
		} else if (!project.getProjectName().matches("^[a-zA-Z\\s]*$")) {
			messages.put("projectname", "Please enter alphabets only!!");
		}

	}

	@Override
	public List<Project> projectDetails(Project project) {
		// TODO Auto-generated method stub
		List<Project> list = obj.projectDetails(project);
		return list;
	}

	@Override
	public List<Project> getEmpProjects(Project project, int id) {
		// TODO Auto-generated method stub
		List<Project> list = obj.getEmpProjects(project, id);
		return list;
	}

	@Override
	public List<Project> displayAllProjects(Project p) {
		// TODO Auto-generated method stub
		List<Project> list = obj.displayAllProjects(p);
		return list;
	}

}
