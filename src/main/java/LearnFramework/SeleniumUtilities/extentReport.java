package LearnFramework.SeleniumUtilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


// This class we have introduced for extent reports 
public class extentReport {

	public static ExtentReports getReportObject()
	{
		String FilePath=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter es=new ExtentSparkReporter(FilePath);
		es.config().setDocumentTitle("Web Automation");
		es.config().setReportName("Learning Purposer WebAutomation");
		
		ExtentReports extentR=new ExtentReports();
		extentR.attachReporter(es);
		extentR.setSystemInfo("Tester", "Mansa Mishra");
		return extentR;
	}
}
