package LearnFramework.SeleniumFrameworkETE;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StanaloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String ProductName="ADIDAS ORIGINAL";
		WebDriver driver=new FirefoxDriver();
		loginPage l=new loginPage(driver);
		driver.get("https://rahulshettyacademy.com/client/");
		l.login("mansa123@gmail.com"," Mansa123");
		driver.findElement(By.id("userEmail")).sendKeys("mansa123@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Mansa123");
		driver.findElement(By.name("login")).click();
		Thread.sleep(1000);
		List<WebElement> addToCart=driver.findElements(By.cssSelector(".mb-3"));
		
        WebElement Prod=addToCart.stream().filter(cart->cart.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
        Prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-message")));
        String successmsg=driver.findElement(By.cssSelector(".toast-message")).getText();
	Assert.assertEquals(successmsg, "Product Added To Cart");
	Thread.sleep(1000);
	driver.findElement(By.cssSelector("[routerlink*=\"cart\"]")).click();
List<WebElement> cartProduct=	driver.findElements(By.cssSelector(".cartSection h3"));

Boolean match=cartProduct.stream().anyMatch(cartnew->cartnew.getText().equals(ProductName));
Assert.assertTrue(match);
Thread.sleep(2000);
driver.findElement(By.cssSelector(".totalRow button")).click();
Actions a=new Actions(driver);
a.sendKeys(driver.findElement(By.cssSelector("[placeholder=\"Select Country\"]")), "India").build().perform();
Thread.sleep(3000);
//driver.findElement(By.cssSelector("[placeholder=\"Select Country\"]")).sendKeys("Ind");
driver.findElement(By.xpath("//*[@class=\"ta-results list-group ng-star-inserted\"]//button[2]")).click();
driver.findElement(By.cssSelector(".action__submit ")).click();
String ConfirmationMsg=driver.findElement(By.cssSelector(".hero-primary")).getText();
Assert.assertTrue(ConfirmationMsg.equalsIgnoreCase("Thankyou for the order."));
//List<WebElement> suggestionsDropDown=driver.findElements(By.cssSelector(".ta-results .ta-item"));
//eSystem.out.println(suggestionsDropDown);
//suggestionsDropDown.stream().filter(search->search.equals("India")).

	//driver.close();
        
       // driver.findElement(By.cssSelector(".totalRow .btn-primary")).click();

//		for(int i=0;i<addToCart.size();i++)
//		{
//			addToCart.get(i).click();
//			String successmsg=driver.findElement(By.xpath("//div[@class=\"ng-tns-c4-9 toast-message ng-star-inserted\"]")).getText();
//			Assert.assertEquals(successmsg, "Product Added To Cart");
//		}
//		
//		Thread.sleep(5000);
		

	}

}
