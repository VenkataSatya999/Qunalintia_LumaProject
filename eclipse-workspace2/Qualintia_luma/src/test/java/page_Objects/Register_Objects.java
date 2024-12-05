package page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register_Objects 
{
	public WebDriver driver;
public Register_Objects(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//input[@name='firstname']") public WebElement firstname;
@FindBy(xpath="//input[@name='lastname']") public WebElement lastname;
@FindBy(xpath="//input[@name='email']") public WebElement email;
@FindBy(xpath="//input[@name='password']") public WebElement password;
@FindBy(xpath="//input[@name='password_confirmation']") public WebElement confirmpassword;
@FindBy(xpath="//button[@type='submit']/span[text()='Create an Account']") public WebElement create_button;


public void f_name(String name)
{
	firstname.sendKeys(name);
}
public void l_name(String name)
{
lastname.sendKeys(name);
}
public void eMail(String ma)
{
	email.sendKeys(ma);
}
public void passw(String pas)
{
	password.sendKeys(pas);
}
public void conPass(String pas)
{
	confirmpassword.sendKeys(pas);
}
public void create_Button()
{
	create_button.click();
}

}
