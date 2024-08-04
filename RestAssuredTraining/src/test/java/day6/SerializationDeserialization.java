package day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationDeserialization {

	
	// Pojo to Json ( Serialization)
	
	@Test
	void convertPojo2Json() throws JsonProcessingException {
		
		Student stud = new Student();
		
		stud.setName("Scott");
		stud.setLocation("FR");
		stud.setPhone("5647891230");
		stud.setId("4");
		String courseArr[] = { "C", "C++" };
		stud.setCourses(courseArr);
		
		ObjectMapper objMapper = new ObjectMapper();
		
		String jsonData = objMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(stud);
		
		System.out.println(jsonData);
	
	}
	
	// json to Pojo ( Deserialization )
	
	@Test
	void convertJson2Pojo() throws JsonMappingException, JsonProcessingException {
		String jsonData="{\r\n"
				+ "  \"id\" : \"4\",\r\n"
				+ "  \"name\" : \"Scott\",\r\n"
				+ "  \"location\" : \"FR\",\r\n"
				+ "  \"phone\" : \"5647891230\",\r\n"
				+ "  \"courses\" : [ \"C\", \"C++\" ]\r\n"
				+ "}";
		
		ObjectMapper objMapper = new ObjectMapper();
		
		Student stud = objMapper.readValue(jsonData, Student.class);
		
		System.out.println("ID : "+stud.getId());
		System.out.println("Name : "+stud.getName());
		System.out.println("Location : "+stud.getLocation());
		System.out.println("Phone : "+stud.getPhone());
		System.out.println("Course 1 : "+stud.getCourses()[0]);
		System.out.println("Course 2 : "+stud.getCourses()[1]);
	}
	
}
