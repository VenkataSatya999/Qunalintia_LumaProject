package step_definations;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_Objects.Register_Objects;

public class Create_New_Account_step_def {

	public static WebDriver driver;
	Register_Objects ro;
	@Given("the user is on the Create Account page")
	public void the_user_is_on_the_create_account_page() {
		
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
		driver.manage().window().maximize();
		ro=new Register_Objects(driver);
	}

	@When("the user enters {string} in the First Name field")
	public void the_user_enters_in_the_first_name_field(String fname) {
		ro.f_name(fname);

	}

	@And("the user enters {string} in the Last Name field")
	public void the_user_enters_in_the_last_name_field(String lname) { 
		ro.l_name(lname);
		}

	@And("the user enters {string} in the Email field")
	public void the_user_enters_in_the_email_field(String email) {
		ro.eMail(email);
	}

	@And("the user enters {string} in the Password field")
	public void the_user_enters_in_the_password_field(String pass) {
		ro.passw(pass);
	}

	@And("the user enters {string} in the Confirm Password field")
	public void the_user_enters_in_the_confirm_password_field(String confirmpass) {
		ro.conPass(confirmpass);
	}

	@And("clicks the Create Account button")
	public void clicks_the_create_account_button() {
		ro.create_Button();
	}

	@Then("the account should be created successfully, and the user should see a welcome message")
	public void the_account_should_be_created_successfully_and_the_user_should_see_a_welcome_message() {
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

	@When("the user leaves the First Name field as empty {string}")
	public void the_user_leaves_the_first_name_field_as_empty(String fname) {
		ro.f_name(fname);
	}

	@Then("an error message should appear stating First Name is required")
	public void an_error_message_should_appear_stating_first_name_is_required() {
		boolean actualfname=driver.findElement(By.xpath("//div[@id='firstname-error']")).isDisplayed();
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
