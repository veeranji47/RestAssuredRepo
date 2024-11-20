package ninza.hrm.api.employetest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import pojo.utility.POJOHRMApplication;

import org.testng.annotations.Test;

public class CheckingDbInDatabaseTest {
	
	@Test
	public void createProjectCheckDB() throws SQLException {
		Random ranNum = new Random();
		int num = ranNum.nextInt();
		
		String expMsg = "Successfully Added";
		String prjName = "ABB_"+num;
		
		POJOHRMApplication pojo = new POJOHRMApplication(prjName, "Ongoing", 0, "Ahmad");
		Response res = given().contentType(ContentType.JSON).body(pojo).
		when().post("http://49.249.28.218:8091/addProject");
		res.then().log().all();
		
		String actMsg = res.jsonPath().get("msg");
		Assert.assertEquals(expMsg,actMsg );
		
		boolean flag = false;		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm","root","root");
		ResultSet result = connection.createStatement().executeQuery("select * from project");
		while(result.next()) {
			if(result.getString(4).equals(prjName)) {
				flag = true;
				break;
			}
		}
		
		connection.close();
		Assert.assertTrue(flag, "project is not added into database");
	
	}

}
