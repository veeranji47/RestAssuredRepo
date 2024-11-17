package pratice.complexpostrequest;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class ComplexPostRequestWithJSONObject {

	public static void main(String[] args) {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Pavan");
		obj.put("status", "Created");
		obj.put("teamSize", 0);
		obj.put("projectName", "Mangsfdo123");
		
		given().contentType(ContentType.JSON).body(obj.toJSONString()).
		when().post("http://49.249.28.218:8091/addProject").
		then().assertThat().statusCode(201).log().all();

	}

}
