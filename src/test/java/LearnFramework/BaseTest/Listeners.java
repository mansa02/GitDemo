package LearnFramework.BaseTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import LearnFramework.SeleniumUtilities.extentReport;

public class Listeners extends baseTest implements ITestListener {
	ExtentReports extentR=extentReport.getReportObject();
	ExtentTest test;
	
	//For making it thread safe
	ThreadLocal<ExtentTest> threadExtent=new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result)
	     {
		  test=extentR.createTest(result.getMethod().getMethodName());
		  threadExtent.set(test); //unique thread validationtest-->>Test
		  }
	
	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS, "Test is passed");
		test.pass("Method got executed successfully");
	}
	public void onTestFailure(ITestResult result)
	{ String FilePath=null;
	
		test.log(Status.FAIL, "Test is Failed");
		threadExtent.get().fail(result.getThrowable());
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 FilePath=getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadExtent.get().addScreenCaptureFromPath(FilePath, result.getMethod().getMethodName());
	}
	public void onTestSkipped(ITestResult result)
	{
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}
	public void onStart(ITestContext context)
	{
		
	}
	public void onFinish(ITestContext context)
	{
		extentR.flush();
}
}

