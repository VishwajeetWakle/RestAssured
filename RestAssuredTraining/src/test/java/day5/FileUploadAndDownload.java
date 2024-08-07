package day5;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;


public class FileUploadAndDownload {

	
	@Test
	void singleFileUpload() {
		
		File myfile = new File(".\\test.txt");
		
		given()
			.multiPart("file", myfile)
			.contentType("multipart/form-data")
		.when()
			.post("http://localhost:8080/uploadFile")
		.then()
			.statusCode(200)
			.body("fileName", equalTo("test.txt"));
	}
	
	
	@Test
	void multipleFileUpload() {
		
		File myfile1 = new File(".\\test1.txt");
		File myfile2 = new File(".\\test2.txt");
		
		given()
			.multiPart("files", myfile1)
			.multiPart("files", myfile2)
			.contentType("multipart/form-data")
		.when()
			.post("http://localhost:8080/uploadFile")
		.then()
			.statusCode(200)
			.body("[0].fileName", equalTo("test1.txt"))
			.body("[1].fileName", equalTo("test2.txt"));
	}
	
	
	@Test
	void multipleFileUploadUsingArr() { // wont work for all kinds of APIs
		
		File myfile1 = new File(".\\test1.txt");
		File myfile2 = new File(".\\test2.txt");
		
		File fileArr []  = {myfile1, myfile2};
		
		given()
			.multiPart("files", fileArr)
			.contentType("multipart/form-data")
		.when()
			.post("http://localhost:8080/uploadFile")
		.then()
			.statusCode(200)
			.body("[0].fileName", equalTo("test1.txt"))
			.body("[1].fileName", equalTo("test2.txt"));
	}
	
	
	@Test
	void fileDownload() {
		
		given()
		.when()
			.get("http://localhost:8080/downloadFile/test.txt")
		.then()
			.statusCode(200)
			.log().body();
	}
	
}
