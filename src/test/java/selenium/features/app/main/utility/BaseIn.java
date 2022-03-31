package selenium.features.app.main.utility;



public interface BaseIn {
	
	String usernameXpath = "//input[@id='txtUsername']";
	String userpasswordXpath = "//input[@id='txtPassword']";
	String loginButtonXpath = "//input[@id='btnLogin']";
	
	static void justWait()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	

	
	
}
