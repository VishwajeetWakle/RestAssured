package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class GetAndPostExamples {

//	@Test
	public void testGet() {
		
		baseURI="https://reqres.in/api";
		
		given()
		.get("/users?page=2")
		.then()
		.statusCode(200)
		.body("data[3].first_name", equalTo("Byron"))
		.body("data.first_name", hasItems("Byron", "Byron", "Rachel"));
	}
	
	
	
	@Test
	public void testPost() {
/*			
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", "Raghav");
		map.put("Job", "Teacher");
		System.out.println(map);
		JSONObject request = new JSONObject(map);
		System.out.println(request);
*/	
		JSONObject request = new JSONObject();
		request.put("name", "Raghav");
		request.put("Job", "Teacher");
		System.out.println(request);
		
		baseURI="https://reqres.in/api";
		
		given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post("/users")
		.then()
		.statusCode(201)
		.log()
		.all();
		
	}
	
}