package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Base_Class
{

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement register_btn;
	
	public void homePage() throws InterruptedException
	{
		register_btn.click();
		Thread.sleep(3000);
	}

}
