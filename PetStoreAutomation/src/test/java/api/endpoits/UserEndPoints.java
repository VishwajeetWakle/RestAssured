package api.endpoits;

import static io.restassured.RestAssured.given;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// created for perform CURD operations on user api
public class UserEndPoints {

	public static Response createUser(User payload) {
		
		Response res =
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.userPostUrl);
		
		return res;
	}
	

	public static Response readUser(String username) {
		
		Response res =
		given()
			.accept(ContentType.JSON)
			.pathParam("username", username)
		.when()
			.get(Routes.userGetUrl);
		
		return res;
	}
	

	public static Response updateUser(User payload, String username) {
		
		Response res =
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", username)
			.body(payload)
		.when()
			.put(Routes.userUpdateUrl);
		
		return res;
	}
	
	

	public static Response deleteUser(String username) {
		
		Response res =
		given()
			.accept(ContentType.JSON)
			.pathParam("username", username)
		.when()
			.delete(Routes.userDeleteUrl);
		
		return res;
	}
}
