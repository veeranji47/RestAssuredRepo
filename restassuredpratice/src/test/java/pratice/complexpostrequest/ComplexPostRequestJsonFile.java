package pratice.complexpostrequest;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class ComplexPostRequestJsonFile {

	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("createdBy", "Pavan");
		map.put("status", "Created");
		map.put("teamSize", 0);
		map.put("projectName", "Mangsfdo12345");
		
		given().contentType(ContentType.JSON).body(map).
		when().post("http://49.249.28.218:8091/addProject").
		then().assertThat().statusCode(201).log().all();

	}

}
