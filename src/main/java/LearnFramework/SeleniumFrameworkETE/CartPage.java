package LearnFramework.SeleniumFrameworkETE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import LearnFramework.SeleniumUtilities.utilities;

public class CartPage extends utilities {
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}

@FindBy(css=".cartSection h3")
List<WebElement> cartProducts;

@FindBy(css=".totalRow button")
WebElement checkOut;


public Boolean verifyCart(String ProductName)
{
	//return cartProducts; 
	Boolean match=cartProducts.stream().anyMatch(cartnew->cartnew.getText().equals(ProductName));
	return match;
		
}
public FinalPage checkOut() throws InterruptedException
{
	Thread.sleep(3000);
	checkOut.click();
	return new FinalPage(driver);
}

}
