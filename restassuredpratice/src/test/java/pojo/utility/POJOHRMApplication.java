package pojo.utility;

public class POJOHRMApplication {

	public String projectName;
	public String status;
	public int teamSize;
	public String createdBy;
	
	private POJOHRMApplication() {}
	
	public POJOHRMApplication(String projectName, String status, int teamSize, String createdBy) {
	
		this.projectName = projectName;
		this.status = status;
		this.teamSize = teamSize;
		this.createdBy = createdBy;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
	
	

}
