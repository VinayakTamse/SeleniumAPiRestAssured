package selenium.features.app.main.tests;

import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.serializer.SerializeException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import selenium.features.app.main.utility.API;
import selenium.features.applombok.Employee;

public class API_Test_MOD_4 {
	
	@Parameters({"BaseURI", "path", "method"})
	@Test
	public void post_test(String baseUri, String Path, String Method) throws SerializeException
	{
		Employee emp = new Employee();
		emp.setName("Rama");
		emp.setSalary(88000);
		emp.setPlace("Bangalore");
		
		JsonSerializer serialize = JsonSerializer.DEFAULT_READABLE;
		String body = serialize.serialize(emp);
		
		Response response = API.sendRequest(baseUri, Method, Path, body);
		System.out.println(response.statusLine());
		
		Assert.assertEquals(response.statusCode(), 201);
	}

}
