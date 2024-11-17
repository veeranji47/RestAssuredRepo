package pratice.complexpostrequest;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class ComplexPostRequestWithPOJO {

	public static void main(String[] args) throws Exception {
		
		
		given().contentType(ContentType.JSON).body(fileObj).
		when().post("http://49.249.28.218:8091/addProject").
		then().assertThat().statusCode(201).log().all();

	}

}


