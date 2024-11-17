package pratice.serializationanddeserailization;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

class Project1 {
	String projectName;
	String status;
	List<String> teamMembers;
	String Projectmanager[];

	public Project1(String projectName, String status, List<String> teamMembers,String Projectmanager[]) {

		this.projectName = projectName;
		this.status = status;
		this.teamMembers = teamMembers;
		this.Projectmanager=Projectmanager;
		this.projM = projM;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setTeamMembers(List<String> teamMembers) {
		this.teamMembers = teamMembers;
	}

	public List<String> getTeamMembers() {
		return teamMembers;
	}

	public List<ProjectManager> getProjM() {
		return projM;
	}

	public void setProjM(List<ProjectManager> projM) {
		this.projM = projM;
	}

}

class ProjectManager {

	String name;
	String id;

	public ProjectManager(String name, String id) {

		this.name = name;
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}

public class POJOSerialization {

	public static void main(String[] args) throws Exception, Exception, Exception {
		
		
		List<String> lst = new ArrayList<String>();
		lst.add("veera");
		lst.add("Ashok");
		lst.add("Pavan");
		
		ProjectManager pm = new ProjectManager("sgdhgs", "1144");
		
		 String Projectmanager[]= {"abc","bcd"};
		
		
		Project1 po= new Project1("a", "b", lst, Projectmanager);
		ObjectMapper objM = new ObjectMapper();
		objM.writeValue(new File("./jackson.json"), pobj);
		
		System.out.println("----------End---------------");

	}

}
