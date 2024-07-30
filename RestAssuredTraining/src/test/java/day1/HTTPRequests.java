package day1;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
public class HTTPRequests {
	
	int id;
	
	@Test(priority = 3, dependsOnMethods = "createUser")
	void getUser() {
		System.out.println("Id in get User "+id);
		given()
		
		.when()
			.get("https://reqres.in/api/users/"+id)
		
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	
	@Test(priority = 1)
	void createUser() {
		
		HashMap map = new HashMap();
		
		map.put("name", "demo");
		map.put("job", "trainer");
		
		id = given()
			.contentType("application/json")
			.body(map)
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id")
			;/*
		.then()
			.statusCode(201)
			.body("name", equalTo("demo"))
			.log().all(); 
			*/
		
		System.out.println("Id in create User "+id);
	}

	
	@Test(priority = 2, dependsOnMethods = "createUser")
	void updateUser() {
		System.out.println("Id in update User "+id);
		HashMap map = new HashMap();
		map.put("name", "updated");
		map.put("email", "demo@gmail.com");
		
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.put("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(200)
			.log().all();
		
	
	}
	
	@Test(priority = 4, dependsOnMethods = "updateUser")
	void deleteUser(){
		System.out.println("Id in delete User "+id);
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(204)
			.log().all();
		
		
	}
}
