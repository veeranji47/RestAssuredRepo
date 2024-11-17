package com.sample.crud.withoutbddtest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class SimpleTest {
	
	@Test
	public void getPetDetails() {
		System.out.println(RestAssured.get("https://petstore.swagger.io/v2/pet/112233").then().log().all());
	}

}
