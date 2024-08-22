package Testcases;

import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class LoginTest extends Base_Test
{

	@Test
	public void loginFunctionality()
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(userAdd);
		log.info("userName added successfully");
		lp.setPassword(pword);
		log.info("password added successfully");
		lp.submit_button();
		
		log.info("login was succussfully done");
	}
}
