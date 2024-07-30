package test;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;;

public class AssignmentFourth {
	
	@org.junit.Test
    public void assignmentFourth() {
		
		
		// for valid
		String email = "eve.holt@reqres.in";
		String password = "cityslicka";
		      
       RestAssured.given().contentType("application/json")
       .body("{\"email\": \""+email+"\","+
    		   "\"password\":\""+password+"\"}")
       .when().post("https://reqres.in/api/login")
       .then().statusCode(200)
       .and().body("token", equalTo("QpwL5tke4Pnpja7X4"));
   
       
       // for invalid
		String mail = "eve.holt@reqres.in";
	      
	       RestAssured.given().contentType("application/json")
	       .body("{\"email\": \""+mail+"\"}")
	       .when().post("https://reqres.in/api/login")
	       .then().statusCode(400)
	       .and().body(containsString("Missing password"))
	       .and().contentType("application/json") ;
        
       
    }
	
}
