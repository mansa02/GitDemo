package LearnFramework.SeleniumFrameworkETE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import LearnFramework.SeleniumUtilities.utilities;

public class Product extends utilities {
	WebDriver driver;
	
	public Product(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}

@FindBy(css=".mb-3")
List<WebElement> Products;

@FindBy(css=".toast-message")
WebElement toast;

@FindBy(css=".cartSection h3")
List<WebElement> cartProducts;

//@FindBy(css=".card-body button:last-of-type")
//WebElement elementToClick;

By loader=By.cssSelector(".mb-3");
By productToAdd=By.cssSelector(".card-body button:last-of-type");

By toastMsg=By.cssSelector(".toast-message");



public List<WebElement> getProductList()
{
	waitForElement(loader);
	return Products;
}

public void getProductName(String ProductName )
{
	WebElement name=getProductList().stream().filter(cart->cart.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
    name.findElement(productToAdd).click();
}
public void verifyToastMsg(String toastTextMsgExp )
{
	waitForElement(toastMsg);
	String toastTextMsgActual=toast.getText();
	Assert.assertTrue(toastTextMsgActual.equalsIgnoreCase(toastTextMsgExp));
	
}

}
