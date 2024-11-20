package rquestchaining;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import pojo.utility.POJOHRMApplication;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class Scenario3_getPayRollInfo {
	
	@Test
	public void deleteEmployee() {
		 Response res = given().formParam("client_id", "ninza-client")
		.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		.formParam("grant_type", "client_credentials")
		.when().post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		res.then().log().all();
		
		String token = res.jsonPath().get("access_token");
		
		 Response tokenRes = given().auth().oauth2(token).get("http://49.249.28.218:8091/admin/payrolls");
		 
		res.then().
		log().all();
		
		
	}

}
