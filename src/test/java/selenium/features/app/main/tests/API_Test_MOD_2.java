package selenium.features.app.main.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import selenium.features.app.main.utility.API;

public class API_Test_MOD_2 {
	
	@Parameters({"BaseURI", "path", "method"})
	@Test
	public void test_api_get(String baseUri, String path, String method)
	{
		
		Response response = API.sendRequest(baseUri, method, path, null);
		response.prettyPrint();
		System.out.println(response.statusLine());
		Assert.assertEquals(response.statusCode(), 200);
	}

}
