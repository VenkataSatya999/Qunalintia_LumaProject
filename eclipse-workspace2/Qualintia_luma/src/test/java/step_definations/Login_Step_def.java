package step_definations;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_Objects.SignIn_Objects;

public class Login_Step_def {
	public static WebDriver driver;
	SignIn_Objects so;
	@Given("the user is on the Login page")
	public void the_user_is_on_the_login_page() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
		driver.manage().window().maximize();
		so=new SignIn_Objects(driver);

	}
	@When("the user enter {string} in the Email field")
	public void the_user_enter_in_the_email_field(String email) {
		so.eMail(email);
	}

	@And("the user enter {string} in the Password field")
	public void the_user_enter_in_the_password_field(String pass) {
		so.passwo(pass);
	}

	@And("clicks the Login button")
	public void clicks_the_login_button() {
		so.Create_Button();
	}

	@Then("the user should be redirected to the homepage")
	public void the_user_should_be_redirected_to_the_homepage() {
		boolean actualfname=driver.findElement(By.xpath("//span[text()='My Account']")).isDisplayed();
		if(actualfname==true)
		{
			System.out.println("textcase passed");
		}
		else
		{
			System.out.println("textcase failed");
		}
	}

	@Then("an error message should appear stating Invalid login credentials")
	public void an_error_message_should_appear_stating_invalid_login_credentials() {
		boolean errortext=driver.findElement(By.xpath("//div[text()='The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']")).isDisplayed();
		if(errortext==true)
		{
			System.out.println("error messaged was displayed");
		}
		else
		{
			System.out.println("error messaged was NOT displayed");
		}
	}

	@When("the user leaves the {string} email field empty")
	public void the_user_leaves_the_email_field_empty(String email) {
		so.eMail(email);
	}

	@Then("an error message should appear stating Email is required")
	public void an_error_message_should_appear_stating_email_is_required() {
		boolean actualfname=driver.findElement(By.xpath("//input[@id='email']/following-sibling::div[text()='This is a required field.']")).isDisplayed();
		if(actualfname==true)
		{
			System.out.println("textcase passed");
		}
		else
		{
			System.out.println("textcase failed");
		}
	}

	@When("leaves the {string} password field empty")
	public void leaves_the_password_field_empty(String pass) {
		so.passwo(pass);
	}

	@Then("an error message should appear stating Password is required")
	public void an_error_message_should_appear_stating_password_is_required() {
		boolean actualfname=driver.findElement(By.xpath("//input[@id='pass']/following-sibling::div[text()='This is a required field.']")).isDisplayed();
		if(actualfname==true)
		{
			System.out.println("textcase passed");
		}
		else
		{
			System.out.println("textcase failed");
		}
	}
}
