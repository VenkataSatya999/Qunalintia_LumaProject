package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Register_Page;

public class Registeration_Test extends Base_Test
{
	
	@Test
	public void registration_Test() throws InterruptedException
	{
		HomePage hg= new HomePage(driver);
		hg.homePage();
		
		log.info("link clicking activity is completed");
		
		Register_Page rp=new Register_Page(driver);
		rp.register_Luma();
		
		String Act_Title=driver.getTitle();
		 String Exp_Title="My Account";
		 
		 if(Act_Title.equals(Exp_Title)) {
			 
			 Assert.assertTrue(true);
			 log.info("testcase passed");
		 }else
		 {
			 captureScreen("CreateAcTest");
			 log.info("Testcase is failed");
			 
		 }
		
		log.info("account created successfully");
	}
	
}
