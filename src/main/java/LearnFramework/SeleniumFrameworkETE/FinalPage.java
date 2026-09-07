package LearnFramework.SeleniumFrameworkETE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import LearnFramework.SeleniumUtilities.utilities;

public class FinalPage extends utilities {
	WebDriver driver;
	
	public FinalPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}

@FindBy(css="[placeholder=\"Select Country\"]")
WebElement enterCountry;
@FindBy(xpath="//*[@class=\"ta-results list-group ng-star-inserted\"]//button[2]")
WebElement selectCountry;
@FindBy(css=".action__submit")
WebElement clickPlaceOrder;
@FindBy(css=".hero-primary")
WebElement confirmationActual;

public void selectCountry1(String countryName) throws InterruptedException
{
	Actions a=new Actions(driver);
	a.sendKeys(enterCountry, countryName).build().perform();
	Thread.sleep(3000);
	selectCountry.click();
	clickPlaceOrder.click();
	
}
public String confirmation() throws InterruptedException
{
	waitForElement(By.cssSelector(".hero-primary"));
	String ActualConfirmation=confirmationActual.getText();
	return ActualConfirmation;
}

}
