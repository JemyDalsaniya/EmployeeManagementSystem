package service;

import java.util.List;
import java.util.Map;

import dao.UserDaoImpl;
import model.Employee;

public class UserService implements UserServiceDao {
	UserDaoImpl object = new UserDaoImpl();

	@Override
	public boolean compareLoginDetails(Employee emp) {
		boolean obj = object.userLogin(emp);
		return obj;
	}

	@Override
	public void addUser(Employee emp) {
		object.userRegister(emp);
	}

	@Override
	public void userUpdate(Employee emp) {
		object.userUpdate(emp);
	}

	@Override
	public void validateUserDetails(Employee emp, Map<String, String> messages) {
		// TODO Auto-generated method stub

		if (emp.getEmpName() == null || emp.getEmpName().trim().isEmpty()) {
			messages.put("name", "Please enter Name!!");
		} else if (!emp.getEmpName().matches("^[a-zA-Z\\s]*$")) {
			messages.put("name", "Please enter alphabets only!!");
		}

		if (emp.getEmpEmail() == null || emp.getEmpEmail().trim().isEmpty()) {
			messages.put("email", "Please enter Email!!");
		} else if (!emp.getEmpEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
			messages.put("email", "Please enter valid emailId!!");
		}

		if (emp.getEmpPassword() == null || emp.getEmpPassword().trim().isEmpty()) {
			messages.put("password", "Please enter password!!");
		} else if (!emp.getEmpPassword()
				.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$")) {
			messages.put("password", "Please enter valid password!!");
		}

		if (emp.getEmpContact() == null || emp.getEmpContact().trim().isEmpty()) {
			messages.put("contact", "Please enter contact!!");
		} else if (!emp.getEmpContact().matches("^[0-9]{10}$")) {
			messages.put("contact", "Please enter valid Contact!!");
		}

//		if (messages.isEmpty()) {
//			messages.put("success", "Registered Successfully!!");
//
//		}
	}

	@Override
	public List<Employee> displayUser(Employee emp) {
		List<Employee> list = object.displayUser(emp);
		return list;

	}

	@Override
	public void assignEmployee(String[] employee, String projectId) {
		object.assignEmployee(employee, projectId);
	}

	@Override
	public List<Employee> getWorkingEmployee(String projectId, String status, Employee emp) {
		// TODO Auto-generated method stub
		List<Employee> list = object.getWorkingEmployee(projectId, status, emp);
		return list;
	}

	@Override
	public void completedProject(String project_id) {
		// TODO Auto-generated method stub
		object.completedProject(project_id);

	}

}
