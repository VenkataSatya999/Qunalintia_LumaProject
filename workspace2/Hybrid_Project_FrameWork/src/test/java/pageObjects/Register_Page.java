package pageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register_Page extends Base_Class
{
	public Register_Page(WebDriver driver)
	{
		super(driver);
	}


	@FindBy(xpath="//input[@id='customer.firstName']")
	WebElement firstName;

	@FindBy(xpath="//input[@id='customer.lastName']")
	WebElement lastName;

	@FindBy(xpath="//input[@id='customer.address.street']")
	WebElement address;

	@FindBy(xpath="//input[@id='customer.address.city']")
	WebElement city;

	@FindBy(xpath="//input[@id='customer.address.state']")
	WebElement state;

	@FindBy(xpath="//input[@id='customer.address.zipCode']")
	WebElement zip_Code;

	@FindBy(xpath="//input[@id='customer.phoneNumber']")
	WebElement phoneNumber;

	@FindBy(xpath="//input[@id='customer.ssn']")
	WebElement sSN_TextBox;

	@FindBy(xpath="//input[@id='customer.username']")
	WebElement userName;

	@FindBy(xpath="//input[@id='customer.password']")
	WebElement passWord;

	@FindBy(xpath="//input[@id='repeatedPassword']")
	WebElement confirm_PassWord;

	@FindBy(xpath="//input[@class='button' and @value='Register']")
	WebElement rigisterBtn;


	public void register_Luma() throws InterruptedException
	{
		firstName.sendKeys("satya");
		lastName.sendKeys("Venkata");
		address.sendKeys("Ongole");
		city.sendKeys("Ongole");
		Thread.sleep(3000);
		state.sendKeys("Andra Pradesh");
		zip_Code.sendKeys("500072");
		phoneNumber.sendKeys("1234567890");
		Thread.sleep(3000);
		sSN_TextBox.sendKeys("aaaaaaaa");
		userName.sendKeys("sathish111");
		passWord.sendKeys("V@123456");
		confirm_PassWord.sendKeys("V@123456");
		Thread.sleep(3000);
		rigisterBtn.click();
		Thread.sleep(3000);
		String actualText=driver.findElement(By.xpath("//div[@id='rightPanel']/h1/following-sibling::p")).getText();
		assertEquals(actualText, "Your account was created successfully. You are now logged in.","registration was not succesfully done");
	}


}
