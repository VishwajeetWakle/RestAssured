package test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class AssignmentFirst {

	
	@Test
    public void assignmentFirst() {
        
        RestAssured.baseURI = "https://restcountries.com/v2";
       
        Response res = RestAssured.get("/name/INDIA");
        
        String responseBody = res.getBody().asString();
        
        System.out.println(responseBody);
        
        if (responseBody.contains("Republic of India")) {
            System.out.println("Response : Republic of India");
        } else {
            System.out.println("The response is not Republic of India");
        }
        
        res = RestAssured.get("/name/xyz");
        
        responseBody = res.getBody().asString();
        
        System.out.println(responseBody);
        
        if (responseBody.contains("{\"status\":404,\"message\":\"Not Found\"}")) {
            System.out.println("Response having the expected error message.");
        } else {
            System.out.println("Response not having the expected error message.");
        }
    }
}

