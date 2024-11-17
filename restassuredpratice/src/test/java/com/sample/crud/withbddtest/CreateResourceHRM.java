package com.sample.crud.withbddtest;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;



public class CreateResourceHRM {
	
	@Test
	public void createProjectHRM() {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Pavan");
		obj.put("status", "Created");
		obj.put("teamSize", 0);
		obj.put("projectName", "Mango123");
		
		given().contentType(ContentType.JSON).body(obj.toJSONString()).
		when().post("http://49.249.28.218:8091/addProject").
		then().assertThat().statusCode(201).log().all();
		//"http://49.249.28.218:8091/addProject")
	}

}
