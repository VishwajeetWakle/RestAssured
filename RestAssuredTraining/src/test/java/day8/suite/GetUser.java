package day8.suite;


import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {
	
	
	@Test
	void getUser(ITestContext context) {
		
		int id = (Integer) context.getSuite().getAttribute("userId");
		String token = (String)context.getSuite().getAttribute("token");
		 
		
		given()
			.headers("Authorization", "Bearer "+token)
			.pathParam("id", id)
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200)
			.log().all();
	}

}
