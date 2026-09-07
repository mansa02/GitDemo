package LearnFramework.BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import LearnFramework.SeleniumFrameworkETE.loginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {
	protected WebDriver driver;
	public loginPage loginP;
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\LearnFramework\\properties\\baseProperty.properties");
		prop.load(fis);
        
		//Reading browser name from maven command if not present in maven command then fetching from properties file
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
		
				//Reading browser name from property file
				//String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("firefox"))
		{		
		driver=new FirefoxDriver();
	}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			//Handling chromediver intantilization with the help webdriver manager
		
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		return driver;
}
	@BeforeMethod(alwaysRun=true)
	public loginPage launchApplication() throws IOException
	{
		driver=initializeDriver();
		 loginP=new loginPage(driver);
		loginP.launchURL();
        return loginP;
	}
	@AfterMethod(alwaysRun=true)
	public void closeDrivers()
	{
		driver.close();
	}
	
	//Method to Read the file from json file
	
	public List<HashMap<String, String>> getJsonData(String FilePath) throws IOException
	{
		String jsonContent=FileUtils.readFileToString(new File(FilePath), StandardCharsets.UTF_8);
	
		ObjectMapper mapper=new ObjectMapper();
	List<HashMap<String,String>> data= 	mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
			return data;
		}
	//Screenshot utility
	
	 public String getScreenshot(String  testCaseName, WebDriver driver) throws IOException
	   {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Source, new File(System.getProperty("user.dir")+"//reports//"+ testCaseName+ ".png"));
		return System.getProperty("user.dir")+"//reports//"+ testCaseName+ ".png";
	   }
	
}