package datadriventesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class AddMultipleProjects {
	
	@Test(dataProvider = "getData")
	public void sampleTest(String prjName,String status, String createdBy, String size) {
		
		
		System.out.println(prjName + "\t" + status + "\t" + createdBy + "\t" +size);
		
//		String reqBody = "{\r\n"
//				+ "  \"projectName\": \""+prjName+"\",\r\n"
//				+ "  \"createdBy\": \""+createdBy+"\",\r\n"
//				+ "  \"teamSize\": "+size+"\r\n"
//				+ "  \"status\": \""+status+"\",\r\n"
//				+ "}";
//		Response res = given().contentType(ContentType.JSON).body(reqBody).
//		when().post("http://49.249.28.218:8091/addProject");
		
		//res.then().log().all();
		System.out.println();
		System.out.println("--------------------------------------------------");
		System.out.println();
	}
	
	String excelPath = "./example.xlsx";
	
	@DataProvider
	public Object[][] getData() {
		ExcelUtility eutil = new ExcelUtility();
		eutil.excelInit(excelPath);
		int rowCount = eutil.getRowCount("Sheet1");
		int colCount = eutil.getColumnCount("Sheet1");
		
		System.out.println(rowCount);
		
		Object[][] obj = new Object[rowCount][colCount];
		for(int i = 0; i<rowCount; i++) {
			
			for(int j = 0; j<colCount; j++) {
				obj[i][j] = eutil.getDataFromExcel("Sheet1", i, j);
			}	
		}
		return obj;
	}

}
