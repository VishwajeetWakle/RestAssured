package day4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class ParsingJSONResponseData {

	@Test
	void testJsonRes() {

		// Approch1

		given().contentType(ContentType.JSON).when().get("http://localhost:3000/store").then().statusCode(200).log()
				.all()
				// to find json path of big file use https://jsonpathfinder.com/
				.body("book[2].title", equalTo("Moby Dick"));

		// Approch2
		Response res = given().contentType(ContentType.JSON).when().get("http://localhost:3000/store");

		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.getHeader("Content-Type"), "application/json");
		Assert.assertEquals(res.jsonPath().get("book[2].title").toString(), "Moby Dick");

	}

	@Test
	void testJsonResBodyData() {

		Response res = given().contentType(ContentType.JSON).when().get("http://localhost:3000/store");

		Assert.assertEquals(res.getStatusCode(), 200);

		// JSON Object Class
		JSONObject jo = new JSONObject(res.asString()); // Converting res to json object type
		boolean flag = false;
		for (int i = 0; i < jo.getJSONArray("book").length(); i++) {
			String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println(bookTitle);
			if (bookTitle.equals("Moby Dick")) {
				flag = true;
				break;
			}
		}
		Assert.assertEquals(flag, true);

	}

	@Test
	void validateTotalPrice() {

		double total = 0.0;

		Response res = given().contentType(ContentType.JSON).when().get("http://localhost:3000/store");

		Assert.assertEquals(res.getStatusCode(), 200);

		// JSON Object Class
		JSONObject jo = new JSONObject(res.asString()); // Converting res to json object type
		for (int i = 0; i < jo.getJSONArray("book").length(); i++) {
			String price = jo.getJSONArray("book").getJSONObject(i).get("price").toString();
			System.out.println(price);
			total += Double.parseDouble(price);
		}
		Assert.assertEquals(total, 326.0);
	}
}
