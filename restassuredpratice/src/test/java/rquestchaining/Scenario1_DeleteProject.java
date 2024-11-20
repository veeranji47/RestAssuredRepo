package rquestchaining;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.utility.POJOHRMApplication;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class Scenario1_DeleteProject {
	
	@Test
	public void deleteEmployee() {
		//create an object to POJO class
		Random ranNum = new Random();
		int num = ranNum.nextInt(5000);
		
		//API -- 1 ==> add a project into the server
		POJOHRMApplication pobj = new POJOHRMApplication("TV's Business"+num, "Completed", 0, "Chandra");
		
		Response res = given().contentType(ContentType.JSON).body(pobj).
		when().post("http://49.249.28.218:8091/addProject");
		String actPrjId = res.jsonPath().get("projectId");
		res.then().log().all();
		
		given().delete("http://49.249.28.218:8091/project/" + actPrjId).then().
		assertThat().statusCode(204).log().all();
	}

}
