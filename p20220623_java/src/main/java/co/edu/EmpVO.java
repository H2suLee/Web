// me version

package co.edu;

// 사원 한 명이 갖고있는 정보

public class EmpVO {
	// hr의 notnull 항목 다섯가지
	private int empId;
	private String lastName, email, jobId, hireDate;
	
	public int getEmpId() {
		return empId;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getJobId() {
		return jobId;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
}
