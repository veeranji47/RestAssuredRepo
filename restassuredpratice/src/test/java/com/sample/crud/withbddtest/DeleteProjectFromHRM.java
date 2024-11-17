package com.sample.crud.withbddtest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeleteProjectFromHRM {
	@Test
	public void getProject() {
		 given().delete("http://49.249.28.218:8091/project/NH_PROJ_5961")
		 .then().assertThat().statusCode(204).log().all();
	}
}
