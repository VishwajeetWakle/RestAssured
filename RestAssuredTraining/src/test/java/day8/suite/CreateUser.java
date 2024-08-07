package day8.suite;


import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class CreateUser {
	
	
	@Test
	void testCreateUser(ITestContext context) {
		
		Faker faker = new Faker();
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		 int ramdomN = faker.number().numberBetween(0, 1);
		    String sex;
		    if (ramdomN == 0) {
		        sex = "Male";
		    } else {
		        sex = "Female";
		    }
		data.put("gender", sex);
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String token = "token";
		
		
		Response res =
		
		given()
			.headers("Authorization", "Bearer "+token)
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("https://gorest.co.in/public/v2/users");
			
		
		int id = res.jsonPath().getInt("id");
		Assert.assertEquals(res.getStatusCode(), 201);
		
		System.out.println(id);
		
		context.getSuite().setAttribute("userId", id);
		context.getSuite().setAttribute("token", token);
	}

}
