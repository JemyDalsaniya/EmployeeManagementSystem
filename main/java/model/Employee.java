package model;

public class Employee {

	private int empId;
	private String empName;
	private String empEmail;
	private String empPassword;
	private String empContact;
	private Boolean empStatus;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpContact() {
		return empContact;
	}

	public void setEmpContact(String empContact) {
		this.empContact = empContact;
	}

	public Boolean getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(Boolean empStatus) {
		this.empStatus = empStatus;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empPassword="
				+ empPassword + ", empContact=" + empContact + ", empStatus=" + empStatus + "]";
	}
}
