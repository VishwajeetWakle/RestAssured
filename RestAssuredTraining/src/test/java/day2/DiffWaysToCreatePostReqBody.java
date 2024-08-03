package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class DiffWaysToCreatePostReqBody {

	// 1) Post req body using hashmap
//	@Test(priority = 1)
	void testPostUsingHashMap() {

		HashMap<String, Object> data = new HashMap<String, Object>();

		data.put("name", "Scott");
		data.put("location", "FR");
		data.put("phone", "5647891230");
		data.put("id", "4");
		String courseArr[] = { "C", "C++" };

		data.put("courses", courseArr);

		/*
		 * { "id": "4", "name": "Scott", "location": "FR", "phone": "5647891230",
		 * "courses": [ "C", "C++" ] }
		 */

		given().contentType("application/json").body(data)

				.when().post("http://localhost:3000/students").then().statusCode(201).body("name", equalTo("Scott"))
				.body("location", equalTo("FR")).body("phone", equalTo("5647891230")).body("courses[0]", equalTo("C"))
				.body("courses[1]", equalTo("C++")).header("Content-Type", "application/json").log().all();
	}

	// 2) Post req body using org.json
//		@Test(priority = 1)
	void testPostUsingJsonLib() {

		JSONObject data = new JSONObject();

		data.put("name", "Scott");
		data.put("location", "FR");
		data.put("phone", "5647891230");
		data.put("id", "4");
		String courseArr[] = { "C", "C++" };
		data.put("courses", courseArr);

		/*
		 * { "id": "4", "name": "Scott", "location": "FR", "phone": "5647891230",
		 * "courses": [ "C", "C++" ] }
		 */

		given().contentType("application/json").body(data.toString())

				.when().post("http://localhost:3000/students").then().statusCode(201).body("name", equalTo("Scott"))
				.body("location", equalTo("FR")).body("phone", equalTo("5647891230")).body("courses[0]", equalTo("C"))
				.body("courses[1]", equalTo("C++")).header("Content-Type", "application/json").log().all();
	}

	// 3) Post req body using pojo class
//	@Test(priority = 1)
	void testPostUsingPojoClass() {

		Pojo_PostRequest data = new Pojo_PostRequest();

		data.setName("Scott");
		data.setLocation("FR");
		data.setPhone("5647891230");
		data.setId("4");
		String courseArr[] = { "C", "C++" };
		data.setCourses(courseArr);

		/*
		 * { "id": "4", "name": "Scott", "location": "FR", "phone": "5647891230",
		 * "courses": [ "C", "C++" ] }
		 */

		given().contentType("application/json").body(data)

				.when().post("http://localhost:3000/students").then().statusCode(201).body("name", equalTo("Scott"))
				.body("location", equalTo("FR")).body("phone", equalTo("5647891230")).body("courses[0]", equalTo("C"))
				.body("courses[1]", equalTo("C++")).header("Content-Type", "application/json").log().all();
	}

	// 4) Post req body using external json file
	@Test(priority = 1)
	void testPostUsingJsonFile() throws FileNotFoundException {

		/*
		 * { "id": "4", "name": "Scott", "location": "FR", "phone": "5647891230",
		 * "courses": [ "C", "C++" ] }
		 */

		File f = new File("D:\\SDET Level 2\\Rest Assured\\RestAssuredSerenityBDD\\RestAssuredTraining\\src\\test\\java\\day2\\external.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt); 

		given().contentType("application/json").body(data.toString())
				// here we can also pass directly the file object 
				.when().post("http://localhost:3000/students").then().statusCode(201).body("name", equalTo("Scott"))
				.body("location", equalTo("FR")).body("phone", equalTo("5647891230")).body("courses[0]", equalTo("C"))
				.body("courses[1]", equalTo("C++")).header("Content-Type", "application/json").log().all();
	}

	// deleting the above record
	@Test(priority = 2)
	void deleteRecord() {
		given().when().delete("http://localhost:3000/students/4").then().statusCode(200);
	}

}
