package selenium.features.app.main.utility;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API {
	
	private static RequestSpecification httpRequest;
	private static Response response;
	
	
	public static Response sendRequest(String baseuri, String method, String path, String body)
	{
		RestAssured.baseURI = baseuri;
		httpRequest = RestAssured.given();
		if (method.equalsIgnoreCase("GET"))
		{
			response = httpRequest.request(Method.GET, path);
			
		}
		else if (method.equalsIgnoreCase("POST"))
		{
			httpRequest.header("Content-Type", "application/json");
			httpRequest.body(body);
			response = httpRequest.request(Method.POST, path);
		}
		else if (method.equalsIgnoreCase("PUT"))
		{
			httpRequest.header("Content-Type", "application/json");
			httpRequest.body(body);
			response = httpRequest.request(Method.PUT, path);
		}
		else if (method.equalsIgnoreCase("DELETE"))
		{
			response = httpRequest.request(Method.DELETE, path);
		}
		else {
			System.out.println("Invalid Request");
		}
		
		return response;
	}
	

}
