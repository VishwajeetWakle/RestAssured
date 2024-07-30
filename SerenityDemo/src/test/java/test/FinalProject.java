package test;

import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FinalProject {
	

	@org.junit.Test
    public void finalFirst() {
		
		
		// https://restcountries.eu/rest/v2/alpha/co2
		String url ="https://restcountries.com/v2/alpha/co";
		      
       RestAssured.given().when().get(url)
       .then().statusCode(200)
       .and().body("name", equalTo("Colombia"))
       .and().body("population", equalTo(50339443))
       .and().body("region", equalTo("Americas"))
       .and().body("subregion", equalTo("South America"));
   
	}
	

	@org.junit.Test
    public void finalSecond() {
		
		
		// https://restcountries.eu/rest/v2/alpha/co2
		String url ="https://restcountries.com/v2/currency/cop";
		      
      String currency = RestAssured.given().when().get(url)
       .then().statusCode(200)
       .extract().path("currencies[0].code");
   
      
      if (currency.equals("COP")) {
		System.out.println("Test Pass");
	}
	}
	
	@org.junit.Test
    public void finalThird() {
		
		
		// https://restcountries.eu/rest/v2/alpha/co2
		String url ="https://restcountries.com/v2/callingcode/372";
		      
      Response res = RestAssured.given().when().get(url)
       .then().statusCode(200)
       .extract().path("currencies[0].code");
   
    System.out.println(res.getStatusCode());
	}

}
