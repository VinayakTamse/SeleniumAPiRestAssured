package selenium.features.app.main.tests;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_Requests_Test {
	
	RequestSpecification httpRequest;
	Response response;
	
	@BeforeMethod
	public void setUp()
	{
		RestAssured.baseURI = "https://testingvinu.pythonanywhere.com/api2";
		httpRequest = RestAssured.given();
	}
	
	
	
	@Test(priority=0)
	public void get_request_test()
	{
		response = httpRequest.request(Method.GET, "/employee/");
		String responseBody = response.getBody().asPrettyString();
		System.out.println(response.statusLine()+"\n"+responseBody);
		Assert.assertEquals(response.statusCode(), 200);
		JsonPath path = response.jsonPath();
		String name = path.get("[3].name");
		Assert.assertEquals(name, "Jai");
	}
	
	@Test(priority=1)
	public void get_request_by_id_test()
	{
		response = httpRequest.request(Method.GET, "/employee/2/");
		String responseBody = response.getBody().asPrettyString();
		System.out.println(response.statusLine()+"\n"+responseBody);
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@SuppressWarnings("unchecked")
	@Test(priority=2, enabled=true)
	public void post_request_test()
	{
		
		
		JSONObject obj = new JSONObject();
		obj.put("name", "Varsha");
		obj.put("salary", 33000);
		obj.put("place", "Mumbai");
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(obj.toJSONString());
		response = httpRequest.request(Method.POST, "/employee/");
		System.out.println(response.statusLine()+"\n"+response.getBody().asPrettyString());
		Assert.assertEquals(response.statusCode(), 201);
	}
	
	@SuppressWarnings("unchecked")
	@Test(priority=3)
	public void put_request_test()
	{
		JSONObject obj = new JSONObject();
		obj.put("name", "Charan");
		obj.put("salary", 18000);
		obj.put("place", "Goa");
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(obj.toJSONString());
		response = httpRequest.request(Method.PUT, "/employee/10/");
		System.out.println(response.statusLine()+"\n"+response.getBody().asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);
		String name = response.jsonPath().get("name");
		Assert.assertEquals(name, obj.get("name"));
		
	}
	
	@SuppressWarnings("unchecked")
	@Test(priority=4)
	public void patch_request_test()
	{
		JSONObject obj = new JSONObject();
		obj.put("salary", 67000);
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(obj.toJSONString());
		httpRequest.request(Method.PATCH, "/employee/1/");
		System.out.println(response.statusLine()+"\n"+response.getBody().asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);
		
		
	}
	
	@Test(priority=5)
	public void delete_request_test()
	{
		
		response = httpRequest.request(Method.DELETE, "/employee/12/");
		System.out.println(response.statusLine());
		System.out.println(response.prettyPrint());
		if (response.statusCode() != 204)
		{
			Assert.assertEquals(response.statusCode(), 404);
		}
		else {
			Assert.assertEquals(response.statusCode(), 204);
		}
		
		
		
	}
	
	@AfterMethod
	public void end()
	{
		System.out.println("===Executed===");
	}
	

}
