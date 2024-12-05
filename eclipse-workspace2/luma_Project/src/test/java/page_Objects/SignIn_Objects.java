package page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn_Objects 
{
	public WebDriver driver;
	public SignIn_Objects(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='email']") public WebElement email;
	@FindBy(xpath="//input[@id='pass']") public WebElement password;
	@FindBy(xpath="//button[@id='send2']/span[text()='Sign In']") public WebElement c_button;

	public void eMail(String ema)
	{
		email.sendKeys(ema);
	}
	public void passwo(String pas)
	{
		password.sendKeys(pas);
	}
	public void Create_Button()
	{
		c_button.click();
	}
}
