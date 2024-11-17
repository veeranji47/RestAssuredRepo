package com.sample.crud.withoutbddtest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeleteProjectFromHRM {
	@Test
	public void getProject() {
		 delete("http://49.249.28.218:8091/project/NH_PROJ_5949").then().log().all();
	}
}
