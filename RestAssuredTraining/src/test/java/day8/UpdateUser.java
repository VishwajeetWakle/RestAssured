package day8;


import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {
	
	
	@Test
	void updateUser(ITestContext context) {
		int id = (int) context.getAttribute("userId");
		Faker faker = new Faker();
		JSONObject data = new JSONObject();
		
		 int ramdomN = faker.number().numberBetween(0, 1);
		    String sex;
		    if (ramdomN == 0) {
		        sex = "Male";
		    } else {
		        sex = "Female";
		    }
		data.put("gender", sex);
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		
		String token = (String)context.getAttribute("token");
		
		given()
			.headers("Authorization", "Bearer "+token)
			.contentType("application/json")
			.pathParam("id", id)
			.body(data.toString())
		.when()
			.put("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200)
			.log().all();
			
	}

}
