package com.sample.crud.withbddtest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class getResourceHRM {
	
	@Test
	public void getProject() {
		 given().get("http://49.249.28.218:8091/project/NH_PROJ_5988").then().assertThat().statusCode(200).log().all();
	}

}
