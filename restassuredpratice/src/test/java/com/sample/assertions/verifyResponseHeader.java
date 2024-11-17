package com.sample.assertions;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class verifyResponseHeader {
	
	@Test
	public void getProject() {
		 Response res = given().get("http://49.249.28.218:8091/project/NH_PROJ_5988");
		 res.then().assertThat().contentType(ContentType.JSON);
		 res.then().assertThat().statusCode(200);
		 res.then().assertThat().statusLine("HTTP/1.1 200 ");
		 res.then().assertThat().header("Transfer-Encoding", "chunked");
		 res.then().assertThat().log().all();
		 
	}

}
