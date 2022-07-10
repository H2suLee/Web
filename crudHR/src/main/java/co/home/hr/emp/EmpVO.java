package co.home.hr.emp;

public class EmpVO {
	private String employeeId, lastName, email, hireDate, jobId, departmentId;

	public EmpVO() {
		super();
	}

	public EmpVO(String employeeId, String lastName, String email, String hireDate, String jobId, String departmentId) {
		super();
		this.employeeId = employeeId;
		this.lastName = lastName;
		this.email = email;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.departmentId = departmentId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getHireDate() {
		return hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
}
