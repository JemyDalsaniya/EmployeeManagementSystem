package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.Project;
import utility.MyConnection;

public class UserDaoImpl implements UserDAO {

	Connection conn;
	Project project = new Project();

	public UserDaoImpl() {
		try {
			conn = MyConnection.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void userRegister(Employee emp) {
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("insert into user(name,email,password,contact,isAdmin)values(?,?,?,?,0)");
			pstmt.setString(1, emp.getEmpName());
			pstmt.setString(2, emp.getEmpEmail());
			pstmt.setString(3, emp.getEmpPassword());
			pstmt.setString(4, emp.getEmpContact());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean userLogin(Employee emp) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from user where email=? and password = ?");
			pstmt.setString(1, emp.getEmpEmail());
			pstmt.setString(2, emp.getEmpPassword());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				boolean status = rs.getBoolean(6);
				emp.setEmpStatus(status);
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setEmpPassword(rs.getString(4));
				emp.setEmpContact(rs.getString(5));

				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void userUpdate(Employee emp) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement pstmt = conn
					.prepareStatement("UPDATE user SET name = ?,password =?,contact =? WHERE email = ?");

			pstmt.setString(1, emp.getEmpName());
			pstmt.setString(2, emp.getEmpPassword());
			pstmt.setString(3, emp.getEmpContact());
			pstmt.setString(4, emp.getEmpEmail());
			pstmt.executeUpdate();
			System.out.println("updated successfully..");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Employee> displayUser(Employee emp) {
		// TODO Auto-generated method stub

		List<Employee> list = new ArrayList<Employee>();
		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from user where isAdmin=0");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getInt("user_id"));
				emp.setEmpName(rs.getString("name"));
				list.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void assignEmployee(String[] employee, String projectId) {
		// TODO Auto-generated method stub
		try {
			for (int i = 0; i < employee.length; i++) {
				PreparedStatement stmt = conn
						.prepareStatement("insert into pe_mapping (user_id,project_id) values(?,?)");
				stmt.setString(1, employee[i]);
				stmt.setString(2, projectId);

				stmt.executeUpdate();
			}
			PreparedStatement pstmt = conn
					.prepareStatement("UPDATE project SET project_status='ongoing' WHERE project_id=?");
			pstmt.setString(1, projectId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Employee> getWorkingEmployee(String ProjectId, String status, Employee emp) {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<Employee>();
		if (status.equals("ongoing")) {
			try {
				PreparedStatement pstmt = conn.prepareStatement(
						"select * from user where user_id IN(select user_id from pe_mapping where project_id= ?)");
				pstmt.setString(1, ProjectId);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					emp = new Employee();
					emp.setEmpId(rs.getInt("user_id"));
					emp.setEmpName(rs.getString("name"));
					list.add(emp);
					System.out.println("print list:" + list);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (status.equals("completed")) {
			try {
				PreparedStatement pstmt = conn.prepareStatement(
						"select * from user where user_id IN(select user_id from pe_mapping where project_id= ?)");
				pstmt.setString(1, ProjectId);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					emp = new Employee();
					emp.setEmpId(rs.getInt("user_id"));
					emp.setEmpName(rs.getString("name"));
					list.add(emp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void completedProject(String ProjectId) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement("UPDATE project SET project_status='completed' WHERE project_id=?");
			pstmt.setString(1, ProjectId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/*
	 * @Override public List<Employee> getAllEmployee(Employee emp) { // TODO
	 * Auto-generated method stub List<Employee> list = new ArrayList<Employee>();
	 * try { PreparedStatement stmt =
	 * conn.prepareStatement("select * from user where is_admin=0 "); ResultSet res
	 * = stmt.executeQuery(); while (res.next()) { emp = new Employee();
	 * emp.setEmpId(res.getInt("user_id")); emp.setEmpName(res.getString("name"));
	 * list.add(emp); } } catch (SQLException e) { e.printStackTrace(); } return
	 * list; }
	 */
}
