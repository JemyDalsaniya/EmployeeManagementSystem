package dao;

import java.util.List;

import model.Employee;

public interface UserDAO {

	/**
	 * 
	 * @param emp
	 * @return
	 */
	public boolean userLogin(Employee emp);

	/**
	 * 
	 * @param emp
	 */
	public void userRegister(Employee emp);

	/**
	 * 
	 * @param emp
	 */
	public void userUpdate(Employee emp);

	public List<Employee> displayUser(Employee emp);

	public void assignEmployee(String employee[], String projectId);

	public List<Employee> getWorkingEmployee(String ProjectId, String status, Employee emp);

	public void completedProject(String ProjectId);

	// public List<Employee> getAllEmployee(Employee emp);

}
