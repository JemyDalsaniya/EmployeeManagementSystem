package service;

import java.util.List;
import java.util.Map;

import model.Employee;

public interface UserServiceDao {

	public boolean compareLoginDetails(Employee emp);

	public void addUser(Employee emp);

	public void userUpdate(Employee emp);

	public void validateUserDetails(Employee emp, Map<String, String> message);

	public List<Employee> displayUser(Employee emp);

	public void assignEmployee(String[] employee, String projectId);

	public List<Employee> getWorkingEmployee(String projectId, String status, Employee emp);

	void completedProject(String ProjectId);

}
