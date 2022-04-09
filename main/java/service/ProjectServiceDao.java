package service;

import java.util.List;
import java.util.Map;

import model.Project;

public interface ProjectServiceDao {

	public void addProject(Project project);

	public List<Project> displayProject(Project p);

	public List<Project> displayAllProjects(Project p);

	public void validateProjectDetails(Project project, Map<String, String> messages);

	public List<Project> projectDetails(Project project);

	public List<Project> getEmpProjects(Project project, int id);

}
