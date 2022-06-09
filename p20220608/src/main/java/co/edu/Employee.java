package co.edu;

public class Employee {
	
	// class => 복합적인 데이터를 하나의 변수에 넣을 수 있게 해준다
	// 사원번호, 이름, 이메일, 직무 => 각 필드에 담기
	private int empId;
	private String lastName, email, jobId, hireDate; // hr의 not null 항목 다섯가지
	
	// getter setter
	
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
