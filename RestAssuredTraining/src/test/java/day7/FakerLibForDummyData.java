package day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerLibForDummyData {
	
	@Test
	void testGenerateDummyData() {
		
		Faker faker = new Faker();
		
		String fullName = faker.name().fullName();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		
		String username = faker.name().username();
		String password = faker.internet().password();
		
		String phoneNo = faker.phoneNumber().phoneNumber();
		String email = faker.internet().safeEmailAddress();
		
		System.out.println(fullName);
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println();
		System.out.println();
		System.out.println(username);
		System.out.println(password);
		System.out.println();
		System.out.println();
		System.out.println(phoneNo);
		System.out.println(email);
	}

}
