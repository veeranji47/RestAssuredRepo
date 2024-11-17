package com.sample.crud.withoutbddtest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class getResourceHRM {
	
	@Test
	public void getProject() {
		 get("http://49.249.28.218:8091/projects").then().log().all();
	}

}
