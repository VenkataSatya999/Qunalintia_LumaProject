package Testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import utilities.ExcelReading;

public class Login_DataDriven extends Base_Test
{
	@Test(dataProvider="Login_Test_Data")
	public void loginTest_DataDriven(String Email,String pWord)
	{
		LoginPage lg=new LoginPage(driver);
		lg.setUserName(Email);
		lg.setPassword(pWord);
		lg.submit_button();
	}
	
	@DataProvider(name="Login_Test_Data")
	public String[][] loginData() throws IOException
	{
		String path="C:\\Users\\Admin3\\workspace2\\Hybrid_Project_FrameWork\\TestData\\Selenium_practice.xlsx";
		int rownum=ExcelReading.getRowCount(path, "Sheet1");
		int cellnum=ExcelReading.getColCount(path, "Sheet1", 1);
		
		String login_data[][]=new String[rownum][cellnum];
		
		for(int i=1;i<=rownum-1;i++)
		{
			for(int j=0;j<cellnum;j++)
			{
				login_data[i-1][j]=ExcelReading.getCellData(path, "Sheet1", i, j);
			}
		}
		return login_data;
		
	}
}
