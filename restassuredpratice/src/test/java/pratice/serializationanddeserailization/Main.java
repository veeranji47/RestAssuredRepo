

package pratice.serializationanddeserailization;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) throws Exception, Exception, Exception {
        FruitsProject.ProjectManager manager1 = new FruitsProject.ProjectManager("Lakshmi", "MSC001");
        FruitsProject.ProjectManager manager2 = new FruitsProject.ProjectManager("Kavitha", "MSC100");

        List<FruitsProject.ProjectManager> projectManagers = Arrays.asList(manager1, manager2);
        List<String> teamMembers = Arrays.asList("Veera", "Ashok", "Pavan", "Sai");

        FruitsProject project = new FruitsProject("Fruits", "On Going", teamMembers, projectManagers);

        ObjectMapper obj = new ObjectMapper();
        obj.writeValue(new File("./hgj.json"), project);
    }
}

class FruitsProject {

    private String projectName;
    private String status;
    private List<String> teamMembers;
    private List<ProjectManager> projectManagers;

    public FruitsProject(String projectName, String status, List<String> teamMembers, List<ProjectManager> projectManagers) {
        this.projectName = projectName;
        this.status = status;
        this.teamMembers = teamMembers;
        this.projectManagers = projectManagers;
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

    public List<String> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<String> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public List<ProjectManager> getProjectManagers() {
        return projectManagers;
    }

    public void setProjectManagers(List<ProjectManager> projectManagers) {
        this.projectManagers = projectManagers;
    }

    public static class ProjectManager {
        private String name;
        private String id;

        public ProjectManager(String name, String id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "ProjectManager{" +
                    "name='" + name + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }}}

    
