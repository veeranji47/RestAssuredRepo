package com.sample.assertions;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.List;

public class VerifyResponseBodyTest {
	
	@Test
	public void verifyResponseBody() {
		
		Response res = given().contentType(ContentType.JSON).get("http://49.249.28.218:8091/projects-paginated");
//		int data =  res.jsonPath().get("numberOfElements");
//		 boolean data1 =  res.jsonPath().get("empty");
		//res.then().assertThat().log().all();
		
		List<String> data = JsonPath.read(res.asString(), "content[*].projectId");
		for(String d : data)
			System.out.println(d);
//		System.out.println(data1);
	}

}
