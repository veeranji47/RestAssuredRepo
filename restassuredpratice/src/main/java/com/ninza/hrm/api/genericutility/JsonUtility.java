package com.ninza.hrm.api.genericutility;

import java.util.List;

import com.jayway.jsonpath.JsonPath;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

/**
 * 
 * @author Veera
 *
 */
public class JsonUtility {
/**
 * get the Jsondata from based on json complex xpath
 * @param resp
 * @param jsonXpath
 * @return
 */
	public String getDataOnJsonPath(Response resp,String jsonXpath) {
		List<Object>list= JsonPath.read(resp.asString(),jsonXpath);
		return list.get(0).toString();
	}
	
	/**
	 * get the xmldata from based on xml complex xpath
	 * @param resp
	 * @param xmlXpath
	 * @return
	 */
	public String getDataOnXpathPath(Response resp,String xmlXpath) {
		return resp.xmlPath().get(xmlXpath);
	}
	/**
	 * verify the data in jsonbody based jsonpath
	 * @param resp
	 * @param jsonXpath
	 * @param expectedData
	 * @return
	 */
	public boolean verifyDataOnJsonPath(Response resp,String jsonXpath,String expectedData) {
		List<String>list= JsonPath.read(resp.asString(),jsonXpath);
		boolean flag=false;
		for(String str:list) {
			if(str.equals(expectedData)) {
				System.out.println(expectedData+" is available==PASS");
				flag=true;
			}
		}
		if(flag==false) {
			System.out.println(expectedData+" is available==FAIL");
		}
			return flag;
	}
	public String getAccessToken() {
		Response resp=given()
			.formParam("client_id", "ninza-client")
			.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
			.formParam("grant_type", "client_credentials")

		.when()
			.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		resp.then()
			.log().all();
		//capture data from the response
		String access_token=resp.jsonPath().get("access_token");
		return access_token;
	}
}