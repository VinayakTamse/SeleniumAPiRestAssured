package selenium.features.app.main.tests;

import org.apache.juneau.json.JsonParser;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.parser.ParseException;
import org.apache.juneau.serializer.SerializeException;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import selenium.features.applombok.Employee;

public class API_Request_Test_lambook_juneau {
	
	
	
	@Test(enabled=false)
	public void test_api() throws SerializeException
	{
		// Creating data to send using Juneau Library
		Employee emp1 = new Employee();
		emp1.setName("Bal Surya");
		emp1.setSalary(55000);
		emp1.setPlace("Pune");
		JsonSerializer serialize = JsonSerializer.DEFAULT_READABLE;
		String jsondata = serialize.serialize(emp1);
		
		RestAssured.baseURI = "https://testingvinu.pythonanywhere.com/api2";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		// Sending data
		httpRequest.body(jsondata);
		Response response = httpRequest.request(Method.POST, "/employee/");
		response.prettyPrint();
		Assert.assertEquals(response.statusCode(), 201);
	}
	
	@Test
	public void verify_api_get() throws ParseException
	{
		RestAssured.baseURI = "https://testingvinu.pythonanywhere.com/api2";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/employee/20/");
		String responseBody  = response.getBody().asString();
		JsonParser parse = JsonParser.DEFAULT;
		Employee emp = parse.parse(responseBody, Employee.class);
		Assert.assertEquals("Bal Chandra", emp.getName());
		System.out.println(emp.getId());
		System.out.println(emp.getSalary());
		System.out.println(emp.getPlace());
		
	}
	

}
