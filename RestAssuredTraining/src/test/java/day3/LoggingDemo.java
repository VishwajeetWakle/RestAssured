package day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;


public class LoggingDemo {

	@Test
	void testLogs() {
		
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
//			.log().all()
//			.log().body()
//			.log().cookies()
			.log().headers();
	}
}
