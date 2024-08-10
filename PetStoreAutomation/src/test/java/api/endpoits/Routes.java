package api.endpoits;

public class Routes {
	
	public static String baseUrl = "https://petstore.swagger.io/v2";
	
	// User Module
	
	public static String userPostUrl = baseUrl+"/user";
	public static String userGetUrl = baseUrl+"/user/{username}";
	public static String userUpdateUrl = baseUrl+"/user/{username}";
	public static String userDeleteUrl = baseUrl+"/user/{username}";

}
