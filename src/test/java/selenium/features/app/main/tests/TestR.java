package selenium.features.app.main.tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestR {
	
	@Test(enabled=false)
	public void test_01()
	{
		RestAssured.baseURI= "https://reqres.in/api";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET, "/users>page=2");
		
		String responseBody = response.getBody().asPrettyString();
		
		System.out.println(responseBody);
		
		Assert.assertEquals(response.statusCode(), 200);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		System.out.println(response.getStatusLine()+"  "+response.statusLine());
		
		System.out.println(response.getTime());
		
	
	}
	
	@Test
	public void test_post_request()
	{
		RestAssured.baseURI = "https://reqres.in/api";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject params = new JSONObject();
		
		params.put("name", "morpheus");
		
		params.put("job", "leader");
		
		httpRequest.header("Content-Type", "application/json");
		
		httpRequest.body(params.toJSONString());
		
		Response response = httpRequest.request(Method.POST, "/users");
		
		Assert.assertEquals(response.getStatusCode(), 201);
		
		System.out.println(response.getBody().asPrettyString());
		
		String name = response.jsonPath().get("name");
		
		Assert.assertEquals(name, params.get("name"));
		
		
	}

}
