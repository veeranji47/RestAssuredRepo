package com.sample.crud.withoutbddtest;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;



public class createResourceHRM {
	
	@Test
	public void createProjectHRM() {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Ashok");
		obj.put("status", "Created");
		obj.put("teamSize", 0);
		obj.put("projectName", "Oranmncbkjnzxges");
		
		
		
		RequestSpecification preReq = given().
		contentType(ContentType.JSON)
		.body(obj.toJSONString());
		
		Response res =preReq.post("http://49.249.28.218:8091/addProject");
		res.then().assertThat().statusCode(201);	
		res.then().log().all();
	}

}
