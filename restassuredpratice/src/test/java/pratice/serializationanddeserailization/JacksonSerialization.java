package pratice.serializationanddeserailization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Project{
	
	private String projectName;
	private String status;
	private int teamSize;
	private String createdBy;
	public Project() {
		
	}
	public Project(String projectName, String status, int teamSize, String createdBy) {
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

public class JacksonSerialization {

	public static void main(String[] args) throws Exception, Exception, Exception {
		Project pj = new Project("Cloths1234", "On Going", 0, "Chinna");
		
		ObjectMapper objM = new ObjectMapper();
		objM.writeValue(new File("./data.json"), pj);
		System.out.println("------------end-------------");
	}

}
