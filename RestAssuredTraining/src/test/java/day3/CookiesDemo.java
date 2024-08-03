package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {

	
	@Test
	void testCookies() {
		
		given()
		.when()
			.get("https://www.google.com")
		.then()
	//		.cookie("AEC", "AVYB7crBuvyjO99Jt6YS9V6-rijn2GNIr3zZZn6vS1MahVT0JmHjzISWGOg")
			.log().all();
	}
	
	@Test
	void getCookiesInfo() {
		
		Response res = 
		given()
		.when()
			.get("https://www.google.com");
		
		// get single cookie info
		String cookieAECValue = res.getCookie("AEC");
		System.out.println(cookieAECValue);
		String cookieNIDValue = res.getCookie("NID");
		System.out.println(cookieNIDValue);
		
		// get all cookies info
		Map<String, String> allCookies = res.getCookies();
		
		for(String k : allCookies.keySet()) {
			System.out.println(k+"\t"+res.getCookie(k));
		}
		
	}
}
