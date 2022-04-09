package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Project;
import utility.MyConnection;

public class ProjectDaoImpl implements ProjectDao {

	Connection conn = null;
	Project project = null;

	public ProjectDaoImpl() {
		try {
			conn = MyConnection.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void newProject(Project project) {
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("insert into project(project_name,project_status) values(?,?)");
			pstmt.setString(1, project.getProjectName());
			pstmt.setString(2, project.getProjectStatus());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Project> displayProject(Project p) {

		List<Project> list = new ArrayList<Project>();
		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from project where project_status=?");
			pstmt.setString(1, p.getProjectStatus());

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				project = new Project();
				project.setProjectId(rs.getInt("project_id"));
				project.setProjectName(rs.getString("project_name"));
				project.setProjectStatus(rs.getString("project_status"));

				list.add(project);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Project> projectDetails(Project project) {
		// TODO Auto-generated method stub
		List<Project> list = new ArrayList<Project>();
		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from project where project_id=?");
			pstmt.setInt(1, project.getProjectId());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				project = new Project();
				project.setProjectId(rs.getInt("project_id"));
				project.setProjectName(rs.getString("project_name"));
				project.setProjectStatus(rs.getString("project_status"));
				list.add(project);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Project> getEmpProjects(Project project, int id) {
		// TODO Auto-generated method stub
		List<Project> list = new ArrayList<Project>();

		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from project where project_status=? and "
					+ "project_id IN(select project_id from pe_mapping where user_id IN(select user_id from user where user_id=?))");
			pstmt.setString(1, project.getProjectStatus());
			pstmt.setInt(2, id);

			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				project = new Project();
				project.setProjectId(res.getInt("project_id"));
				project.setProjectName(res.getString("project_name"));
				project.setProjectStatus(res.getString("project_status"));
				list.add(project);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Project> displayAllProjects(Project p) {

		System.out.println("Method start");
		// TODO Auto-generated method stub
		List<Project> list = new ArrayList<Project>();
		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from project");
//			pstmt.setString(1, p.getProjectStatus());
			// System.out.println("status:" + p.getProjectStatus());
			// pstmt.setInt(1, project.getProjectId());

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				project = new Project();
				project.setProjectId(rs.getInt("project_id"));
				project.setProjectName(rs.getString("project_name"));
				project.setProjectStatus(rs.getString("project_status"));

				list.add(project);
				// System.out.println(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
