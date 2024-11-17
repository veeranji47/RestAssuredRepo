package pratice.serializationanddeserailization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonDeSeralization {

	public static void main(String[] args) throws Exception, Exception, Exception {
		ObjectMapper objM = new ObjectMapper();
		
		Project pj = objM.readValue(new File("./data.json"), Project.class);
		
		System.out.println(pj.getCreatedBy());
		System.out.println(pj.getProjectName());
		System.out.println(pj.getTeamSize());
		System.out.println(pj.getStatus());

	}

}
