package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AssignmentSecond {
	
	@Test
    public void assignmentSecond(){
        
        RestAssured.baseURI = "https://restcountries.com/v2";
         
        Response res = RestAssured.get("/name/norway");
        
        String responseBody = res.getBody().asString();
         
        if (responseBody.contains("\"capital\":\"Oslo\"")) {
            System.out.println("Norway's capital is Oslo.");
        } else {
            System.out.println("Norway's captial is not Oslo.");
        }
        
        responseBody = res.getBody().asPrettyString();
        
        System.out.println("The Details of Norway");
        System.out.println(responseBody);
    }
}