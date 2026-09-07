package LearnFramework.SeleniumFrameworkETE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LearnFramework.SeleniumUtilities.utilities;

public class loginPage extends utilities{
	WebDriver driver;
	
	public loginPage(WebDriver driver)
	{    super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
 
@FindBy(id="userEmail")
WebElement userEmail;

@FindBy(id="userPassword")
WebElement userPwd;

@FindBy(name="login")
WebElement loginButton;
	
@FindBy(css="[class*='flyInOut']")
WebElement ErrorValidation;

public Product login(String email,String pwd)
{
	userEmail.sendKeys(email);
	userPwd.sendKeys(pwd);
	loginButton.click();
	return new Product(driver);
	
}
public void launchURL()
{
	driver.get("https://rahulshettyacademy.com/client/");
}
public String wrongPwdErrorMsg()
{
	
	waitForElementToAppear(ErrorValidation);
	String Error=ErrorValidation.getText();
	return Error;
}

}
