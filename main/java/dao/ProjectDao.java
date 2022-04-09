package dao;

import java.util.List;

import model.Project;

public interface ProjectDao {
	/**
	 * 
	 * @param project
	 */
	public void newProject(Project project);

	/**
	 * 
	 * @return
	 */
	public List<Project> displayProject(Project p);

	/**
	 * 
	 * @param project
	 * @return
	 */
	public List<Project> projectDetails(Project project);

	public List<Project> getEmpProjects(Project project, int id);

	public List<Project> displayAllProjects(Project p);

}
