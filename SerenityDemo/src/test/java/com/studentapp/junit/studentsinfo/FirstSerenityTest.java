package com.studentapp.junit.studentsinfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Pending;

@RunWith(SerenityRunner.class)
public class FirstSerenityTest {

	@BeforeClass
	public static void init() {
		RestAssured.baseURI="http://localhost:8080/student";
	}

	
	@Test
	public void getAllStudents() {
		RestAssured.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all();
	//	.statusCode(200);
	/*	
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(200);
	*/
	}

	@Test
	public void thisIsaFailing() {
		RestAssured.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(500);
	}
	
	@Pending
	@Test
	public void thisIsAPendingTest() {
		
	}
	
	@Ignore
	@Test
	public void thisIsASkippedTest() {
		
	}
	
	
	@Test
	public void thisIsAtestWithError() {
		System.out.println("this is an error "+(10/0));
	}
	
	@Test
	public void fileDoseNotExist() throws FileNotFoundException {
		File file = new File("E://file.txt");
		FileReader fr = new FileReader(file);
	}
}
