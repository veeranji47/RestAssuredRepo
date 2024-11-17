package com.sample.assertions;


import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;



public class VerifyResponseTime {
	
	@Test
	public void createProjectHRM() {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Pavan");
		obj.put("status", "Created");
		obj.put("teamSize", 0);
		obj.put("projectName", "Mangxsdfsdfsdsfsddsdnmncvko123");
		
		Response res = given().contentType(ContentType.JSON).body(obj.toJSONString()).
		when().post("http://49.249.28.218:8091/addProject");
		res.then().assertThat().time(Matchers.greaterThan(300L));
		res.then().assertThat().time(Matchers.lessThan(900L));
		res.then().assertThat().time(Matchers.both(Matchers.greaterThan(300L)).and(Matchers.lessThan(900L)));
		
//		long time = res.time();
//		System.out.println(time);
		res.then().assertThat().statusCode(201).log().all();
		//"http://49.249.28.218:8091/addProject")
	}

}
