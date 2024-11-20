package rquestchaining;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.utility.AddEmployeePOJO;
import pojo.utility.POJOHRMApplication;


import java.util.Random;

public class Scenario2_AddEmployeeProject {
	
	@Test
	public void deleteEmployee() {
		//create an object to POJO class
		Random ranNum = new Random();
		int num = ranNum.nextInt(5000);
		
		POJOHRMApplication pobj = new POJOHRMApplication("IQOO"+num, "Created", 0, "Veera");
		
		Response res = given().contentType(ContentType.JSON).body(pobj).
		when().post("http://49.249.28.218:8091/addProject");
		
		String projName = res.jsonPath().get("projectName");
		String projId = res.jsonPath().get("projectId");
		
		
		//API -- 1 ==> add a project into the server
		AddEmployeePOJO emp = new AddEmployeePOJO("Automation", "30/08/1998", "veera@gmail.com", 
				"Veera"+num, 3.5, "9988774455", projName, "ROLE_EMPLOYEE", "Veera"+num);
	
		Response empRes = given().contentType(ContentType.JSON).body(emp).
		when().post("http://49.249.28.218:8091/employees");
		empRes.then().assertThat().statusCode(201);
		empRes.then().log().all();
		
	}

}
