package day8.suite;


import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser {
	
	
	@Test
	void deleteUser(ITestContext context) {
		
		String token = (String)context.getSuite().getAttribute("token");
		
		int id = (int) context.getSuite().getAttribute("userId");
		
		given()
			.headers("Authorization", "Bearer "+token)
			.pathParam("id", id)
		.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(204)
			.log().all();
	}

}
