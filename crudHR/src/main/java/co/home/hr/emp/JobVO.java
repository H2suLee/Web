package co.home.hr.emp;

public class JobVO {
	private String jobId, jobTitle;

	public JobVO() {
		super();
	}

	public JobVO(String jobId, String jobTitle) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
	}

	public String getJobId() {
		return jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
}
