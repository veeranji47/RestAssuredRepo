package com.sample.crud.withbddtest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class updateCompleteHRMProject {
	
	@Test
	public void updateCompleteProjectInHRM() {
		
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Veera1");
		obj.put("status", "Created");
		obj.put("teamSize", 0);
		obj.put("projectName", "Oranges222");
		
		given().contentType(ContentType.JSON).body(obj.toJSONString()).	
		when().put("http://49.249.28.218:8091/project/NH_PROJ_5961").
		then().assertThat().statusCode(200).log().all();
	}

}
