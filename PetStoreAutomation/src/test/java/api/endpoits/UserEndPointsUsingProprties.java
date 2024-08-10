package api.endpoits;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// created for perform CURD operations on user api
public class UserEndPointsUsingProprties {
	
	// created for getting url form properties file
	public static ResourceBundle getURL(){
		// loading property file
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}

	public static Response createUser(User payload) {
		
		Response res =
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(getURL().getString("userPostUrl"));
		
		return res;
	}
	

	public static Response readUser(String username) {
		
		Response res =
		given()
			.accept(ContentType.JSON)
			.pathParam("username", username)
		.when()
			.get(getURL().getString("userGetUrl"));
		
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
			.put(getURL().getString("userUpdateUrl"));
		
		return res;
	}
	
	

	public static Response deleteUser(String username) {
		
		Response res =
		given()
			.accept(ContentType.JSON)
			.pathParam("username", username)
		.when()
			.delete(getURL().getString("userDeleteUrl"));
		
		return res;
	}
}
