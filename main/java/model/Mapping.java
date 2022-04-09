package model;

public class Mapping {

	private int empID;
	private int projectID;
	private int mappingID;

	public Mapping(int empID, int projectID, int mappingID) {
		super();
		this.empID = empID;
		this.projectID = projectID;
		this.mappingID = mappingID;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public int getMappingID() {
		return mappingID;
	}

	public void setMappingID(int mappingID) {
		this.mappingID = mappingID;
	}

	@Override
	public String toString() {
		return "Mapping [empID=" + empID + ", projectID=" + projectID + ", mappingID=" + mappingID + "]";
	}
}
