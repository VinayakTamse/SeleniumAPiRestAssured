package selenium.features.app.main.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_API_Test {
	
	@Test
	public void test_get_method()
	{
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/users>page=2");
		System.out.println(response.getBody().asPrettyString());
		String name = response.jsonPath().get("data[1].name");
		System.out.println(name);
	}
	

}
