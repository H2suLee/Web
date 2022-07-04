package co.edu.prj;

public class EmpVO {
	private String employeeId, firstName, salary;
	
	// 인수가 있는 생성자를 만들면 인수가 없는 기본생성자도 반드시 만들어야 한다
	public EmpVO() {
		super();
	}

	public EmpVO(String employeeId, String firstName, String salary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.salary = salary;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}	
}
