package test;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;
import steps.AssignmentThirdStpes;

public class AssignmentThird1 {
	
	@Steps
	static AssignmentThirdStpes steps;
	
	@Test
    public void assignmentThird() {
		      
        RestAssured.baseURI = "http://restapi.demoqa.com/customer";
      
        Response res = RestAssured.given()
        		.contentType("application/json")
        		.queryParam("FirstName","Abc")
                .queryParam("LastName","XYZ")
                .queryParam("UserName","abcxyz")
                .queryParam("Password","abc@123")
                .queryParam("Email","abc@mail.com")
                .when().post("/register");
        
        System.out.println("The response status is "+res.getStatusCode());
        
        steps.validateStatusCode(res, 201);
        
        steps.validateRespose(res, "Operation completed successfully");
        
        steps.validateStatusCode(res, 200);
        
        steps.validateRespose(res, "FAULT_USER_ALREADY_EXISTS");
       
    }

}