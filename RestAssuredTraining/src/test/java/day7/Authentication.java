package day7;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Authentication {

	@Test
	void testBasicAuth() {

		given()
			.auth()
			.basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true));
	}

	@Test
	void testDigestAuth() {
		given()
			.auth()
			.digest("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true));
	}

	@Test
	void testPreemptiveAuth() {
		given()
			.auth()
			.preemptive().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true));
	}
	
	@Test
	void testBearerToekenAuth() {
		
		
		String token = "token";
		
		given()
			.headers("Authorization", "Bearer "+token)
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	
	@Test
	void testOAuth1() { // OAuth 1.0
		
		given()
			.auth().oauth("consumerKey", "consumerSecrate", "accessToken", "tokenSecrate")
		.when()
			.get("url")
		.then()
			.statusCode(200);
	}
	
	
	@Test
	void testOAuth2() {		// OAuth 2.0
		
		given()
			.auth().oauth2("token")
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200);
	}
	
	
	@Test
	void testAPIKeyAuth() {
		
		given()
			.pathParam("myapp", "data/2.5/weather")
			.queryParam("lat", 18.548848)
			.queryParam("lon", 73.866116)
			.queryParam("appid", "yourAPIKey") // appid is a APIKey		
		.when()
			.get("https://api.openweathermap.org/{myapp}")
		.then()
			.statusCode(200)
			.log().all();
		
	}
}
