package LearnFramework.SeleniumFrameworkETE;

import java.io.IOException;
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
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import LearnFramework.BaseTest.baseTest;

public class ErrorValidation extends baseTest{
	String ProductName="ADIDAS ORIGINAL";
	String ToastMsgExp="Product Added To Cart";

	//@Test(groups= {"smoke"})
	
	//For checking the retry mechanism
//	@Test(retryAnalyzer=Retry.class)
	@Test
	public void validateLoginErrorMsg() throws IOException, InterruptedException
	{
		
		String ProductName="ADIDAS ORIGINAL";
		String ToastMsgExp="Product Added To Cart";
		String ConfirmationMsgExp="Thankyou for the order.";
		
		//loginPage loginP=launchApplication();
		
	 loginP.login("mansa123@gmail.com","Mansa1234");
	 
	String errormsg= loginP.wrongPwdErrorMsg();
	Assert.assertEquals(errormsg, "Incorrect email or password.");
	}

   @Test(enabled=false)
   public void validateSubmitOrderErrorMsg()
   {
	   Product p=loginP.login("mansa123@gmail.com","Mansa123");
		List<WebElement> listOfElement=p.getProductList();
		p.getProductName(ProductName);
		 p.verifyToastMsg(ToastMsgExp); 
   }






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


