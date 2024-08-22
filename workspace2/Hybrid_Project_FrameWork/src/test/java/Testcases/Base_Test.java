package Testcases;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utilities.Reading;

public class Base_Test
{

	public static WebDriver driver;
	public Logger log;
	
	Reading rd=new Reading();
	public String browserType=rd.browsers();
	public String appURL=rd.urlApplication();
	public String userAdd=rd.username();
	public String pword=rd.password();
	
	@BeforeClass
	public void setUp()
	{
		if(browserType.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browserType.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browserType.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		log=Logger.getLogger(this.getClass());
		PropertyConfigurator.configure("log4j.properties");
		
		driver.get(appURL);
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void close()
	{
		driver.close();
	}
	
	public String captureScreen(String name)  {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot ss=(TakesScreenshot) driver;
		File source=ss.getScreenshotAs(OutputType.FILE);
		String destination= "./Screenshots/"+name+timeStamp+".png";
		
		try {
			FileUtils.copyFile(source, new File(destination));
		}catch(Exception e) {
			e.getMessage();
		}
		return destination;

	}
	
	
}
