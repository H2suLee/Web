package co.edu.prj.dept;

public class DeptVO {
	private String deptId, deptName;

	public DeptVO() {
		super();
	}

	public DeptVO(String deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
