package api.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoits.UserEndPointsUsingProprties;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTestUsingProperies {
	
	Faker faker;
	User userPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setUp() {
		
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		// logs
		
		logger = LogManager.getLogger(this.getClass());
		logger.debug("Debugging.....");
	}

	@Test(priority = 1)
	public void testPostUser() {
		
		logger.info("********** Creating User ************");
		Response res = UserEndPointsUsingProprties.createUser(userPayload);		
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 2)
	public void testGetUserByName() {
		logger.info("********** Reading User Info ************");
		Response res = UserEndPointsUsingProprties.readUser(this.userPayload.getUsername());
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	public void testUpdateUser() {
		logger.info("********** Updating User ************");
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		Response res = UserEndPointsUsingProprties.updateUser(this.userPayload, this.userPayload.getUsername());
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//checking data after update 
		Response resAfterUpdate = UserEndPointsUsingProprties.readUser(this.userPayload.getUsername());
		resAfterUpdate.then().log().body();
		
		Assert.assertEquals(resAfterUpdate.getStatusCode(), 200);
		
		logger.info("********** User Updated ************");
	}
	
	@Test(priority = 4)
	public void testDeleteUserByName() {
		
		Response res = UserEndPointsUsingProprties.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(res.getStatusCode(), 200);
		
		logger.info("********** User Deleted ************");
	}
	
}
