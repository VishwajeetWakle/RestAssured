package day6;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

import static io.restassured.RestAssured.*;

public class XMLSchemaValidation {
	
	
	@Test
	void xmlSchemaValidation() {
		
		given()
		.when()
			.get("https://petstore.swagger.io/v2/swagger.xml")
		.then()
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xml.xsd"));
	}

}
