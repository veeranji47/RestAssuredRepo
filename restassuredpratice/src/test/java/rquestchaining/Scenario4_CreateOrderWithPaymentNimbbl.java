package rquestchaining;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.utility.POJOHRMApplication;

import static io.restassured.RestAssured.*;

import java.util.LinkedHashMap;
import java.util.Random;

public class Scenario4_CreateOrderWithPaymentNimbbl {
	
	@Test
	public void deleteEmployee() {
		
		String BaseUrl = "https://api.nimbbl.tech";
		
		String access_key = "access_key_pKx7rWVgVpbXQvq2";
		String access_secret = "access_secret_DX3w55VKAkXbx7aB";
		
		String authorizationReqBody = "{\"access_key\":\""+access_key+"\",\"access_secret\":\""+access_secret+"}";
		Response res = given().contentType(ContentType.JSON).body(authorizationReqBody).
		when().post("/api/v3/generate-token");
		res.then().log().all();
		
		String bearerToken = res.jsonPath().get("token");
		
		
		String invoiceId = "Inv"+new Random().nextInt();
		String createOrder = "{\r\n"
				+ "  \"amount_before_tax\": 2100,\r\n"
				+ "  \"tax\": 105,\r\n"
				+ "  \"total_amount\": 2205,\r\n"
				+ "  \"user\": {\r\n"
				+ "    \"email\": \"wonderwoman@themyscira.gov\",\r\n"
				+ "    \"first_name\": \"Diana\",\r\n"
				+ "    \"last_name\": \"Prince\",\r\n"
				+ "    \"country_code\": \"+91\",\r\n"
				+ "    \"mobile_number\": \"9876543210\"\r\n"
				+ "  },\r\n"
				+ "  \"shipping_address\": {\r\n"
				+ "    \"address_1\": \"1080 Beach Mansion\",\r\n"
				+ "    \"street\": \"Magic Beach Drive\",\r\n"
				+ "    \"landmark\": \"Opposite Magic Mountain\",\r\n"
				+ "    \"area\": \"Elyria\",\r\n"
				+ "    \"city\": \"Atlantis\",\r\n"
				+ "    \"state\": \"Castalia\",\r\n"
				+ "    \"pincode\": \"100389\",\r\n"
				+ "    \"address_type\": \"Beach House\"\r\n"
				+ "  },\r\n"
				+ "  \"currency\": \"INR\",\r\n"
				+ "  \"invoice_id\": \""+invoiceId+",\r\n"
				+ "  \"referrer_platform\": \"string\",\r\n"
				+ "  \"referrer_platform_version\": \"string\",\r\n"
				+ "  \"ip_address\": \"106.201.232.161\",\r\n"
				+ "  \"merchant_shopfront_domain\": \"https://merchant-shopfront.example.com\",\r\n"
				+ "  \"order_line_items\": [\r\n"
				+ "    {\r\n"
				+ "      \"sku_id\": \"item_2783027490\",\r\n"
				+ "      \"title\": \"Best Sliced Alphonso Mango\",\r\n"
				+ "      \"description\": \"The Alphonso mango is a seasonal fruit harvested from mid-April through the end of June. The time from flowering to harvest is about 90 days, while the time from harvest to ripening is about 15 days.The fruits generally weigh between 150 and 300 grams (5.3 and 10.6 oz), have a rich, creamy, tender texture and delicate, non-fibrous, juicy pulp. As the fruit matures, the skin of an Alphonso mango turns golden-yellow with a tinge of red across the top of the fruit\",\r\n"
				+ "      \"image_url\": \"https://en.wikipedia.org/wiki/Alphonso_mango#/media/File:Alphonso_mango.jpg\",\r\n"
				+ "      \"rate\": 1050,\r\n"
				+ "      \"quantity\": \"2\",\r\n"
				+ "      \"amount_before_tax\": \"2100.00\",\r\n"
				+ "      \"tax\": \"105.00\",\r\n"
				+ "      \"total_amount\": \"2205.00\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"bank_account\": {\r\n"
				+ "    \"account_number\": \"10038849992883\",\r\n"
				+ "    \"name\": \"Diana Prince\",\r\n"
				+ "    \"ifsc\": \"ICIC0000011\"\r\n"
				+ "  },\r\n"
				+ "  \"custom_attributes\": {\r\n"
				+ "    \"name\": \"Diana\",\r\n"
				+ "    \"place\": \"Themyscira\",\r\n"
				+ "    \"animal\": \"Jumpa\",\r\n"
				+ "    \"thing\": \"Tiara\"\r\n"
				+ "  }\r\n"
				+ "}";
		
		Response orderRes = given().header("Authorization", "Bearer" +bearerToken)
		.body(createOrder).contentType(ContentType.JSON).post("/api/v3/create-order");
		
		orderRes.then().log().all();
		
		String orderId = orderRes.jsonPath().get("order_id");
		String userToken = orderRes.jsonPath().get("user.token");
		
		LinkedHashMap<String, String> payment = new LinkedHashMap<String, String>();
		payment.put("Authentication", "Bearer "+bearerToken);
		payment.put("x-nimbbl-user-token", userToken);
		
		String initPay = "{\r\n"
				+ "  \"order_id\": \""+orderId+",\r\n"
				+ "  \"payment_mode_code\": \"pay_later\",\r\n"
				+ "  \"device\": {\r\n"
				+ "    \"accept_header\": \"application/json, text/plain, */*\",\r\n"
				+ "    \"user_agent\": \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36\",\r\n"
				+ "    \"browser_language\": \"en-US\",\r\n"
				+ "    \"browser_javascript_enabled\": true,\r\n"
				+ "    \"browser_java_enabled\": false,\r\n"
				+ "    \"browser\": \"chrome\",\r\n"
				+ "    \"browser_tz\": \"-330\",\r\n"
				+ "    \"browser_color_depth\": \"24\",\r\n"
				+ "    \"browser_screen_height\": \"768\",\r\n"
				+ "    \"browser_screen_width\": \"1366\",\r\n"
				+ "    \"fingerprint\": \"d43ae804062e3654e57da1e4a1e66eb5\",\r\n"
				+ "    \"ip_address\": \"106.201.232.161\"\r\n"
				+ "  }\r\n"
				+ "}";
		
		
		
		
	}

}
