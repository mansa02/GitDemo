package LearnFramework.SeleniumUtilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import LearnFramework.SeleniumFrameworkETE.CartPage;

public class utilities {
	WebDriver driver;
//	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	@FindBy(css="[routerlink*=\"cart\"]")
	WebElement cart;
	public utilities(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	public void waitForElement(By ByElement)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(ByElement));
}
	public void waitForElementToAppear(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public CartPage goToCart() throws InterruptedException
	{
		Thread.sleep(1000);
		cart.click();
		return new CartPage(driver);
	}
}
