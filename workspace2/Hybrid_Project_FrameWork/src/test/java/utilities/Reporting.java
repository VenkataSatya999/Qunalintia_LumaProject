package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporting implements ITestListener
{
  
	public ExtentSparkReporter reporter;
	public ExtentReports reports;
	public ExtentTest test;
	
	public void onStart(ITestContext context)
	{
		//String timestamp =new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		//String repName ="para-report-"+timestamp+".html";
	
	 reporter = new ExtentSparkReporter ("C:\\Users\\Admin3\\workspace2\\Hybrid_Project_FrameWork\\Reports\\report_name.hxml");
	 reporter.config().setDocumentTitle("Automation Testing Report ");
	 reporter.config().setReportName("Login Functionality Extent Report");
	 reporter.config().setTheme(Theme.DARK);
	
	 
	 reports =new ExtentReports();
	 reports.attachReporter(reporter);
	 reports.setSystemInfo("user","saikrishna");
	 reports.setSystemInfo("Environment","QA");
	 reports.setSystemInfo("Hostname","Local Host");
	 reports.setSystemInfo("os","Windows 10");
	 reports.setSystemInfo("Browsers","chrome,edge,firefox");
	}
	
	
	public void onTestSuccess(ITestResult tr) 
	{ 
		test= reports.createTest(tr.getName());
		test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));   	
	}
	public void onTestFailure(ITestResult tr) 
	{ 
		test= reports.createTest(tr.getName());
		test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));   	
	}
	
	public void onTestskipped(ITestResult tr)
	{
		test= reports.createTest(tr.getName());
		test.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));   	
	}
	
	public void onFinish(ITestContext context) 
	{
		reports.flush(); 	
	}


	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
}