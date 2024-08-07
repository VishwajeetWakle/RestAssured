package day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo {

	@Test
	void testHeaders() {
		
		given()
		.when()
			.get("https://www.google.com")
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.and()
			.header("Content-Encoding", "gzip")
			.header("Server", "gws")
			.log().headers();
	}
	
	@Test
	void getHeaders() {
		
		Response res = given()
		.when()
			.get("https://www.google.com");
		
		// get single header
		String headerValue = res.getHeader("Content-Type");
		System.out.println(headerValue);
		
		// get all headers 
		Headers allHeaders = res.getHeaders();
		
		for(Header k : allHeaders) {
			System.out.println(k.getName()+"\t"+k.getValue());
		}
	}
}
